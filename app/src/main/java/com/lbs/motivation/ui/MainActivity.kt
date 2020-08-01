package com.lbs.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.lbs.motivation.R
import com.lbs.motivation.infra.MotivationConstants
import com.lbs.motivation.infra.SecurityPreferences
import com.lbs.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var securityPreferences: SecurityPreferences
    private var phraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        securityPreferences = SecurityPreferences(this)
        securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)


//        init screen with value on icon
        allImages.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
        handleNewPhrase()

        newPhrase.setOnClickListener(this)
        allImages.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)


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
                phraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
                phraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
                phraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        textPhrase.text = Mock().getPhrase(phraseFilter)
    }
}