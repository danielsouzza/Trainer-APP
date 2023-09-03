package com.example.trainer_app.data.models

class Auth {
    companion object {
        val guest = User(
            id=0,
            username = "",
            email = "",
            name = "Select User",
            userableType = "student",
            userable_id = 0,
            cref = null,
            graduation_year = "",
            birthday="",
            institution = "")
        private var _user: User? = null
        val user: User? get() = _user

        fun setUser(user: User){
            this._user = user
        }
    }
}