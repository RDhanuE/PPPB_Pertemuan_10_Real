package com.example.myapplication

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityFruitDescBinding
import com.squareup.picasso.Picasso

class FruitDescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFruitDescBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.extras
        title = data?.getString("NAME")


        with(binding){
            Picasso.get().load(data?.getString("LINK")).into(fruitDescImage)
            fruitDescName.text = "This is a ${data?.getString("NAME")}"
            fruitDescColor.text = "Its color is mostly ${data?.getString("COLOR")}"
            fruitDescTaste.text = "It's ${data?.getString("TASTE")}"
            if (data != null) {
                supportActionBar?.setBackgroundDrawable(ColorDrawable(data.getInt("CODE")))
                fruitDescButton.background = ColorDrawable(data.getInt("CODE"))
            }

            fruitDescButton.setOnClickListener{
                finish()
            }
        }
    }
}