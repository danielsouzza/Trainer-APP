package com.example.trainer_app.data.models

class Auth {
    companion object {
        private var _user: User? = null
        val user: User? get() = _user

        fun setUser(user: User){
            this._user = user
        }
    }
}