// Generated by data binding compiler. Do not edit!
package com.example.android.dessertclicker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.android.dessertclicker.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final TextView amountSoldText;

  @NonNull
  public final ImageView backgroundImage;

  @NonNull
  public final TextView dessertSoldText;

  @NonNull
  public final ImageButton enemy;

  @NonNull
  public final TextView health;

  @NonNull
  public final ProgressBar hitPoints;

  @NonNull
  public final ImageView mainChar;

  @NonNull
  public final Guideline marginBottomGuide;

  @NonNull
  public final Guideline marginEndGuide;

  @NonNull
  public final Guideline marginStartGuide;

  @NonNull
  public final Button power;

  @NonNull
  public final ConstraintLayout progressDet;

  @NonNull
  public final TextView revenueText;

  @NonNull
  public final View whiteBackground;

  @Bindable
  protected Integer mRevenue;

  @Bindable
  protected Integer mAmountSold;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView amountSoldText, ImageView backgroundImage, TextView dessertSoldText,
      ImageButton enemy, TextView health, ProgressBar hitPoints, ImageView mainChar,
      Guideline marginBottomGuide, Guideline marginEndGuide, Guideline marginStartGuide,
      Button power, ConstraintLayout progressDet, TextView revenueText, View whiteBackground) {
    super(_bindingComponent, _root, _localFieldCount);
    this.amountSoldText = amountSoldText;
    this.backgroundImage = backgroundImage;
    this.dessertSoldText = dessertSoldText;
    this.enemy = enemy;
    this.health = health;
    this.hitPoints = hitPoints;
    this.mainChar = mainChar;
    this.marginBottomGuide = marginBottomGuide;
    this.marginEndGuide = marginEndGuide;
    this.marginStartGuide = marginStartGuide;
    this.power = power;
    this.progressDet = progressDet;
    this.revenueText = revenueText;
    this.whiteBackground = whiteBackground;
  }

  public abstract void setRevenue(@Nullable Integer revenue);

  @Nullable
  public Integer getRevenue() {
    return mRevenue;
  }

  public abstract void setAmountSold(@Nullable Integer amountSold);

  @Nullable
  public Integer getAmountSold() {
    return mAmountSold;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}
