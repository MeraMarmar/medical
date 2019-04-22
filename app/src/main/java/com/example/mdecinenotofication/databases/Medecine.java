package com.example.mdecinenotofication.databases;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Medecine {
    @PrimaryKey(autoGenerate = true)
int id ;
    @ColumnInfo(name = "nameOfmedicine")

    String nameOfmedicine ;
    @ColumnInfo(name = "hour")
            String  hour;
    @ColumnInfo(name = "minute")
    String    minute;
    @ColumnInfo(name = "numoftaken")

    String       numoftaken;

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }




    public Medecine(String nameOfmedicine,String hour, String minute, String numoftaken ) {
        this.nameOfmedicine = nameOfmedicine;
         this.hour = hour;
        this.minute=minute;
         this.numoftaken = numoftaken;

    }

    public void setNameOfmedicine(String nameOfmedicine) {
        this.nameOfmedicine = nameOfmedicine;
    }




    public void setNumoftaken(String numoftaken) {
        this.numoftaken = numoftaken;
    }

    public String getNameOfmedicine() {
        return nameOfmedicine;
    }




    public String getNumoftaken() {
        return numoftaken;
    }
}
