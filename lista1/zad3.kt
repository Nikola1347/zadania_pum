fun printPascal(h: Int): String {
    val result = StringBuilder()
    var row = listOf(1)

    for (i in 0 until h) {
        val space = " ".repeat(h-i)
        result.append(space)
        result.append(row.joinToString(" "))
        result.append("\n")
        row = listOf(1) + row.zipWithNext {a, b -> a + b} + listOf(1)
    }
    return result.toString()
}

fun main() {
    val height = 5
    print(printPascal(height))
}