package com.gyeong_hanyang.todolist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gyeong_hanyang.todolist.room.AppDatabase
import com.gyeong_hanyang.todolist.room.entity.Component
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class CalendarActivity : AppCompatActivity() {

    lateinit var calendar: MaterialCalendarView
    var db2: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendar = findViewById(R.id.calendar)
        calendar.setSelectedDate(CalendarDay.today())

        calendar.addDecorator(TodayDecorator())

        db2 = AppDatabase.getInstance(this)
        var componentDao = db2!!.componentDao()
//                componentDao.insert(Component("2023-4-30","1","데이터사이언스 2차 과제"))
        Log.e("componentDao",componentDao.findAll().size!!.toString())
        componentDao.findAll().forEach {
            Log.e("component date ",it.date)
            Log.e("component type ",it.type)
            Log.e("component contents ",it.contents)


            CoroutineScope(Dispatchers.Main).launch {
                calendar.addDecorator(EventDecorator(Collections.singleton(CalendarDay.from(it.date.split("-")[0].toInt(),it.date.split("-")[1].toInt(),it.date.split("-")[2].toInt()))))
            }

        }



        calendar.setOnDateChangedListener(object: OnDateSelectedListener {
            override fun onDateSelected(widget: MaterialCalendarView, date: CalendarDay, selected: Boolean) {
                calendar.addDecorator(EventDecorator(Collections.singleton(date)))
                Log.e("in "+date, "calendar date click")
            }
        })




    }
}