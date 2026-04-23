//zad7
fun srt(list: List<String>): List<Pair<String, List<String>>> =
    list
        .filter { it.length % 2 == 0 }
        .groupBy { it.first().lowercase() }
        .toList()
        .sortedBy { it.first }

fun main() {
    println(srt(listOf(
        "cherry",
        "blueberry",
        "citrus",
        "apple",
        "apricot",
        "banana",
        "coconut"
    )))
}