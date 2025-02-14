package com.example.receipeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.receipeapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity()
{

    private lateinit var binding:ActivityHomeBinding
    private lateinit var rvAdapter: PopularAdapter
    private lateinit var dataList: ArrayList<Recipe>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupRecyclerView()
    }

         fun setupRecyclerView()
         {
             dataList=ArrayList()
             binding.rvPopular.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
             var db= Room.databaseBuilder(this@HomeActivity,AppDatabase::class.java,"db_name")
                 .allowMainThreadQueries()
                 .fallbackToDestructiveMigration()
                 .createFromAsset("recipe.db")
                 .build()
             var daoObject=db.getDao()
             var recipes=daoObject.getAll()
             for(i in recipes!!.indices) {
                 if (recipes[i]!!.catagory.contains("Popular")) {
               dataList.add(recipes[i]!!)
                 }
                 rvAdapter=PopularAdapter(dataList,this)
                 binding.rvPopular.adapter=rvAdapter
             }

             }

        }
