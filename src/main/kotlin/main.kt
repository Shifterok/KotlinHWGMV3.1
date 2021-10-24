import kotlin.math.roundToInt

fun main() {
    println("Как давно собеседник был в сети (укажите в секундах)")
    val howManySeconds = readLine()!!.toInt()

    val minutes = (howManySeconds / 60.0).roundToInt()
    val hours = (minutes / 60.0).roundToInt()
    val printMinutes = minutes.toString().takeLast(2)
    val printHours = hours.toString().takeLast(2)

    fun agoToText() {
        val printMinutes1 = when (printMinutes) {
            "1", "21", "31", "41", "51" -> "минуту"
            "2", "3", "4", "22", "23", "24", "32", "33", "34", "42", "43", "44", "52", "53", "54" -> "минуты"
            else -> "минут"
        }
        val printHours2 = when (printHours) {
            "1", "21" -> "час"
            "2", "3", "4", "22", "23", "24" -> "часа"
            else -> "часов"
        }
        when (howManySeconds) {
            in 0..60 -> println("Был(а) в сети только что")
            in 61..3_600 -> println("Был(а) в сети $minutes $printMinutes1 назад")
            in 3_601..24 * 60 * 60 -> println("Был(а) в сети $hours $printHours2 назад")
            in 24 * 60 * 61..2 * 24 * 60 * 60 -> println("Был(а) в сети сегодня")
            in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> println("Был(а) в сети вчера")
            in 3 * 24 * 60 * 60 + 1..100 * 24 * 60 * 60 -> println("Был(а) в сети давно")
        }
    }
    agoToText()
}