val <T> List<T>.tail: List<T>
    get() = this.drop(1)

val <T> List<T>.head: T
    get() = this.first()

fun main() {
    val list = listOf(1, 2, 3, 4)

    println(list.head)
    println(list.tail)
}