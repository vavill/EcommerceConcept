package com.example.ecommerceconcept

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceconcept.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, VMFragment.newInstance())
                .commit()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putInt("counter", binding.tvTextview.text.toString().toInt())
        super.onSaveInstanceState(outState)
    }
}