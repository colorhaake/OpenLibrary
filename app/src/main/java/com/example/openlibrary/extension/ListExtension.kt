package com.example.openlibrary.extension

fun <T> List<T>.join(separator: T): List<T> {
    if (size <= 1) return this

    return dropLast(1)
        .fold(listOf<T>()) { acc, t -> acc + t + separator }
        .plus(last())
}