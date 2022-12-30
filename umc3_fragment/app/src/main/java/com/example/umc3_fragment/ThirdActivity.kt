package com.example.umc3_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc3_fragment.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // 기본 화면 표시해주기(fragment 1)
        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.fragmentFrame.id, FirstFragment())
            .commitAllowingStateLoss()

        viewBinding.btnFrag1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.fragmentFrame.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnFrag2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.fragmentFrame.id, SecondFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnToFirst.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}