/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dessertclicker

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.example.android.dessertclicker.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var hitPoints:Int = 100
    private var revenue = 0
    private var enemyKilled = 0

    // Contains all the views
    private lateinit var binding: ActivityMainBinding

    /** Dessert Data **/

    /**
     * Simple data class that represents a dessert. Includes the resource id integer associated with
     * the image, the price it's sold for, and the startProductionAmount, which determines when
     * the dessert starts to be produced.
     */
    data class Enemies(val imageId: Int, val points: Int, val startProductionAmount: Int)

    // Create a list of all desserts, in order of when they start being produced
    private val allEnemies = listOf(
        Enemies(R.drawable.enemy1_stay, 5, 0),
        Enemies(R.drawable.stay2, 10, 3),
        Enemies(R.drawable.enemy3, 15, 5),
        Enemies(R.drawable.enemy4, 30, 8),
        Enemies(R.drawable.enemy5, 50, 10)
    )

    private var currentEnemy = allEnemies[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use Data Binding to get reference to the views
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainChar.setImageResource(R.drawable.ms_stay)
        binding.enemy.setOnClickListener {
            onEnemyClicked()
        }

        // Set the TextViews to the right values
        binding.revenue = revenue
        binding.amountSold = enemyKilled

        showHitPoints()
        // Make sure the correct dessert is showing
        binding.enemy.setImageResource(currentEnemy.imageId)
    }

    private fun heroAnimate() {
//        Handler().postDelayed({
//            mainChar.setImageResource(R.drawable.ms_stay2)
//        }, 1000)
//        Handler().postDelayed({
//            mainChar.setImageResource(R.drawable.prepare)
//        }, 1000)
//        Handler().postDelayed({
//            mainChar.setImageResource(R.drawable.prepare2)
//        }, 1000)
        Handler().postDelayed({
            mainChar.setImageResource(R.drawable.attack1)
        }, 200)
//        Handler().postDelayed({
//            mainChar.setImageResource(R.drawable.endattack)
//        }, 1000)
    }
    /**
     * Updates the score when the dessert is clicked. Possibly shows a new dessert.
     */
    private fun heroStay() {
        mainChar.setImageResource(R.drawable.ms_stay)
    }

    private fun showHitPoints() {
        binding.hitPoints.progress = hitPoints
        binding.health.text = "$hitPoints"
    }

//    private fun enemyHurt() {
//        Handler().postDelayed({
//            mainChar.setImageResource(R.drawable.hu)
//        }, 500)
//    }

    private fun onEnemyClicked() {

        // Update the score
        hitPoints -= 10

        showHitPoints()

        if (hitPoints < 1) {
            revenue += currentEnemy.points
            enemyKilled++

            binding.revenue = revenue
            binding.amountSold = enemyKilled
            Log.i("tag","Enemy is destroyed!")
            showCurrentEnemy()
        }
        // Show the next dessert
        heroAnimate()
        heroStay()
    }

    /**
     * Determine which dessert to show.
     */
    private fun showCurrentEnemy() {
        var newEnemy = allEnemies[0]
        for (enemy in allEnemies) {
            if (enemyKilled >= enemy.startProductionAmount) {
                newEnemy = enemy
                hitPoints = 100
                showHitPoints()
            }
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            else break
        }

        // If the new dessert is actually different than the current dessert, update the image
        if (newEnemy != currentEnemy) {
            currentEnemy = newEnemy
            binding.enemy.setImageResource(newEnemy.imageId)
        }
    }

    /**
     * Menu methods
     */
    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText(getString(R.string.share_text, enemyKilled, revenue))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenuButton -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

}

private fun ImageView.setImageDrawable(attack1: Int) {

}
