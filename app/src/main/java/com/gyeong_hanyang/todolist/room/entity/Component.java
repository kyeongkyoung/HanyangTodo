package com.gyeong_hanyang.todolist.room.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "component")
public class Component {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String date;
    private String type;
    private String contents;

    public Component(String date, String type, String contents){
        this.date=date;
        this.type=type;
        this.contents = contents;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
