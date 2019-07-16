package dk.nodes.nstack.models

import kotlinx.serialization.Serializable

@Serializable
data class UntitledExample(
    val data: Data2
)

@Serializable
data class Data2(
    val default: Default,
    val translate_platforms: TranslatePlatforms,
    val translate_default: TranslateDefault,
    val errors: Errors,
    val translate_errors: TranslateErrors,
    val translate_languages: TranslateLanguages,
    val translate_platform_languages: TranslatePlatformLanguages,
    val translate_main: TranslateMain,
    val translate_import: TranslateImport
)

@Serializable
data class Default(
    val actions: String,
    val active: String,
    val add: String,
    val cancel: String,
    val confirmHeader: String,
    val create: String,
    val default: String,
    val deleteModel: String,
    val deleteSuccess: String,
    val edit: String,
    val editModel: String,
    val modelIsActive: String,
    val modelIsDeactive: String,
    val name: String,
    val noEntries: String,
    val pick: String,
    val saveSuccess: String,
    val slug: String,
    val update: String
)

@Serializable
data class TranslatePlatforms(
    val addNewModalHeader: String,
    val deletePlatformModalText: String,
    val inProductionModalTextActivate: String,
    val inProductionModalTextDeactivate: String,
    val inProductionTooltipActivate: String,
    val inProductionTooltipDeactivate: String,
    val isInDevelopmentFlash: String,
    val isInProductionFlash: String,
    val keysTooltip: String,
    val platformLanguageTooltip: String,
    val title: String
)

@Serializable
data class TranslateDefault(
    val autoRedirectToFirstPlatform: String,
    val direction: String,
    val inProduction: String,
    val key: String,
    val keys: String,
    val language: String,
    val languages: String,
    val locale: String,
    val lrm: String,
    val platforms: String,
    val rlm: String,
    val section: String,
    val sections: String,
    val theKey: String,
    val theLanguage: String,
    val thePlatform: String,
    val theSection: String,
    val theTranslation: String,
    val translated: String,
    val translation: String,
    val value: String
)

@Serializable
data class Errors(
    val couldNotFindModelWithId: String,
    val failedToDelete: String,
    val failedToSave: String,
    val random: String
)

@Serializable
data class TranslateErrors(
    val noLanguageConnection: String,
    val noLanguages: String,
    val noPlatforms: String,
    val platformIsInProduction: String
)

@Serializable
data class TranslateLanguages(
    val deleteLanguageModalText: String,
    val title: String
)

@Serializable
data class TranslatePlatformLanguages(
    val activeModalActivate: String,
    val activeModalDeactivate: String,
    val activeTooltipActivate: String,
    val activeTooltipDeactivate: String,
    val addTitle: String,
    val connection: String,
    val defaultModalText: String,
    val defaultSavedSuccess: String,
    val defaultTooltip: String,
    val exportTooltip: String,
    val importTooltip: String,
    val keysTooltip: String,
    val setDefault: String,
    val test: String,
    val testModalTextActivate: String,
    val testModalTextDeactivate: String,
    val testSaveSuccessActivate: String,
    val testSaveSuccessDeactivate: String,
    val testTooltipActivate: String,
    val testTooltipDeactivate: String,
    val theConnection: String,
    val title: String
)

@Serializable
data class TranslateMain(
    val addSectionBtn: String,
    val addSectionTitle: String,
    val cacheFlushedSuccess: String,
    val deleteKeyModalText: String,
    val deleteSectionEmptyKeysModelText: String,
    val deleteSectionModalText: String,
    val flushCache: String,
    val updateValueModalTitle: String
)

@Serializable
data class TranslateImport(
    val submitBtn: String,
    val title: String
)

@Serializable
data class Messages(
    val data: Data
)

@Serializable
data class Data(
    val id: Int,
    val message: String,
    val show_setting: String
)

@Serializable
data class PushLogsRequest(
    val provider: String,
    val key: String,
    val type: String,
    val succeeded: Boolean,
    val request: DefinitionsPushLogsRequestRequest,
    val response: DefinitionsPushLogsRequestResponse,
    val user_id: Int
)

@Serializable
data class AppopenV2(
    val data: Data1,
    val meta: Meta
)

@Serializable
data class Data1(
    val count: Int,
    val update: Update,
    val localize: List<Localize>,
    val platform: String,
    val created_at: String,
    val last_updated: String
)

//@Serializable
//data class Update(
//    val newer_version: NewerVersion
//)

@Serializable
data class NewerVersion(
    val state: String,
    val last_id: Int,
    val version: String,
    val link: String,
    val translate: Translate
)

@Serializable
data class Translate(
    val title: String,
    val message: String,
    val positiveBtn: String,
    val negativeBtn: String
)

@Serializable
data class Localize(
    val id: Int,
    val url: String,
    val last_updated_at: String,
    val should_update: Boolean,
    val language: Language
)

//@Serializable
//data class Language(
//    val id: Int,
//    val name: String,
//    val locale: String,
//    val direction: String,
//    val is_default: Boolean,
//    val is_best_fit: Boolean
//)

@Serializable
data class Meta(
    val accept_Language: String
)

// Synthetic class name
@Serializable
class DefinitionsPushLogsRequestRequest(
)

// Synthetic class name
@Serializable
class DefinitionsPushLogsRequestResponse(
)
