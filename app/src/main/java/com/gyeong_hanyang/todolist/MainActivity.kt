package com.gyeong_hanyang.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

// 졸업 프로젝트 ToDoList 만들기
class MainActivity : AppCompatActivity() {

    private val dataDay = arrayListOf<DateDay>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var date = findViewById<RecyclerView>(R.id.date)

        dataDay.add(DateDay("1","08","월",true))
        dataDay.add(DateDay("2","09","화",false))
        dataDay.add(DateDay("3","10","수",false))
        dataDay.add(DateDay("4","11","목",false))
        dataDay.add(DateDay("5","12","금",false))
        dataDay.add(DateDay("6","13","토",false))
        dataDay.add(DateDay("7","14","일",false))
        dataDay.add(DateDay("8","15","월",false))
        dataDay.add(DateDay("9","16","화",false))

        var data_day_adapter = DateDayAdapter(this, dataDay);

        date.adapter = data_day_adapter
        date.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR).toString()
        val month = (cal.get(Calendar.MONTH) + 1).toString()
        val day = cal.get(Calendar.DATE).toString()



    }
}