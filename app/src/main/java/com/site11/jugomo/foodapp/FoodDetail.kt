package com.site11.jugomo.foodapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val bundle = intent.extras
        val name = bundle.getString("name")
        val desc = bundle.getString("desc")
        val img = bundle.getInt("img")

        ivDetail.setImageResource(img)
        tvDetailName.text = name
        tvDetailDesc.text = desc
    }

}
