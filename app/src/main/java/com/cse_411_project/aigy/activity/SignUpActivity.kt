package com.cse_411_project.aigy.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cse_411_project.aigy.R
import com.cse_411_project.aigy.fragment.EmailVerifyDialogFragment

class SignUpActivity : AppCompatActivity() {
    private lateinit var iBtnBack: ImageButton
    private lateinit var btnRegister: Button
    private lateinit var btnSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        this.btnRegister = findViewById(R.id.btn_register)

        this.btnRegister.setOnClickListener {
            openEmailVerifyFragment()
        }

        this.iBtnBack = findViewById(R.id.ibtn_back)

        this.iBtnBack.setOnClickListener {
            finish()
        }

        this.btnSignIn = findViewById(R.id.txt_sign_in)

        this.btnSignIn.setOnClickListener {
            openSignInActivity()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openEmailVerifyFragment() {
        val emailVerifyDialog = EmailVerifyDialogFragment()
        emailVerifyDialog.isCancelable = false
        emailVerifyDialog.show(supportFragmentManager, "EmailVerifyDialog")
    }

    private fun openSignInActivity() {
        val intent = SignInActivity.newIntent(this)
        startActivity(intent)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }
}