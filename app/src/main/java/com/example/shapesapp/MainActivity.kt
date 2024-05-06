package com.example.shapesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shapesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewOfShapes: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

              val arrListOfShapes= arrayListOf(
            ShapeItem(R.drawable.ic_baseline_triangle_24,"Triangle"),
            ShapeItem(R.drawable.ic_baseline_circle,"Circle"),
            ShapeItem(R.drawable.ic_baseline_rectangle_24,"Rectangle"),
            ShapeItem(R.drawable.ic_baseline_square_24,"Square"),
            ShapeItem(R.drawable.ic_baseline_star_24,"Star"),
            ShapeItem(R.drawable.ic_baseline_pentagon_24,"Pentagon"),
        )
        recyclerViewOfShapes=binding.MainRecViewShapes
        recyclerViewOfShapes.layoutManager=
            GridLayoutManager(this,2,RecyclerView.VERTICAL,false)

        recyclerViewOfShapes.adapter=ShapeAdapter(arrListOfShapes)
    }
}