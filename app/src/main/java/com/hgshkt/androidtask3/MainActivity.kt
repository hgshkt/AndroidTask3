package com.hgshkt.androidtask3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        sendButton.setOnClickListener {
            sendMessage(
                email = emailEditText.text.toString(),
                text = messageEditText.text.toString()
            )
        }
    }

    private fun sendMessage(email: String, text: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_TEXT, text)

        startActivity(intent)
    }


    private fun init() {
        emailEditText = findViewById(R.id.text_email)
        messageEditText = findViewById(R.id.text_message)
        sendButton = findViewById(R.id.button)
    }
}