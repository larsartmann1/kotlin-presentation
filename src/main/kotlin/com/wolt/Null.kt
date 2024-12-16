package com.wolt

data class ActorDBO(val name: String?, val age: Int?)
data class Actor(val name: String, val age: Int)


fun main() {
    sequence {
        yield(::v1)
        yield(::v2)
        yield(::v3)
        yield(::v4)
        yield(::v5)
    }.forEach {
        try {
            it()
        } catch (e: Exception) {
            System.err.println("---${it.name}---")
            e.printStackTrace(System.err)
        }
    }
}

fun v1() {
    val actorDBO = ActorDBO("John", null)
    val actor = Actor(actorDBO.name!!, actorDBO.age!!)
    println(actor)
}

fun v2() {
    val actorDBO = ActorDBO("John", null)

    val name = actorDBO.name ?: throw IllegalStateException("Name is required")
    val age = actorDBO.age ?: throw IllegalStateException("Age is required")

    val actor = Actor(name, age)
    println(actor)
}

fun v3() {
    val actorDBO = ActorDBO("John", null)

    val name = actorDBO.name ?: error("Name is required")
    val age = actorDBO.age ?: error("Age is required")

    val actor = Actor(name, age)
    println(actor)
}


fun v4() {
    val actorDBO = ActorDBO("John", null)
    requireNotNull(actorDBO.name) { "Name is required" }
    requireNotNull(actorDBO.age) { "Age is required" }

    val actor = Actor(actorDBO.name, actorDBO.age)
    println(actor)
}

fun v5() {
    val actorDBO = ActorDBO("John", null)
    val actor = Actor(
        checkNotNull(actorDBO.name) { "Name is required" },
        checkNotNull(actorDBO.age) { "Age is required" }
    )
    println(actor)
}





