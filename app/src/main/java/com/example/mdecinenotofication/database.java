package com.example.mdecinenotofication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mdecinenotofication.databases.Medecine;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {


    public database( Context context) {
        super(context,"login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("Create table user(name text primary key,password text , nameOfmedicine text ,date text ,hour INTEGER ,minute INTEGER,second INTEGER,numoftaken INTEGER ,iftaken text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists user");
    }
    public boolean insert(String name ,String password){
      SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else  return true;
    }
    public boolean insertdataofmedecine(String nameOfmedicine ,String hour ,String minute ,String numoftaken){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nameOfmedicine",nameOfmedicine);

        contentValues.put("hour",hour);
        contentValues.put("minute",minute);

        contentValues.put("numoftaken",numoftaken);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else  return true;
    }
    public boolean updateDataofmed(String nameOfmedicine ,String  date ,int hour ,String minute ,String second ,String numoftaken){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nameOfmedicine",nameOfmedicine);
        contentValues.put("date",date);
        contentValues.put("hour",hour);
        contentValues.put("minute",minute);
        contentValues.put("second",second);
        contentValues.put("numoftaken",numoftaken);
        db.update("user",contentValues,"nameOfmedicine=?",new String[]{nameOfmedicine});
        return true;
    }
    public ArrayList<Medecine> getAllData(){
        ArrayList<Medecine> arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        String nameOfmedicine ,  date , hour ,minute , second , numoftaken ;

        Cursor  cursor = db.rawQuery("select * from user ",null);

         if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

             nameOfmedicine = cursor.getString(cursor.getColumnIndex("nameOfmedicine"));
//            hour = cursor.getString(cursor.getColumnIndex("hour"));
//            minute = cursor.getString(cursor.getColumnIndex("minute"));
             arrayList.add (new Medecine( nameOfmedicine  ,"", "" ,""));
             //arrayList.add (new Medecine( ""  ,"", "" ,""));
                cursor.moveToNext();
            }
        }






        return arrayList;
    }
    public Medecine getMedecineByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select *from user where nameOfmedicine = '" + name + "'", null);
        res.moveToFirst();
        String nameOfmedicine ,  date , hour ,minute , second , numoftaken ;
        nameOfmedicine = res.getString(res.getColumnIndex("nameOfmedicine"));
        hour = res.getString(res.getColumnIndex("hour"));
        minute = res.getString(res.getColumnIndex("minute"));
        second = res.getString(res.getColumnIndex("second"));
        numoftaken = res.getString(res.getColumnIndex("numoftaken"));
        date = res.getString(res.getColumnIndex("date"));
        return (new Medecine(nameOfmedicine ,  date ,hour, minute));
    }
    public boolean updateData(String nameOfmedicine ,String  date ,String hour ,String minute ,String second ,String numoftaken){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("nameOfmedicine",nameOfmedicine);
        contentValues.put("date",date);
        contentValues.put("hour",hour);
        contentValues.put("minute",minute);
        contentValues.put("second",second);
        contentValues.put("numoftaken",numoftaken);
        db.update("user",contentValues,"nameOfmedicine=?",new String[]{nameOfmedicine});

        return true;
    }


}
