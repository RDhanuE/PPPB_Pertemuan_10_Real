package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = "FruitBox"
        setContentView(binding.root)

        with(binding){
            rvFruit.apply {
                adapter = FruitAdapter(generateFruitData()) { fruit: Fruit ->
                    Toast.makeText(
                        this@MainActivity,
                        "Fill this with activity included ${fruit.name}, ${fruit.color}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruitData() : List<Fruit> {
        return  listOf(
            Fruit(name = "Apple", color = "Red", taste = "Sweet", colorCode = resources.getColor(R.color.apple),linkImg = "https://medilifefood.com/wp-content/uploads/2019/10/purepng.com-red-appleappleapplesfruitsweet-1701527180174lrnig-930x1024.png"),
            Fruit(name = "Orange", color = "Orange", taste = "Sweet and Sour", colorCode = resources.getColor(R.color.orange), linkImg = "https://static.vecteezy.com/system/resources/previews/008/848/377/non_2x/fresh-orange-free-png.png"),
            Fruit(name = "Lemon", color = "Yellow", taste = "Sour", colorCode = resources.getColor(R.color.lemon), linkImg = "https://www.pacificcoastfruit.com/wp-content/uploads/2015/06/lemon.png"),
            Fruit(name = "Watermelon", color = "Green", taste = "Juicy", colorCode = resources.getColor(R.color.watermelon), linkImg = "https://brandedfruit.com/cdn/shop/products/watermelon_300x300.png?v=1563408141"),
            Fruit(name = "Kiwi", color = "Brown", taste = "Sweet and Sour", colorCode = resources.getColor(R.color.kiwi), linkImg = "https://www.theproducemoms.com/wp-content/uploads/2022/01/kiwi.png"),
            Fruit(name = "Grape", color = "Purple", taste = "Sweet and Juicy", colorCode = resources.getColor(R.color.grape), linkImg = "https://static.vecteezy.com/system/resources/previews/022/430/921/original/bunch-of-grapes-on-transparent-background-png.png"),
            Fruit(name = "Dragon Fruit", color = "Pink", taste = "Sweet", colorCode = resources.getColor(R.color.dragonfruit), linkImg = "https://5.imimg.com/data5/CF/ZT/SW/SELLER-107172905/dragon-fruit-500x500.png")
        )
    }
}