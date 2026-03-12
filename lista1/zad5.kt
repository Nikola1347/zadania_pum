fun checkArmstrong(n: Int): Boolean {
    val digits = n.toString().map { it.digitToInt() }
    val power = digits.size
    var sum = 0
    
    for (d in digits) {
        var p = 1
        repeat(power) { p *= d }
        sum += p
    }

    return sum == n
}

fun main() {
    println(checkArmstrong(153))
    println(checkArmstrong(9))
    println(checkArmstrong(154))
}