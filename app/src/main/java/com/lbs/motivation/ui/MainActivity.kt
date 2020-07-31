package com.lbs.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.lbs.motivation.R
import com.lbs.motivation.infra.MotivationConstants
import com.lbs.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var securityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        securityPreferences = SecurityPreferences(this)

        securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        newPhrase.setOnClickListener(this)
        allImages.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


    }

    override fun onClick(view: View) {
        val id = view.id;

        val listFilter = listOf(R.id.allImages, R.id.imageHappy, R.id.imageMorning)

        if (id == R.id.newPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }

    private fun handleFilter(id: Int) {

        allImages.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))
        when (id) {
            R.id.allImages -> {
                allImages.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))

            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))

            }
        }
    }

    private fun handleNewPhrase() {

    }
}