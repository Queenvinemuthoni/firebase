package com.example.firebase_mid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {
    lateinit var EdtEntEmail:EditText
    lateinit var EdtEntPass:EditText
    lateinit var BtnLogin:Button
    lateinit var TvDirecttosignup:TextView

    private lateinit var authenticate:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EdtEntEmail=findViewById(R.id.etEmailAddress)
        EdtEntPass=findViewById(R.id.etPassword)
        BtnLogin=findViewById(R.id.btnLogin)
        TvDirecttosignup=findViewById(R.id.tvRedirectSignUp)
    }
}