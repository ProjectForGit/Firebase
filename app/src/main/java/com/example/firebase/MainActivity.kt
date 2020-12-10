package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    private  lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        auth =FirebaseAuth.getInstance()


    }

    fun register(view: View) {
        registerUser()
    }


    fun login(view: View) {
        loginUser()
    }



    private fun loginUser()
    {
        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener(this) {
            task ->
            if (task.isSuccessful)
            {
                Toast.makeText(baseContext, "Пользователь авторизован", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(baseContext, "Что-то пошло не так...", Toast.LENGTH_LONG).show()
            }
        }
    }



    private fun registerUser()
    {
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener(this) {
            task ->
            if (task.isSuccessful)
            {
                Toast.makeText(baseContext, "Пользователь успешно зарегистрирован", Toast.LENGTH_LONG).show()
            }

            else
            {
                Toast.makeText(baseContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}