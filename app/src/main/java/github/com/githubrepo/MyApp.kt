package github.com.githubrepo

import android.app.Application
import org.koin.core.context.startKoin
import github.com.githubrepo.di.myModule

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        //use koin and start it here
        startKoin {
            modules(myModule)
        }
    }
}