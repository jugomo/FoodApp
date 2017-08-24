package com.site11.jugomo.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_cell.view.*

class MainActivity : AppCompatActivity() {

    var list = ArrayList<Food>()
    var adapter: FoodAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load foods
        list.add(Food("Coffee", "A regular coffee in the office is so good", R.drawable.coffee_pot))
        list.add(Food("Expresso", "Better coffee is mitad doble in malaga", R.drawable.espresso))
        list.add(Food("French Fries", "camarero!! unas pataticas fritas por favor!", R.drawable.french_fries))
        list.add(Food("Honey", "miel de caña dulce y sabrosa", R.drawable.honey))
        list.add(Food("Ice cream", "helados de fresa en la playa", R.drawable.strawberry_ice_cream))
        list.add(Food("Sugar Cubes", "azucar para el cafe y para el helado", R.drawable.sugar_cubes))

        adapter = FoodAdapter(list, this)
        gbGrid.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {
        var list = ArrayList<Food>()
        var context: Context? = null

        constructor(list: ArrayList<Food>, context: Context) :super() {
            this.context = context
            this.list = list
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.food_cell, null)
            val food = list[p0]

            view.ivFoodImage.setImageResource(food.img!!)
            view.tvFoodText.text = food.name

            view.setOnClickListener {
                val intent = Intent(context, FoodDetail::class.java)
                intent.putExtra("name", food.name!!)
                intent.putExtra("desc", food.desc!!)
                intent.putExtra("img", food.img!!)
                context!!.startActivity(intent)
            }

            return view
        }

        override fun getItem(p0: Int): Any {
            return list[p0]
        }

        override fun getItemId(p0: Int): Long {
             return p0.toLong()
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
