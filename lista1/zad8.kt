fun countVowels(word: String): Int {
    val vowels = "aeiouy"
    var count = 0

    for (ch in word.lowercase()) {
        if (ch in vowels) {
            count++
        }
    }
    return count
}

fun main() {
    val word = "Programowanie"
    println(countVowels(word))
}