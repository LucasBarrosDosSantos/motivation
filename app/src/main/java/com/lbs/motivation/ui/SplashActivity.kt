package com.lbs.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lbs.motivation.R
import com.lbs.motivation.infra.MotivationConstants
import com.lbs.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        securityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide();
        }

        save.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id;
        if (id == R.id.save) {
            handleSave()
        }
    }


    private fun handleSave() {
        val name = editName.text.toString();

        if (name != "") {
            securityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
//            use reflection for reference activity
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, getString(R.string.please_enter_name), Toast.LENGTH_LONG).show()
        }
    }
}