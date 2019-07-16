package dk.nodes.nstack.shared

import android.os.Build
import dk.nodes.nstack.kotlin.NStack
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default
internal actual val nMeta: String = "android;${NStack.env};${NStack.getAppClientInfo().versionName};${Build.VERSION.RELEASE};${Build.MODEL}"