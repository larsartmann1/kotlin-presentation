package com.wolt

enum class Permission {
    READ,
    WRITE,
    DELETE,
}

sealed class Role(val permissions: Set<Permission> = setOf()) {

    val name: String?
        get() = this::class.simpleName

    data object Admin : Role(User.permissions + setOf(Permission.DELETE))
    data object User : Role(setOf(Permission.READ, Permission.WRITE))
    data object Guest : Role()
}

data class User(
    val id: Int,
    var firstName: String,
    var lastName: String,
    val role: Role
)

val User.fullName
    get() = "$firstName $lastName"


fun main() {
    val user = User(1, "John", "Doe", Role.User)
    println("User: $user")
    println("User fullName: ${user.fullName}")
    println("canDelete(user): ${canDelete(user)}")
    println("user.canDelete(): ${user.canDelete()}")
    println("User role: ${user.role.name}")
    println("User role in German: ${user.role.germanName()}")
}

@JvmName("canDelete1")
fun canDelete(user: User) = user.role.permissions.contains(Permission.DELETE)
fun User.canDelete() = hasPermission(Permission.DELETE)

fun User.hasPermission(permission: Permission) = role.permissions.contains(permission)

fun Role.germanName() = when (this) {
    Role.Admin -> "Admin"
    Role.User -> "Nutzer"
    Role.Guest -> "Gast"
}


typealias InvoiceContent = Unit
typealias SoftoneInvoiceTypeCode = Unit
typealias Issuer = Unit
typealias Party = Unit

private fun findInvoiceTypeCode(content: InvoiceContent): SoftoneInvoiceTypeCode {}
private fun InvoiceContent.toSoftOneInvoiceTypeCode(): SoftoneInvoiceTypeCode = Unit

private fun mapIssuerData(issuer: Issuer?): Party {}
private fun Issuer?.toParty(): Party {}

fun main2() {
    val invoiceContent = Unit
    val invoiceTypeCode = findInvoiceTypeCode(invoiceContent)
    val invoiceTypeCode2 = invoiceContent.toSoftOneInvoiceTypeCode()

    val issuer: Issuer? = null
    val party = mapIssuerData(issuer)
    val party2 = issuer.toParty().toString()
}






