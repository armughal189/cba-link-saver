package io.multidev134.link_saver

import android.app.Application
import io.multidev134.link_saver.core.database.DbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.annotation.KoinApplication
import org.koin.plugin.module.dsl.startKoin

@KoinApplication(
  modules = [DbModule::class]
)
class MainApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin<MainApplication> {
      androidContext(this@MainApplication)
    }
  }
}
