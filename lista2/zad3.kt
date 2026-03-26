fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {

    if (lst.size <= 1) return true

    for (i in 0 until lst.size-1) {
        val current = lst[i]
        val next = lst[i+1]

        if (!order(current, next)) {
            return false
        }
    }
    return true
}

fun main() {
    println(isSorted(listOf(1, 2, 3, 4)) { i, j -> i < j })
    println(isSorted(listOf(1, 1, 1, 1)) { i, j -> i == j })
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu")) { i, j -> i.first() < j.first() })
}