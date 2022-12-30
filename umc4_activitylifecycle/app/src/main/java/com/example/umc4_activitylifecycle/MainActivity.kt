package com.example.umc4_activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.umc4_activitylifecycle.databinding.ActivityMainBinding

var memo: String = ""
var edtMemo: String = ""

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.saveBtn.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("memo", viewBinding.edtMemo.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        memo = viewBinding.edtMemo.text.toString()
        viewBinding.edtMemo.text = null
    }

    override fun onRestart() {
        super.onRestart()
        showDialog()
    }
    private fun showDialog()
    {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("메모")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("예") {dialog, which -> viewBinding.edtMemo.setText(memo)}
            .setNegativeButton("아니오") {dialog, which -> viewBinding.edtMemo.text!!.clear()}
            .create()
            .show()
    }
}