//zad10
data class Point(var x: Int, var y: Int) {

    // p1 + p2 → (x1 + x2, y1 + y2)
    operator fun plus(other: Point) =
        Point(this.x + other.x, this.y + other.y)

    // p1 += 1 → (x + 1, y + 1)
    operator fun plusAssign(value: Int) {
        this.x += value
        this.y += value
    }

    // p1 - p2 → (x1 - x2, y1 - y2)
    operator fun minus(other: Point) =
        Point(this.x - other.x, this.y - other.y)

    // p1 * p2 → (x1 * x2, y1 * y2)
    operator fun times(other: Point) =
        Point(this.x * other.x, this.y * other.y)

    // p1++ → (x+1, y+1)
    operator fun inc(): Point {
        this.x++
        this.y++
        return this
    }

    // p1-- → (x-1, y-1)
    operator fun dec(): Point {
        this.x--
        this.y--
        return this
    }

    // !p1 → (-x, -y)
    operator fun not() =
        Point(-this.x, -this.y)
}

fun main() {
    var p1 = Point(1, 1)
    val p2 = Point(2, 2)

    println(p1 + p2)   // (3, 3)
    p1 += 1
    println(p1)        // (2, 2)
    println(p1 - p2)   // (-1, -1)
    println(p1 * p2)   // (2, 2)
    println(p1++)      // (2, 2)
    println(p1)        // (3, 3)
    println(p1--)      // (3, 3)
    println(p1)        // (2, 2)
    println(!p1)       // (-2, -2)
}