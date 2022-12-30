package com.example.umc4_activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc4_activitylifecycle.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.txtSecond.text = intent.getStringExtra("memo")
    }
}