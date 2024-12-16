package com.wolt

import kotlin.random.Random

fun main() {
    println(if (Random.nextBoolean()) "Hello True!" else "Hello False!")
    println(when (Random.nextInt(3)) {
        0 -> "Hello lose!"
        1 -> "Hello draw!"
        else -> "Hello win!"
    })


    val x: Int? = Random.nextInt(10)
    println(x?.takeIf { it > 2 }?.let { "x > 2" } ?: "x < 2 or null")
    println(if (x != null && x > 2) "x > 2" else "x < 2 or null")
}