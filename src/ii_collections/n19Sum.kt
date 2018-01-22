package ii_collections

fun example6() {
    listOf(1, 3).sum() == 4
    listOf("a", "b", "cc").sumBy { it.length } == 4
}

fun Customer.getTotalOrderPrice() = orders.sumByDouble { o -> o.products.sumByDouble { p -> p.price} }
