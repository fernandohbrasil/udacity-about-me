package com.fernandohbrasil.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fernandohbrasil.aboutme.databinding.ActivityMainBinding
import com.fernandohbrasil.aboutme.model.Name

private const val NAME = "James Marshall Hendrix"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val name: Name = Name(NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name = name

        setContentView(binding.root)

        bind()
    }

    private fun bind() {
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
            name?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = GONE
            doneButton.visibility = GONE
            nicknameText.visibility = VISIBLE
        }

        hideKeyBoard(view)
    }

    private fun hideKeyBoard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}