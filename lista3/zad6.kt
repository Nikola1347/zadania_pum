//zad6
fun perm(list: List<Int>): List<List<Int>> =
    if (list.isEmpty()) listOf(emptyList())
    else list.flatMap { x -> perm(list.filter { it != x }).map { p -> listOf(x) + p }}

fun main() {
    println(perm(listOf(1, 2, 3)))
}