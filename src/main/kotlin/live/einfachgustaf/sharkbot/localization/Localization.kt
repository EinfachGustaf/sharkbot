package live.einfachgustaf.sharkbot.localization

import live.einfachgustaf.sharkbot.exception.LocaleNotFoundException
import java.util.*

/**
 * The localization class.
 *
 * @param language The language of the localization.
 */
class Localization(language: String) {

    /**
     * The bundle of the localization.
     */
    var bundle: ResourceBundle; private set

    init {
        try {
            bundle = ResourceBundle.getBundle("lang/$language")
        } catch (e: MissingResourceException) {
            throw LocaleNotFoundException(language)
        }
    }

    /**
     * Get a localized string.
     *
     * @param key The key of the string.
     * @param replacements The replacements for the string.
     * @return The localized string.
     */
    fun get(
        key: String,
        replacements: Map<String, String> = mapOf()
    ): String {
        return replacements.entries
            .fold(bundle.getString(key)) { acc, (key, value) ->
                acc.replace("{$key}", value)
            }
    }

    companion object {
        /**
         * List of all available languages.
         */
        val allLanguages: List<String> by lazy {
            val resourceBundle = ResourceBundle.getBundle("lang/messages", Locale.ROOT)
            resourceBundle.keySet().map { it.split("_").last() }.distinct()
        }

        /**
         * Calculate the percentage of translations completed for each language.
         */
        fun calculateTranslationPercentages(): Map<String, Double> {
            val enUSBundle = ResourceBundle.getBundle("lang/en_US")
            val enUSKeys = enUSBundle.keySet().size

            return allLanguages.associateWith { language ->
                val bundle = ResourceBundle.getBundle("lang/$language")
                val keys = bundle.keySet().size
                (keys.toDouble() / enUSKeys) * 100
            }
        }
    }
}