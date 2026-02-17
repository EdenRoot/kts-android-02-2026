package orders

/**
 * Applies a percentage discount to every product in the order.
 *
 * Hint: use [products] to read the current list, [removeProductById] and
 * [addProduct] to replace each product with a discounted copy.
 * Use [Product.copy] to create a new product with a modified price.
 *
 * @param discountPercent discount percentage (e.g. 10 means 10%)
 * @param logger optional callback invoked with a log message for each product
 */
fun Order.applyDiscount(
    discountPercent: Int,
    logger: ((String) -> Unit)? = null
) {
    val productsCopy = products.toList()

    for (product in productsCopy) {
        val discountedPrice = product.price * (100 - discountPercent) / 100
        val discountedProduct = product.copy(price = discountedPrice)
        removeProductById(product.id)
        addProduct(discountedProduct)
        logger?.invoke("Applied $discountPercent% discount to product ${product.name}")
    }
}
