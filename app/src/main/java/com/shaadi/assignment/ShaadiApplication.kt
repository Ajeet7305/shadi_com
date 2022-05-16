@file:Suppress("unused")
package com.shaadi.assignment

import android.app.Application
import com.shaadi.assignment.di.networkModule
import com.shaadi.assignment.di.persistenceModule
import com.shaadi.assignment.di.repositoryModule
import com.shaadi.assignment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class ShaadiApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@ShaadiApplication)
      modules(networkModule)
      modules(persistenceModule)
      modules(repositoryModule)
      modules(viewModelModule)
    }

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
