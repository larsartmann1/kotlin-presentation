package com.wolt

import com.wolt.User
import com.wolt.helper.User as ExternalUser


fun main() {
    User(1, "John", "Doe", Role.User)

    // Don't do!
    com.wolt.helper.User(1, "John Doe", "john.doe@wolt.com")
    // Do!
    ExternalUser(1, "John Doe", "john.doe@wolt.com")
}