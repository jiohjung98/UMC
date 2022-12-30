package com.example.umc3_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnToNext.setOnClickListener {
            val input = viewBinding.edittext.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            //putExtra: "name", value
            intent.putExtra("text", input)
            startActivity(intent)
        }
    }
}