package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    internal val days = dayOfMonth + month*12 + year*365
    override fun compareTo(other: MyDate): Int {
        return this.days - other.days
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(value: MyDate): Boolean {
        return start <= value && value <= endInclusive
    }
}
