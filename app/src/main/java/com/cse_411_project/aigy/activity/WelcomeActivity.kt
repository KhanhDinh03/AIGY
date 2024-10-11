package com.cse_411_project.aigy.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cse_411_project.aigy.R

class WelcomeActivity : AppCompatActivity() {
    private lateinit var btnSignUp : Button
    private lateinit var btnSignIn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        this.btnSignUp = findViewById(R.id.btn_sign_up)

        this.btnSignUp.setOnClickListener {
            openSignUpActivity()
        }

        this.btnSignIn = findViewById(R.id.btn_sign_in)

        this.btnSignIn.setOnClickListener {
            openSignInActivity()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openSignInActivity() {
        val intent = SignInActivity.newIntent(this)
        startActivity(intent)
    }

    private fun openSignUpActivity() {
        val intent = SignUpActivity.newIntent(this)
        startActivity(intent)
    }
}
