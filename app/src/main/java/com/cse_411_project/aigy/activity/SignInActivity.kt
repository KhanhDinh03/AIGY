package com.cse_411_project.aigy.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cse_411_project.aigy.R

class SignInActivity : AppCompatActivity() {
    private lateinit var btnSignUp : TextView
    private lateinit var btnBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        this.btnSignUp = findViewById(R.id.txt_sign_in)

        this.btnSignUp.setOnClickListener {
            openSignUpActivity()
        }

        this.btnBack = findViewById(R.id.ibtn_back)

        this.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun openSignUpActivity() {
        val intent = SignUpActivity.newIntent(this)
        startActivity(intent)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignInActivity::class.java)
        }
    }
}