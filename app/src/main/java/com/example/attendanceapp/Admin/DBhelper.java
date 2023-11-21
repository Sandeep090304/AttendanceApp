package com.example.attendanceapp.Admin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="StudentDB";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="S1_table";
    public static final String COL_1="ID";
    public static final String COl_2="Name";
    public static final String COl_3="Rollno";
    public static final String COl_4="Subject";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Rollno String UNIQUE,Subject TEXT)");
    }

    public boolean inserdata(String name,String rollno,String subject){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COl_2,name);
        contentValues.put(COl_3,rollno);
        contentValues.put(COl_4,subject);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("Select * from " +TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id, String name,String rollno,String subject)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COl_2, name);
        contentValues.put(COl_3, rollno);
        contentValues.put(COl_4, subject);
        db.update(TABLE_NAME,contentValues," id = ? ",new String[] {id});
        return true;
    }
    public int delData(String id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.delete(TABLE_NAME," id = ? ",new String[] {id});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE if EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
