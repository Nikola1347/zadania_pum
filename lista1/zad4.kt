fun isPerfect(n: Int): String {
    var sum = 0

    for (i in 1 until n) {
        if (n % i == 0) {
            sum += i
        }
    }

    return when {
        sum == n -> "perfect"
        sum > n -> "abundant"
        else -> "deficient"
    }
}

fun main() {
    println(isPerfect(28))
    println(isPerfect(12))
    println(isPerfect(8))
}