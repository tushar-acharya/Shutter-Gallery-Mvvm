package com.tramsun.shutterstock.dagger.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tramsun.shutterstock.dagger.scope.ActivityScope;
import com.tramsun.shutterstock.feature.base.navigator.ActivityNavigator;
import com.tramsun.shutterstock.feature.base.navigator.Navigator;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {

  private final AppCompatActivity activity;

  public ActivityModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides Activity provideActivity() {
    return activity;
  }

  @Provides @ActivityScope Navigator provideNavigator() {
    return new ActivityNavigator(activity);
  }

  @Provides @ActivityScope RxPermissions provideRxPermissions() {
    return new RxPermissions(activity);
  }
}
