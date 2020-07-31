package com.lbs.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val _sharedPreferences =
        context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        _sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return _sharedPreferences.getString(key, "") ?: ""
    }

}