package dk.nodes.nstack.kotlin.managers

import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class NetworkManagerImplTest {

    private val okHttpClient = OkHttpClient()
    private val baseUrl = "httpUrl"
    private val networkManager = NetworkManagerImpl(okHttpClient, baseUrl, false)
    val mockServer = MockWebServer().apply {
        url(baseUrl)
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadTranslation() {
    }

    @Test
    fun loadTranslation1() {
    }

    @Test
    fun postAppOpen() {
    }

    @Test
    fun postAppOpen1() {
    }

    @Test
    fun postMessageSeen() {
    }

    @Test
    fun postRateReminderSeen() {
    }

    @Test
    fun getResponse() {
    }

    @Test
    fun getResponseSync() {
    }

    @Test
    fun postProposal() {
    }

    @Test
    fun fetchProposals() {
    }
}