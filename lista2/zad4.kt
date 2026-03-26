fun safeParseAndClassify(input: String?): String {

    if (input.isNullOrBlank()) return "BRAK_DANYCH"

    val number = input.toIntOrNull()

    if (number == null) return "BRAK_DANYCH"

    return if (number%2 == 0) "PARZYSTA" else "NIEPARZYSTA"
}

fun main() {
    println(safeParseAndClassify(null)) // BRAK_DANYCH
    println(safeParseAndClassify("")) // BRAK_DANYCH
    println(safeParseAndClassify("  ")) // BRAK_DANYCH
    println(safeParseAndClassify("4")) // PARZYSTA
    println(safeParseAndClassify("17")) // NIEPARZYSTA
    println(safeParseAndClassify("abc")) // BRAK_DANYCH
}