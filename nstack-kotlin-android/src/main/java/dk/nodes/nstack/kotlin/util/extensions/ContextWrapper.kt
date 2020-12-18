package dk.nodes.nstack.kotlin.util.extensions

import android.content.Context
import android.os.Handler

internal class ContextWrapper(
    val context: Context
) {

    private var handler: Handler = Handler()

    val assets: List<String>
        get() {
            return context.resources.assets.list("")?.asList() ?: listOf()
        }

    fun readAsset(path: String): String {
        val inputStream = context.resources.assets.open(path)
        return inputStream.bufferedReader().use { it.readText() }
    }

    fun runUiAction(action: () -> Unit) {
        handler.post {
            action()
        }
    }

    fun getBuildConfigValue(fieldName: String): Any? {
        return try {
            val className = context.applicationContext.javaClass.`package`?.name + ".BuildConfig"
            val clazz = Class.forName(className)
            val field = clazz.getField(fieldName)
            field.get(null)
        } catch (e: Exception) {
            null
        }
    }
}
