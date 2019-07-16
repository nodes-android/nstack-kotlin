package dk.nodes.nstack.kotlin.managers

import dk.nodes.nstack.ApiClient
import dk.nodes.nstack.kotlin.NStack
import dk.nodes.nstack.kotlin.util.NLog
import dk.nodes.nstack.models.AppOpenSettings
import dk.nodes.nstack.models.AppUpdateData
import dk.nodes.nstack.shared.ApplicationDispatcher
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NetworkManager {

    private val client = HttpClient()
    private val nstackApi = ApiClient(
        NStack.baseUrl + "/api", NStack.appIdKey,
        NStack.appApiKey, client
    )

    fun loadTranslation(url: String, onSuccess: (String) -> Unit, onError: (Exception) -> Unit) {

        GlobalScope.launch (ApplicationDispatcher) {
            try {

            } catch ()
            client.get<String>(Url(url)) {

            }
        }
        nstackApi.loadTranslation(Url(url), onSuccess, onError)
//        client.newCall(Request.Builder().url(url).build())
//            .enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    onError(e)
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    try {
//                        val translations = response.body()!!.string().asJsonObject!!.getJSONObject("data")
//                        onSuccess(translations.toString())
//                    } catch (e: Exception) {
//                        onError(e)
//                    }
//                }
//            })
    }

    fun postAppOpen(
        settings: AppOpenSettings,
        acceptLanguage: String,
        onSuccess: (AppUpdateData) -> Unit,
        onError: (Exception) -> Unit
    ) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                val response = nstackApi.postAppOpen(
                    acceptLanguage,
                    settings.platform,
                    settings.guid,
                    settings.version,
                    settings.old_version,
                    settings.last_updated
                )
                onSuccess(response.data)
            } catch (ex: Exception) {
                onError(ex)
            }
        }
    }

    /**
     * Notifies the backend that the message has been seen
     */
    fun postMessageSeen(guid: String, messageId: Int) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                nstackApi.postNotifyMessagesViews(guid.toInt(), messageId)
                NLog.v(this, "Message seen")
            } catch (ex: Exception) {
                NLog.e(this, "Failure posting message seen", ex)
            }
        }
    }

    /**
     * Notifies the backend that the rate reminder has been seen
     */
    fun postRateReminderSeen(appOpenSettings: AppOpenSettings, rated: Boolean) {
        GlobalScope.launch(ApplicationDispatcher) {
            try {
                nstackApi.postNotifyRateReminderViews(
                    guid = appOpenSettings.guid.toInt(),
                    platform = appOpenSettings.platform,
                    answer = if (rated) "yes" else "no"
                )
                NLog.v(this, "Rate reminder seen")
            } catch (ex: Exception) {
                NLog.e(this, "Failure posting rate reminder seen", ex)
            }

        }
    }
}
