package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    internal val days = dayOfMonth + month*12 + year*365
    override fun compareTo(other: MyDate): Int {
        return this.days - other.days
    }
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(value: MyDate): Boolean {
        return start <= value && value <= endInclusive
    }

    operator fun iterator() = object: Iterator<MyDate> {
        var value = start
        override fun next(): MyDate {
            val ret = value
            value = ret.nextDay()
            return ret
        }

        override fun hasNext(): Boolean = value <= endInclusive

    }
}

