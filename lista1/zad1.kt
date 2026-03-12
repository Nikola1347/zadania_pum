fun foo(num: Int): String {
    val result = StringBuilder()

    for (i in 1 until num+1) {
        val line = when {
            i % 3 == 0 && i % 5 == 0 -> "trzypiec"
            i % 3 == 0 -> "trzy"
            i % 5 == 0 -> "piec"
            else -> i.toString()
        }
        result.appendLine(line)
    }
    return result.toString()
}

fun main() {
    val num = 15
    println(foo(num))
}
