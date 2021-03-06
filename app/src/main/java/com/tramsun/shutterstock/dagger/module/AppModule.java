package com.tramsun.shutterstock.dagger.module;

import android.content.Context;
import com.squareup.picasso.Picasso;
import com.tramsun.shutterstock.ShutterApp;
import com.tramsun.shutterstock.dagger.qualifier.ApplicationContext;
import com.tramsun.shutterstock.remote.OkHttp3Downloader;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;

@Module public final class AppModule {
  private final ShutterApp app;

  public AppModule(ShutterApp app) {
    this.app = app;
  }

  @Provides @Singleton @ApplicationContext Context provideContext() {
    return app;
  }

  @Provides @Singleton Picasso providePicasso(OkHttpClient okHttpClient) {
    return new Picasso.Builder(app).downloader(new OkHttp3Downloader(okHttpClient)).build();
  }
}
