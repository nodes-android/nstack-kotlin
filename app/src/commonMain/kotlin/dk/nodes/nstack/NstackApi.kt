package dk.nodes.nstack

import dk.nodes.nstack.models.AppUpdateResponse
import dk.nodes.nstack.models.Messages
import dk.nodes.nstack.models.PushLogsRequest
import dk.nodes.nstack.models.UntitledExample
import dk.nodes.nstack.shared.nMeta
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.contentType

/**
 * API Copy Client
 *
 * TODO: Add Description
 */
class ApiClient(
    private val endpoint: String,
    private val applicationId: String,
    private val apiKey: String,
    private val client: HttpClient
) {

    private val headers: Headers = Headers.build {
        this["X-Application-Id"] = applicationId
        this["X-Rest-Api-Key"] = apiKey
    }

    private val defaultHeaders = mapOf(
        "X-Application-Id" to applicationId,
        "X-Rest-Api-Key" to apiKey
    )

    /**
     * View
     *
     * Get a default type of content collection
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v2/content/responses/{collection_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     *
     * @return
     */
    suspend fun getContentCollections(collectionId: String) {
        return client.get("$endpoint/v2/content/collections/$collectionId") {
            addDefaultHeader()
        }
    }

    /**
     * Create item
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v2/content/responses/{collection_id}/items`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Post params
     *
     * `All required keys`
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collectio does not have write access for api
     *
     * `404` Entity not found
     *
     * `412` Precondition failed _Please read response message_
     *
     * `500` Internal server error _Please read response message_
     *
     * @param k0int
     * @param key1string
     * @param key2float
     * @param key3wysiwygsim
     * @param key4asset
     * @param key5boolean
     * @param key6wysiwygadvanced
     *
     * @return
     */
    suspend fun postContentCollectionsItems(
        k0int: Int, // FORM_DATA
        key1string: String, // FORM_DATA
        key2float: Double, // FORM_DATA
        key3wysiwygsim: String, // FORM_DATA
        key4asset: String, // FORM_DATA
        key5boolean: Boolean, // FORM_DATA
        key6wysiwygadvanced: String, // FORM_DATA
        collectionId: Int
    ) {
        return client.post("$endpoint/v2/content/collections/$collectionId/items") {
            addDefaultHeader()
            formData {
                append("k0int", k0int)
                append("key1string", key1string)
                append("key2float", key2float)
                append("key3wysiwygsim", key3wysiwygsim)
                append("key4asset", key4asset)
                append("key5boolean", key5boolean.toString())
                append("key6wysiwygadvanced", key6wysiwygadvanced)
            }
        }
    }

    /**
     * Delete item
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `DELETE`
     *
     * URL: `api/v2/content/responses/{collection_id}/items{item_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * `item_id` (int) **required** _ID of content collection item_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collection does not have write access for api
     *
     * `404` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param collectionId
     * @param itemId
     *
     * @return
     */
    suspend fun deleteContentCollectionsItems(collectionId: Int, itemId: Int) {
        return client.delete("$endpoint/v2/content/collections/$collectionId/items/$itemId") {
            addDefaultHeader()
        }
    }

    /**
     * Update
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v2/content/responses/{collection_id}/items`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Post params
     *
     * `All required keys`
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collectio does not have write access for api
     *
     * `404` Entity not found
     *
     * `412` Precondition failed _Please read response message_
     *
     * `500` Internal server error _Please read response message_
     *
     * @param Content-Type
     * @param k0int
     * @param key1string
     * @param key2float
     * @param key3wysiwygsim
     * @param key4asset
     * @param key5boolean
     * @param key6wysiwygadvanced
     * @param collectionId
     * @param itemId
     * @return
     */
    suspend fun postContentCollectionsItemsUpdate(
        contentType: ContentType = ContentType.Application.Json, // HEADER
        k0int: Int, // FORM_DATA
        key1string: String, // FORM_DATA
        key2float: Double, // FORM_DATA
        key3wysiwygsim: String, // FORM_DATA
        key4asset: String, // FORM_DATA
        key5boolean: Boolean, // FORM_DATA
        key6wysiwygadvanced: String, // FORM_DATA
        collectionId: Int,
        itemId: Int
    ) {
        return client.post("$endpoint/v2/content/collections/$collectionId/items/$itemId/update") {
            addDefaultHeader()
            contentType(contentType)
            formData {
                append("k0int", k0int)
                append("key1string", key1string)
                append("key2float", key2float)
                append("key3wysiwygsim", key3wysiwygsim)
                append("key4asset", key4asset)
                append("key5boolean", key5boolean.toString())
                append("key6wysiwygadvanced", key6wysiwygadvanced)
            }
        }
    }

    /**
     * View item
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v2/content/responses/{collection_id}/items{item_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * `item_id` (int) **required** _ID of content collection item_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collection does not have write access for api
     * `445` Entity not found
     *
     * @param collectionId
     * @param itemId
     *
     * @return
     */
    suspend fun getContentCollectionsItems(collectionId: Int, itemId: Int) {
        return client.get("$endpoint/v2/content/collections/$collectionId/items/$itemId") {
            addDefaultHeader()
        }
    }

    /**
     * View1
     *
     * Get a default type of content collection
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v1/content/responses/{collection_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param collectionId
     *
     * @return
     */
    suspend fun getContentCollections(collectionId: Int) {
        return client.get("$endpoint/v1/content/collections/$collectionId") {
            addDefaultHeader()
        }
    }

    /**
     * Create item1
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v1/content/responses/{collection_id}/items`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Post params
     *
     * `All required keys`
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collectio does not have write access for api
     *
     * `412` Precondition failed _Please read response message_
     *
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     * @param k0int
     * @param key1string
     * @param key2float
     * @param key3wysiwygsim
     * @param key4asset
     * @param key5boolean
     * @param key6wysiwygadvanced
     * @param collectionId
     *
     * @return
     */

    suspend fun postContentCollectionsItemsV1(
        k0int: Int, // FORM_DATA
        key1string: String, // FORM_DATA
        key2float: Double, // FORM_DATA
        key3wysiwygsim: String, // FORM_DATA
        key4asset: String, // FORM_DATA
        key5boolean: Boolean, // FORM_DATA
        key6wysiwygadvanced: String, // FORM_DATA
        collectionId: Int
    ) {
        return client.post("$endpoint/v1/content/collections/$collectionId/items") {
            addDefaultHeader()
            formData {
                append("k0int", k0int)
                append("key1string", key1string)
                append("key2float", key2float)
                append("key3wysiwygsim", key3wysiwygsim)
                append("key4asset", key4asset)
                append("key5boolean", key5boolean.toString())
                append("key6wysiwygadvanced", key6wysiwygadvanced)
            }
        }
    }

    /**
     * Delete item1
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `DELETE`
     *
     * URL: `api/v1/content/responses/{collection_id}/items{item_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * `item_id` (int) **required** _ID of content collection item_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collection does not have write access for api
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     * @param collectionId
     * @param itemId
     *
     * @return
     */
    suspend fun v1DeleteContentCollectionsItems(
        collectionId: Int,
        itemId: Int
    ) {
        return client.delete("$endpoint/v1/content/collections/$collectionId/items/$itemId") {
            addDefaultHeader()
        }
    }

    /**
     * Update1
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v1/content/responses/{collection_id}/items`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * #### Post params
     *
     * `All required keys`
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collectio does not have write access for api
     *
     * `412` Precondition failed _Please read response message_
     *
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     * @param Content-Type
     * @param k0int
     * @param key1string
     * @param key2float
     * @param key3wysiwygsim
     * @param key4asset
     * @param key5boolean
     * @param key6wysiwygadvanced
     * @param collectionId
     * @param itemId
     *
     * @return
     */
    suspend fun v1ContentCollections1Items14UpdatePost(
        contentType: ContentType = ContentType.Application.Json, // HEADER
        k0int: Int, // FORM_DATA
        key1string: String, // FORM_DATA
        key2float: Double, // FORM_DATA
        key3wysiwygsim: String, // FORM_DATA
        key4asset: String, // FORM_DATA
        key5boolean: Boolean, // FORM_DATA
        key6wysiwygadvanced: String, // FORM_DATA
        collectionId: Int,
        itemId: Int
    ) {
        return client.post("$endpoint/v1/content/collections/$collectionId/items/$itemId/update") {
            addDefaultHeader()
            contentType(contentType)
            formData {
                append("k0int", k0int)
                append("key1string", key1string)
                append("key2float", key2float)
                append("key3wysiwygsim", key3wysiwygsim)
                append("key4asset", key4asset)
                append("key5boolean", key5boolean.toString())
                append("key6wysiwygadvanced", key6wysiwygadvanced)
            }
        }
    }

    /**
     * View item1
     *
     * Create a new item to a array type collection
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v1/content/responses/{collection_id}/items{item_id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `collection_id` (int) **required** _ID of content collection_
     *
     * `item_id` (int) **required** _ID of content collection item_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `401` Collection does not have write access for api
     * `445` Entity not found
     *
     * @param collectionId
     * @param itemId
     *
     * @return
     */
    suspend fun v1GetContentCollections1Items5(
        collectionId: Int,
        itemId: Int
    ) {
        return client.get("$endpoint/v1/content/collections/$collectionId/items/$itemId") {
            addDefaultHeader()
        }
    }

    /**
     * Show
     *
     * Get one response
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v2/content/responses/{id_or_slug}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `id_or_slug` (string/int) **required** _ID or slug of content type [15, "terms", "about"]_
     *
     * #### Query params
     * `data` (bool) **option** _defaul true - should the object be in data_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param contentType
     * @param idOrSlug
     *
     * @return
     */
    suspend fun getContentResponses(
        contentType: ContentType = ContentType.Application.Json, // HEADER
        idOrSlug: String

    ) {
        return client.get("$endpoint/v2/content/responses/$idOrSlug") {
            addDefaultHeader()
            contentType(contentType)
        }
    }

    /**
     * Show1
     *
     * Get one response
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v1/content/responses/{id_or_slug}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `id_or_slug` (string/int) **required** _ID or slug of content type [15, "terms", "about"]_
     *
     * #### Query params
     * `data` (bool) **option** _defaul true - should the object be in data_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param contentType
     * @param idOrSlug
     *
     * @return
     */
    suspend fun v1ContentResponses15Get(
        contentType: ContentType = ContentType.Application.Json,
        idOrSlug: String
    ) {
        return client.get("$endpoint/v1/content/responses/$idOrSlug") {
            addDefaultHeader()
            contentType(contentType)
        }
    }

    /**
     * Store
     *
     * Store a file
     *
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v2/content/responses/files`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Post params
     * `name` (string) **required**
     *
     * `tags` (string, comma seperated) **optional**
     *
     * `goneAt` (date-time 2019-01-01 00:00:00) **optional**
     *
     * `privacy` (string [public,public-cdn,private,private-password]) **required**
     *
     * `file` (file, max 30mb) **required**
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `412` Validation error
     *
     * `500` Internal server error _Please read response message_
     *
     * @param contentType
     * @param name
     * @param tags
     * @param goneAt
     * @param file
     * @param privacy
     *
     * @return
     */
    suspend fun postContentFiles(
        contentType: ContentType = ContentType.Application.Json, // HEADER
        name: String, // FORM_DATA
        tags: String, // FORM_DATA
        goneAt: String, // FORM_DATA
        file: String, // FORM_DATA
        privacy: String // FORM_DATA
    ) {
        return client.post("$endpoint/v2/content/files") {
            addDefaultHeader()
            contentType(contentType)
            formData {
                append("name", name)
                append("tags", tags)
                append("goneAt", goneAt)
                append("file", file)
                append("privacy", privacy)
            }
        }
    }

    /**
     * Store with path
     *
     * Store a file with path
     *
     * #### Request details
     * Method: `POST`
     *
     * URL: `api/v2/content/responses/files/path`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Post params
     * `name` (string) **required**
     *
     * `tags` (string, comma seperated) **optional**
     *
     * `gone_at` (date-time 2019-01-01 00:00:00) **optional**
     *
     * `privacy` (string [public,public-cdn,private,private-password]) **required**
     *
     * `path` (string) **required**
     *
     * `mime` (string) **required**
     *
     * `size` (int) **required**
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` File in path not found
     *
     * `409` Path should start with applicationId
     *
     * `412` Validation error
     *
     * `500` Internal server error _Please read response message_
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     * @param Content-Type
     * @param name
     * @param tags
     * @param gone_at
     *
     * @return
     */
    suspend fun v1PostContentFiles(
        contentType: ContentType = ContentType.Application.Json, // HEADER
        name: String, // FORM_DATA
        tags: String, // FORM_DATA
        goneAt: String // FORM_DATA
    ) {
        return client.post("$endpoint/v1/content/files") {
            addDefaultHeader()
            contentType(contentType)
            formData {
                append("name", name)
                append("tags", tags)
                append("goneAt", goneAt)

            }
        }
    }

    /**
     * Index languages
     *
     * Get available languages for a platfom
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/v1/content/localize/{platform-slug}/languages`
     *
     * #### Headers
     *
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * #### Query params
     * `show_inactive_languages` (bool)
     *
     * #### URL Parameters
     * `platform-slug` (string) **required**
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `404` Entity not found
     *
     * @return
     */
    suspend fun getContentLocalizeMobileLanguages() {
        return client.get("$endpoint/v2/content/localize/mobile/languages") {
            addDefaultHeader()
        }
    }

    /**
     * Language best fit
     *
     * Get best fit language from accept-language header
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v1/content/localize/{platform-slug}/languages/best_fit`
     *
     * #### Headers
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * `Accept-Language or X-Accept-Language`
     *
     * #### URL Parameters
     * `platform-slug` (string) **required**
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `404` Entity not found
     *
     * @return
     */
    suspend fun contentLocalizeMobileLanguagesBestFitGet() {
        return client.get("$endpoint/v2/content/localize/mobile/languages/best_fit") {
            addDefaultHeader()
        }
    }

    /**
     * Index resource
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/v2/content/localize/resources/platforms/{platformSlug}`
     *
     * ### Url param
     *
     * `platformSlug` (string) **required** *eg: mobile, backend, web*
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * ### Query
     *
     * `last_updated` (date time, ISO8601) **optional** *eg: 2019-06-21T08%3A35%3A24%2B00%3A00*
     *  - *Remember to url encode it*
     *  - *Set timestamp from last app open (when localization has been synced), this will calculate which localizations should be updated*
     *
     * `dev` (bool) **option, default false**
     *  - *if true, bypass publishes and only use newest resource (set of key/values)*
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `404` platform not found
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     *
     * @return
     */
    suspend fun contentLocalizeResourcesPlatformsMobileGet() {
        return client.get("$endpoint/v2/content/localize/resources/platforms/mobile") {
            addDefaultHeader()
        }
    }

    /**
     * Show resource
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/v2/content/localize/resources/{id}`
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `404` Not found
     * @param
     * @return
     */
    suspend fun getContentLocalizeResources(id: Int) {
        return client.get("$endpoint/v2/content/localize/resources/$id") {
            addDefaultHeader()
        }
    }

    /**
     * Store proposal
     *
     * #### Request details
     *
     * Method:    `POST`
     *
     * URL:    `/api/v2/content/localize/proposals`
     *
     * #### Post params
     * `key` (string) **required** *format: section.key, eg: `versionControl.forceHeader`*
     *
     * `value` (string) **required**
     *
     * `locale` (string) **required**  *eg: da-DK, en-GB*
     *
     * `platform` (string) **required** *eg: mobile, backend, web*
     *
     * #### Response codes(s)
     *
     * `201` Created
     *
     * `412` Preconitions failed
     *
     * @param key
     * @param value
     * @param locale
     * @param platform
     * @param guid
     *
     * @return
     */
    suspend fun postContentLocalizeProposals(
        key: String, // FORM_DATA
        value: String, // FORM_DATA
        locale: String, // FORM_DATA
        platform: String, // FORM_DATA
        guid: String // FORM_DATA
    ) {
        return client.post("$endpoint/v2/content/localize/proposals") {
            addDefaultHeader()
            formData {
                append("key", key)
                append("value", value)
                append("locale", locale)
                append("platform", platform)
                append("guid", guid)
            }
        }
    }

    /**
     * Index proposal
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/v2/content/localize/proposals`
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * @return
     */
    suspend fun contentLocalizeProposalsGet() {
        return client.get("$endpoint/v2/content/localize/proposals") {
            addDefaultHeader()
        }
    }

    /**
     * Index languages1
     *
     * Get available languages for a platfom
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/v1/translate/{platform-slug}/languages`
     *
     * #### Headers
     *
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * #### Query params
     * `show_inactive_languages` (bool)
     *
     * #### URL Parameters
     * `platform-slug` (string) **required**
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * @param platformSlug
     *
     * @return
     */
    suspend fun v1LocalizeMobileLanguagesGet(platformSlug: String = "mobile") {
        return client.get("$endpoint/v1/localize/$platformSlug/languages") {
            addDefaultHeader()
        }
    }

    /**
     * Language best fit1
     *
     * Get best fit language from accept-language header
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v1/translate/{platform-slug}/languages/best_fit`
     *
     * #### Headers
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * `Accept-Language or X-Accept-Language`
     *
     * #### URL Parameters
     * `platform-slug` (string) **required**
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * @param platformSlug
     *
     * @return
     */
    suspend fun v1GetLocalizeLanguagesBestFit(platformSlug: String = "mobile") {
        return client.get("$endpoint/v1/localize/$platformSlug/languages/best_fit") {
            addDefaultHeader()
        }
    }

    /**
     * Keys
     *
     * #### Request details
     *
     * Method:    `GET`
     *
     * URL:    `/api/translate/{platform-slug}/keys`
     *
     * #### Headers
     *
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * `Accept-Language or X-Accept-Language`
     *
     * #### Query params
     * `section` (int/string) _id or slug_
     *
     * `all` (bool) _true_
     *
     * #### URL Params
     * `platform-slug` (string) **required**
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * @param all
     * @param platformSlug
     *
     * @return
     */
    suspend fun v1GetLocalizeKeys(all: Boolean = true, platformSlug: String = "mobile") {
        return client.get("$endpoint/v1/localize/$platformSlug/keys") {
            addDefaultHeader()
            url {
                parameters.apply {
                    append("all", "$all")
                }
            }
        }
    }

    /**
     * Keys & values for section
     *
     * TODO: Add Description
     *
     * @param acceptLanguage
     *
     * @return
     */
    suspend fun v1LocalizeBackendKeysDefault(
        acceptLanguage: String // HEADER
    ): UntitledExample {
        return client.get("$endpoint/v1/localize/backend/keys/default") {
            addDefaultHeader()
            header("Accept-Language", acceptLanguage)
        }
    }

    /**
     * Visualization
     *
     * Get visualization
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v2/content/dashboards/visualizations/{key}`
     *
     * #### URL Parameters
     * `key` (string) **required**
     *
     * ### Query parameters
     *
     * `mode` (string) **Optional**
     *  - standard (default), using cache data
     *  - fresh, force using fresh data
     *  - test, fake data
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * @param contentType
     * @param key
     *
     * @return
     */
    suspend fun getContentDashboardsVisualizations(
        contentType: ContentType = ContentType.Application.Json,
        key: String
    ) {
        return client.get("$endpoint/v2/content/dashboards/visualizations/$key") {
            addDefaultHeader()
            contentType(contentType)
        }
    }

    /**
     * Dashboard
     *
     * Get Dashboard
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `api/v2/content/dashboards/{key}`
     *
     * #### URL Parameters
     * `key` (string) **required**
     *
     * `mode` (string) **Optional**
     *  - standard (default), using cache data
     *  - fresh, force using fresh data
     *  - test, fake data
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * @param contentType
     * @param key
     *
     * @return
     */
    suspend fun getContentDashboards(
        contentType: ContentType = ContentType.Application.Json,
        key: String
    ) {
        return client.get("$endpoint/v2/content/dashboards/$key") {
            addDefaultHeader()
            contentType(contentType)
        }
    }

    /**
     * Index update
     *
     * Get app updated
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/notify/updates`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters
     * `platform` (string) **required** _["ios", "android", "windows"]_
     *
     * `currentVersion` (string) **required** _Current version of app making the request_
     *
     * `lastVersion` (string) _[?]_
     *
     * `test` (bool) _Enable test mode, false equals production_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * @param platform
     * @param currentVersion
     * @param lastVersion
     *
     * @return
     */
    suspend fun getNotifyUpdates(
        platform: String, // QUERY
        currentVersion: Double, // QUERY
        lastVersion: Double // QUERY
    ) {
        return client.get("$endpoint/v2/notify/updates") {
            addDefaultHeader()
            url {
                parameters.apply {
                    append("platform", platform)
                    append("current_version", "$currentVersion")
                    append("last_version", "$lastVersion")
                }
            }
        }
    }

    /**
     * Mark update as seen
     *
     * Register a view update
     *
     * #### Request details
     * Method:    `POST`
     *
     * URL:    `/api/v2/notify/updates/views`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Parameters
     * `guid` (int) **required** _[?]_
     *
     * `updateId` (int) **required** _Id of update where view was updated_
     *
     * `answer` (string) **required** _["no", "yes"]_
     *
     * `type` (string) **required** _["newer_version", "new_in_version"]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * @param X-Application-Id
     * @param X-Rest-Api-Key
     * @param guid
     * @param updateId
     * @param answer
     * @param type
     *
     * @return
     */
    suspend fun v2NotifyUpdatesViewsPost(
        guid: Int, // FORM_DATA
        updateId: Int, // FORM_DATA
        answer: String, // FORM_DATA
        type: String // FORM_DATA
    ) {
        return client.post("$endpoint/v2/notify/updates/views") {
            addDefaultHeader()
            formData {
                append("guid", guid)
                append("update_id", updateId)
                append("answer", answer)
                append("type", type)
            }
        }
    }

    /**
     * Messages
     *
     * Get message
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v1/notify/messages`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters
     * `platform` (string) **required** _["ios", "android", "windows", "web"]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * @param platform
     *
     * @return
     */
    suspend fun v2NotifyMessagesGet(platform: String): Messages {
        return client.get("$endpoint/v2/notify/messages") {
            this.url {
                this.parameters.apply {
                    this.append("platform", platform)
                }
            }
        }
    }

    /**
     * View message
     *
     * Register a view update
     *
     * #### Request details
     * Method: `POST`
     *
     * URL: `/api/v2/notify/updates/views`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Parameters
     * `guid` (int) **required** _[?]_
     *
     * `messageId` **required** _[?]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * @param guid
     * @param messageId
     *
     * @return
     */
    suspend fun postNotifyMessagesViews(
        guid: Int, // FORM_DATA
        messageId: Int // FORM_DATA
    ) {
        return client.post("$endpoint/v2/notify/messages/views") {
            addDefaultHeader()
            formData {
                append("guid", guid)
                append("message_id", messageId)
            }
        }
    }

    /**
     * Show
     *
     * Get rate reminder
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `/api/v2/notify/rate_reminder`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `guid` (int?) **required** _[?]_
     *
     * `platform` (string) **required** _[is this used at all?]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * `445` Entity not found
     *
     * @param platform
     * @param guid
     *
     * @return
     */
    suspend fun v2NotifyRateReminderGet(platform: String, guid: Int) {
        return client.get("$endpoint/v2/notify/rate_reminder") {
            url {
                parameters.apply {
                    append("platform", platform)
                    append("guid", "$guid")
                }
            }
        }
    }

    /**
     * Mark as seen
     *
     * Post rate reminder
     *
     * #### Request details
     * Method: `POST`
     *
     * URL: `/api/v2/notify/rate_reminder/views`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `guid` (int?) **required** _[?]_
     *
     * `platform` (string) **required** _[is this used at all?]_
     *
     * `answer` (string) **required** _["yes", "no", "later"]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed
     *
     * `445` Entity not found
     *
     * @param guid
     * @param platform
     * @param answer
     *
     * @return
     */
    suspend fun postNotifyRateReminderViews(
        guid: Int, // FORM_DATA
        platform: String, // FORM_DATA
        answer: String // FORM_DATA
    ) {
        return client.post("$endpoint/v2/notify/rate_reminder/views") {
            addDefaultHeader()
            formData {
                append("guid", guid)
                append("platform", platform)
                append("answer", answer)
            }
        }
    }

    /**
     * Index
     *
     * Retrieve a list of valid continents on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/continents`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * @return
     */
    suspend fun getGeographicContinents() {
        return client.get("$endpoint/v2/geographic/continents") {
            addDefaultHeader()
        }
    }

    /**
     * Index
     *
     * Retrieve a list of valid countries on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/countries`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters (filters)
     * `limit` (int) _Eg: [/api/geographic/countries?limit=1] Default limit is 500_
     *
     * `order_by_column` (string) _Eg; [/api/geographic/countries?order\_by\_column=name]_
     *
     * `order_by_direction` (string) _Eg; [/api/geographic/countries?order\_by\_direction=asc]_
     *
     * `search` (string) _Eg: [/api/geographic/countries?search=Andorra]_
     *
     * `fields` (string) _Eg: [/api/geographic/countries?fields=name,code]_
     *
     * `continents` (string) _Eg: [/api/geographic/countries?continents=EU,AF]_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `412` Precondition failed _Invalid filters_
     *
     * @return
     */
    suspend fun getGeographicCountries() {
        return client.get("$endpoint/v2/geographic/countries") {
            addDefaultHeader()
        }
    }

    /**
     * Show
     *
     * Retrieve details of a specific country on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/countries/{id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### URL Parameters
     * `id` (int) **required** _Country id_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * @return
     */
    suspend fun v2GeographicCountries4Get() {
        return client.get("$endpoint/v2/geographic/countries/4") {
            addDefaultHeader()
        }
    }

    /**
     * Index
     *
     * Retrieve a list of valid languages spoken by humans on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/languages`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters (filters)
     * `limit` (int) _Eg: [/api/geographic/languages?limit=1] Default limit is 500_
     *
     * `search` (string) _Eg: [/api/geographic/languages?search=en]_
     *
     * `fields` (string) _Eg: [/api/geographic/languages?fields=name,locale]_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `412` Precondition failed _Invalid filters_
     *
     * @return
     */
    suspend fun getGeographicLanguages() {
        return client.get("$endpoint/v2/geographic/languages") {
            addDefaultHeader()
        }
    }

    /**
     * Show
     *
     * Retrieve details based on the requestee's ip address
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/ip-address`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters (filters)
     * `ip` (string) _Eg: [1.2.3.4] Default is your own_
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `404` Entity not found
     *
     * @param ip
     *
     * @return
     */
    suspend fun v2GeographicIpAddressGet(ip: String) {
        return client.get("$endpoint/v2/geographic/ip-address") {
            addDefaultHeader()
            url {
                parameters.apply {
                    append("ip", ip)
                }
            }
        }
    }

    /**
     * Index
     *
     * Retrieve a list of valid timesones on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/timezones`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters (filters)
     * `limit` (int) _Eg: [/api/geographic/timezones?limit=1] Default limit is 1000_
     *
     * `order` (string) _Eg: [/api/geographic/timezones?order=name:desc]_
     *
     * `search` (string) _[Eg: /api/geographic/timezones?search=Europe/Andorra]_
     *
     * `fields` (string) _[Eg: /api/geographic/timezones?fields=name,abbr]_
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `412` Precondition failed _Invalid filters_
     *
     * @return
     */
    suspend fun v2GeographicTimeZonesGet() {
        return client.get("$endpoint/v2/geographic/time_zones") {
            addDefaultHeader()
        }
    }

    /**
     * Show
     *
     * Retrieve details of a timezone
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/timezones/{id}`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `445` Entity not found
     *
     *
     * @return
     */
    suspend fun v2GeographicTimeZones1Get(id: Int) {
        return client.get("$endpoint/v2/geographic/time_zones/$id") {
            addDefaultHeader()
        }
    }

    /**
     * Show by lat lng
     *
     * Retrieve details of a nearest timezone by lat lng
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/geographic/timezones/by_lat_lng`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query parameters
     * `latLng` (double,double) _Eg: 55.1231,12.1231_
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `412` Preconditions Failed (Missing ?latLng=)
     *
     * `404` Entity not found
     *
     * @param latLng
     *
     * @return
     */
    suspend fun v2GeographicTimeZonesByLatLngGet(latLng: String) {
        return client.get("$endpoint/v2/geographic/time_zones/by_lat_lng") {
            url {
                parameters.apply {
                    append("lat_lng", latLng)
                }
            }
        }
    }

    /**
     * Feedback
     *
     * #### Request details
     *
     * Method:    `POST`
     *
     * URL:    `/api/v2/ugc/feedbacks`
     *
     * #### Headers
     *
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * #### Response codes(s)
     *
     * `200` OK
     *
     * `412` Validation failed
     *
     * #### Post params
     *
     * `os` (string) **optional**
     *
     * `appVersion` (string) **optional**
     *
     * `device` (string) **optional**
     *
     * `name` (string) **optional**
     *
     * `email` (string) **optional**
     *
     * `message` (string) **optional**
     *
     * `image` (jpg,jpeg,png) **optional**
     *
     * @param os
     * @param device
     * @param appVersion
     * @param name
     * @param email
     * @param message
     * @param image
     *
     * @return
     */
    suspend fun v2UgcFeedbacksPost(
        os: String? = null,
        device: String? = null,
        appVersion: String? = null,
        name: String? = null,
        email: String? = null,
        message: String? = null,
        image: String? = null
    ) {
        return client.post("$endpoint/v2/ugc/feedbacks") {
            addDefaultHeader()
            formData {
                os?.let { append("os", it) }
                device?.let { append("device", it) }
                appVersion?.let { append("app_version", it) }
                name?.let { append("name", it) }
                email?.let { append("email", it) }
                message?.let { append("message", it) }
                image?.let { append("image", it) }
            }
        }
    }

    /**
     * Result
     *
     * #### Request details
     * Method:    `POST`
     *
     * URL:    `/api/v2/ugc/feedbacks`
     *
     * #### Headers
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * #### Response codes(s)
     * `200` OK
     *
     * `412` Validation failed
     *
     * #### Post params
     * `key` (string) **required**
     *
     * `user` (string) **required**
     *
     * `answer` (string) **required**
     *
     * `points` (int) **required**
     *
     * `tag` (string) **required**
     *
     * @param key
     * @param user
     * @param answer
     * @param points
     * @param tag
     *
     * @return
     */
    suspend fun v2UgcResultsPost(
        key: String, // FORM_DATA
        user: String, // FORM_DATA
        answer: List<Int>, // FORM_DATA
        points: Int, // FORM_DATA
        tag: String // FORM_DATA
    ) {
        return client.post("$endpoint/v2/ugc/results") {
            addDefaultHeader()
            formData {
                append("key", key)
                append("user", user)
                append("answer", answer.joinToString { "," })
                append("points", points)
                append("tag", tag)
            }
        }
    }

    /**
     * Push Logs
     *
     * #### Request details
     * Method:    `POST`
     *
     * URL:    `/api/v2/ugc/push-logs`
     *
     * #### Headers
     * `X-Application-Id`
     *
     * `X-Rest-Api-Key`
     *
     * #### Response codes(s)
     * `201` Created
     *
     * `412` Validation failed
     *
     * #### Post params
     * `provider` (string) **required** (fx fcm, urban-airship)
     *
     * `key` (string) **required** (App key in fcm / ua)
     *
     * `type` (string) **required** (fx standard, freind-request, taxi-arrived etc)
     *
     * `succeeded` (bool) **required** (Did push get sent?)
     *
     * `request` (json) **optional** (Insert everything passed to provider)
     *
     * `response` (json) **optional** (Insert everything received from provider)
     *
     * `user_id` (int/string) **optional** (User id)
     *
     * `relation_type` (string) **optional** (Fx Booking, Company etc)
     *
     * `relation_id` (int) **optional** (Fx Id of Booking, id of Company etc)
     *
     * @param contentType
     * @param Body
     *
     * @return
     */
    suspend fun v2UgcPushLogsPost(
        contentType: ContentType = ContentType.Application.Json,
        body: PushLogsRequest
    ) {
        return client.post("$endpoint/v2/ugc/push-logs") {
            addDefaultHeader()
            contentType(contentType)
            this.body = body
        }
    }

    /**
     * Email
     *
     * Validate email syntax
     * On top of a simple syntax validation, there is DNS check also
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `/api/v2/validator/email`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query params
     * `email` (string) **required** _email to validate_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed (missing or invalid email)
     *
     * @param email
     *
     * @return
     */
    suspend fun v2ValidatorEmailGet(email: String) {
        return client.get("$endpoint/v2/validator/email") {
            this.url {
                addDefaultHeader()
                parameters.apply {
                    append("email", email)
                }
            }
        }
    }

    /**
     * Phone
     *
     * Validate phone number
     *
     * #### Request details
     * Method: `GET`
     *
     * URL: `/api/v2/validator/phone`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * #### Query params
     * `phone` (string) **required** _email to validate_
     *
     * `fallback_country_code` (string) _Eg: ["dk", "gb", ...] - default is dk_
     *
     * `twilio` (bool) _Validate against Twilio - Paid service!_
     *
     * `twilio_type` (string) _Eg: ["all", "mobile", "landline"]_
     *
     * #### Response codes
     * `200` OK
     *
     * `412` Precondition failed (missing or invalid email)
     *
     * @param phone
     *
     * @return
     */
    suspend fun v2ValidatorPhoneGet(phone: Int) {
        return client.get("$endpoint/v2/validator/phone") {
            addDefaultHeader()
            url {
                parameters.apply {
                    append("phone", "$phone")
                }
            }
        }
    }

    /**
     * App open
     *
     * Retrieve a list of valid continents on Earth
     *
     * #### Request details
     * Method:    `GET`
     *
     * URL:    `/api/v2/open`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * `N-Meta` (string) **required** _eg: android;production;1.2.3;4.4;Samsung S7_
     *
     * `Accept-Language` (string) **Optional** _eg: da-DK_
     *
     * ### Form-data
     *
     * `platform` (string) **required** eg: ios/android/web
     *
     * `guid` (string) **required** `unique generated string` *eg: 9bc4b39a-0af5-4b54-a5a5-88ad334dbd4b*
     *
     * `version` (string) **required if not web** `format: xxx.yyy.zzz` *eg: 2.0.0 / 212.01.1*
     *  - *Current version of application*
     *
     * `oldVersion` (string) **required if not web** `format: xxx.yyy.zzz` *eg: 2.0.0 / 212.01.1*
     *  - *Previous version of application (Auto update can have happened)*
     *
     * `lastUpdated` (date time, ISO8601) **optional** *eg: 2019-06-15T14:29:50+00:00*
     *  - *Set timestamp from last app open (when localization has been synced), this will calculate which localizations should be updated*
     *
     * `dev` (bool) **option, default false**
     *  - *if true, bypass publishes and only use newest resource (set of key/values)*
     *
     * #### Response codes(s)
     * `200` OK
     *
     * @param platform
     * @param guid
     * @param version
     * @param oldVersion
     * @param lastUpdated
     * @param dev
     *
     * @return
     */
    suspend fun postAppOpen(
        acceptLanguage: String,
        platform: String, // FORM_DATA
        guid: String, // FORM_DATA
        version: String, // FORM_DATA
        oldVersion: String, // FORM_DATA
        lastUpdated: String, // FORM_DATA
        dev: Boolean = false// FORM_DATA
    ): AppUpdateResponse {
        return client.post("$endpoint/v2/open") {
            addDefaultHeader()
            header("N-Meta", nMeta)
            header("Accept-Language", acceptLanguage)
            formData {
                append("platform", platform)
                append("guid", guid)
                append("version", version)
                append("old_version", oldVersion)
                append("last_updated", lastUpdated)
                append("dev", dev.toString())
            }
        }
    }

    /**
     * App open
     *
     * Registers an app-open.
     *
     * _Deprecated, please use V2_
     *
     * #### Request details
     * Method: `POST`
     *
     * URL: `/api/v1/open`
     *
     * #### Headers
     * `X-Application-Id` (string) **required** _Application ID from [NStack](https://nstack.io)_
     *
     * `X-Rest-Api-Key` (string) **required** _Rest API key from [NStack](https://nstack.io)_
     *
     * `Accept-Language` (string) **Optional** _eg: da-DK_
     *
     * #### Parameters
     * `platform` (string) **required** _The platform the app was opened from e.g. ["ios", "android", "windows", "web"]_
     *
     * `guid` (string) **required** _[?]_
     *
     * `version` (string) **required** _[?]_
     *
     * `oldVersion` (string) _[?]_
     *
     * `lastUpdated` (string) _A string parsable by php's [strtotime()](http://php.net/manual/en/function.strtotime.php)-function_
     *
     * `test` (bool) _Enable test mode, false equals production (only works for version control)_
     *
     * #### Response codes(s)
     * `201` Created
     *
     * `412` Precondition failed
     *
     * `445` Entity not found
     *
     * `500` Internal server error _Please read response message_
     *
     * @param platform
     * @param guid
     * @param version
     * @param oldVersion
     * @param lastUpdated
     *
     * @return
     */
    suspend fun v1OpenPost(
        platform: String, // FORM_DATA
        guid: String, // FORM_DATA
        version: String, // FORM_DATA
        oldVersion: String, // FORM_DATA
        lastUpdated: String // FORM_DATA
    ) {
        return client.post("$endpoint/v1/open") {
            addDefaultHeader()
            formData {
                append("platform", platform)
                append("guid", guid)
                append("version", version)
                append("old_version", oldVersion)
                append("last_updated", lastUpdated)
            }
        }
    }

    private fun HttpRequestBuilder.addDefaultHeader() {
        header("X-Application-Id", applicationId)
        header("X-Rest-Api-Key", apiKey)
    }
}