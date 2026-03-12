fun isPalindrome(w: String): Boolean {
    val dl = w.length
    for (i in 0 until dl/2){
        if (w[i] != w[dl-1-i]) {
            return false
        }
    }
    return true
}

fun main() {
    val word = "abbaa"
    println(isPalindrome(word))
}