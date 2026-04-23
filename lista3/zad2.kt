//zad2
fun addToBoolean(): Map<Int, Boolean> {
    val map = mutableMapOf<Int, Boolean>()

    for (i in 1..20) {
        map[i] = (i%2 == 0)
    }

    return map
}

fun main() {
    println(addToBoolean())
}