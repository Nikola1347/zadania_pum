//zad5
fun evenPositiveSquare(list: List<Int>): List<Int> =
    list.zip(list.indices) //wartość, indeks
        .filter { it.second % 2 == 1 && it.first > 0 }
        .map { it.first * it.first }

fun main() {
    println(evenPositiveSquare(listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)))
}