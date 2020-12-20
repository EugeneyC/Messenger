package com.skrebtsov.eugeney.messenger.models

data class User(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var status: String = "",
    var phone: String = "",
    var photourl: String = ""
)