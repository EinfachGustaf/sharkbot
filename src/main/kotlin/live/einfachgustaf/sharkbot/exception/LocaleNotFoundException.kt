package live.einfachgustaf.sharkbot.exception

/**
 * The locale not found exception.
 *
 * @param name The name of the locale.
 */
class LocaleNotFoundException(name: String): Exception("The locale '$name' was not found.")