//zad3
import java.time.LocalDate
import java.time.Month
import kotlin.random.Random

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost(
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

object DataProvider {
    val generalCosts = List(5) {
        Cost(
            CostType.values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1, 13),
                Random.nextInt(1, 28)
            ),
            Random.nextInt(5000)
        )
    }
}

sealed class MonthlyCostStatus

object NoCosts : MonthlyCostStatus() {
    override fun toString() = "NoCosts"
}

data class WithinLimit(val total: Int) : MonthlyCostStatus()

data class OverLimit(val total: Int, val exceededBy: Int) : MonthlyCostStatus()

fun classifyMonthlyCosts(costs: List<Cost>, month: Month, limit: Int): MonthlyCostStatus {
    val monthlyTotal = costs
        .filter { it.date.month == month }
        .sumOf { it.amount }

    return when {
        monthlyTotal == 0 ->
            NoCosts

        monthlyTotal <= limit ->
            WithinLimit(monthlyTotal)

        else ->
            OverLimit(total = monthlyTotal, exceededBy = monthlyTotal-limit)
    }
}

fun main() {
    val costs = listOf(
        Cost(CostType.REFUELING, LocalDate.of(2025, 1, 10), 300),
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 12), 50),
        Cost(CostType.SERVICE, LocalDate.of(2025, 2, 4), 1200)
    )

    println(classifyMonthlyCosts(costs, Month.JANUARY, 400))
    println(classifyMonthlyCosts(costs, Month.FEBRUARY, 1000))
    println(classifyMonthlyCosts(costs, Month.MARCH, 500))
}