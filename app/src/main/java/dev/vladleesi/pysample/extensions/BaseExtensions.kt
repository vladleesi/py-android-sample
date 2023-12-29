package dev.vladleesi.pysample.extensions

inline fun <reified T : Any> Any.castOrNull() = this as? T
