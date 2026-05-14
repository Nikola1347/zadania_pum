//zad2
import java.time.LocalDate
import java.time.Month
import kotlin.random.*

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

fun printCostsByMonth(costs: List<Cost>) {
    costs
        .sortedBy { it.date }
        .groupBy { it.date.month }
        .toSortedMap() //zmienia mape na postortowaną po kluczach
        .forEach { (month, monthCosts) -> //destrukturyzacja pary z mapy (entry.key, entry.value)
            println(month)

            monthCosts.forEach { cost ->
                val day = cost.date.dayOfMonth.toString().padStart(2, '0')
                println("$day ${cost.type} ${cost.amount} zl")
            }
        }
}

fun main() {
    printCostsByMonth(DataProvider.generalCosts)
}
