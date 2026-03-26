fun check(N: Int, list: List<Int>): Int {

    for (i in N until list.size) {
        val current = list[i]
        val preamble = list.subList(i-N, i)
        var valid = false

        for (x in preamble) {
            for (y in preamble) {
                if (x != y && x + y == current) {
                    valid = true
                    break
                }
            }
            if (valid) break
        }
        if (!valid) return current
    }
    return -1
}

fun main() {
    println(check(2, listOf(1, 2, 3, 4, 5, 6))) //4
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576))) //127
}