fun isPrime(n: Int): Boolean {
    if (n < 2) return false

    for (i in 2 until n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    println(isPrime(17))
    println(isPrime(12))
    println(isPrime(2))
}