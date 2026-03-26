data class UserInput(val name: String?, val email: String?, val age: String?)

data class UserProfile(
    var name: String = "",
    var email: String = "",
    var age: Int = 0,
    var isAdult: Boolean = false
)

fun buildProfile(input: UserInput?, logs: MutableList<String>): UserProfile? {

    if (input == null) {
        logs.add("Input is null")
        return null
    }

    val rawName = input.name
    if (rawName == null) {
        logs.add("Name is null")
        return null
    }

    val name = rawName.trim()
    if (name.length < 3) {
        logs.add("Name too short")
        return null
    }

    val rawEmail = input.email
    if (rawEmail == null) {
        logs.add("Email is null")
        return null
    }

    val email = rawEmail.trim().lowercase()
    if (!email.contains("@")) {
        logs.add("Invalid email")
        return null
    }

    val rawAge = input.age
    if (rawAge == null) {
        logs.add("Age is null")
        return null
    }

    val age = rawAge.toIntOrNull()
    if (age == null) {
        logs.add("Age is not a number")
        return null
    }

    return UserProfile().apply {
        this.name = name
        this.email = email

        age.let {
            this.age = it
            isAdult = it >= 18
        }

    }.also {
        logs.add("Profile created for $email")
    }
}

fun main() {
    val logs = mutableListOf<String>()
    val input = UserInput(" Adam ", "adam@mail.com", "20")
    val profile = buildProfile(input, logs)

    println(profile)
    println(logs)
}