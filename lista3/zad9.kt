//zad9
data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(list: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>> {

    val passed = list.filter { it.score >= 50 }
    val failed = list.filter { it.score < 50 }

    val passedBySubject = passed.groupBy { it.subject }

    val subjectsAllPassed =
        list.groupBy { it.subject }//grupy po przedmiocie
            .filter { (_, scores) -> scores.all { it.score >= 50 } }//wybieramy tylko te gdzie wszyscy zdali
            .map { it.key }//zostają same nazwy przedmiotów

    return Triple(passedBySubject, failed, subjectsAllPassed)
}

fun main() {
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")
}