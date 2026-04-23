//zad1
fun findDuplicates(list: List<Int>): List<Int> {
    val seen = mutableSetOf<Int>()
    val duplicates = mutableSetOf<Int>()

    list.forEach { if (!seen.add(it)) duplicates.add(it) }

    return duplicates.sorted()
}

fun main(){
    val lst = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3)
    println(findDuplicates(lst))
}
