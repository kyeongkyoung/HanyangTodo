package com.gyeong_hanyang.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DateDayAdapter(private val context: Context, private val dataList: ArrayList<DateDay>)
    : RecyclerView.Adapter<DateDayAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    private var listener: OnItemClickListener? = null
    private var selectedPosition = 0

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val date = itemView.findViewById<TextView>(R.id.date)
        private val day = itemView.findViewById<TextView>(R.id.day)
        private val date_view_background = itemView.findViewById<ImageView>(R.id.date_view_background)
        fun bind(dateData: DateDay, context: Context) {

            date.text = dateData.date
            day.text = dateData.day

            if (selectedPosition == adapterPosition) {
                dataList[adapterPosition].isSelected = true
                date_view_background.setBackgroundResource(R.drawable.data_day_itemview_background_on)
//                binding.setChecked()
            } else {
                dataList[adapterPosition].isSelected = false
                date_view_background.setBackgroundResource(R.drawable.data_day_itemview_background)
//                binding.setUnchecked()
            }


            if(adapterPosition != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, position)
                    if (selectedPosition != adapterPosition){
                        date_view_background.isSelected = true
                        date_view_background.setBackgroundResource(R.drawable.data_day_itemview_background_on)
                        notifyItemChanged(selectedPosition)
                        selectedPosition = adapterPosition
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ask_list_itemview, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}