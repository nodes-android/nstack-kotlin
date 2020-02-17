package dk.nodes.nstack.demo

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.coroutineScope
import dk.nodes.nstack.kotlin.NStack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        NStack.baseUrl = "https://nstack-staging.vapor.cloud"
        NStack.translationClass = Translation::class.java
        NStack.init(this, BuildConfig.DEBUG)
        if (BuildConfig.DEBUG) {
            NStack.enableMenuOnShake(this)
        }
        ProcessLifecycleOwner.get().lifecycle.coroutineScope.launch(Dispatchers.IO) {
            NStack.appOpen()
        }
    }
}
