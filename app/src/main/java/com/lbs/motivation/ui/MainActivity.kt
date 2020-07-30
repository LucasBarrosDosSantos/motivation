package com.lbs.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbs.motivation.R
import com.lbs.motivation.infra.MotivationConstants
import com.lbs.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        securityPreferences = SecurityPreferences(this)

        securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)


    }
}