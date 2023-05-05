package com.example.firebase_mid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var EdtEmail:EditText
    lateinit var EdtPass:EditText
    lateinit var EdtConfirmPass:EditText
    lateinit var BtnSignup:Button
    lateinit var TvDirecttoLogin:TextView

    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EdtEmail = findViewById(R.id.etSEmailAddress)
        EdtPass = findViewById(R.id.etSPassword)
        EdtConfirmPass = findViewById(R.id.etSConfPassword)
        BtnSignup = findViewById(R.id.btnSSigned)
        TvDirecttoLogin = findViewById(R.id.tvRedirectLogin)

        auth = Firebase.auth

        TvDirecttoLogin.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }
     signup()
    }
    private fun signup() {
        val email = EdtEmail.text.toString()
        val pass = EdtPass.text.toString()
        val confirmpass = EdtConfirmPass.text.toString()

        if (email.isBlank() || pass.isBlank() || confirmpass.isBlank()) {
            Toast.makeText(this, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (pass != confirmpass) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener() {
            if (it.isSuccessful) {
                Toast.makeText(this, "Sign in is successul", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Sign in is not successful", Toast.LENGTH_LONG).show()
            }
        }
    }
}