package com.example.goko3210.tabbarpager;

/**
 * Created by goko3210 on 16/5/10.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DataBaseHelper extends SQLiteOpenHelper{

    public static final int VERSION = 1;
    public static final String SWORD="SWORD";
    public static final String DATABASE_NAME="MianMenMen.db";
    public static final String TABLE_NAME="USER";
    //三个不同参数的构造函数
    //带全部参数的构造函数，此构造函数必不可少
    public DataBaseHelper(Context context, String name, CursorFactory factory,
                          int version) {
        super(context, name, factory, version);

    }
    //带两个参数的构造函数，调用的其实是带三个参数的构造函数
    public DataBaseHelper(Context context,String name){
        this(context,name,VERSION);
    }
    //带三个参数的构造函数，调用的是带所有参数的构造函数
    public DataBaseHelper(Context context,String name,int version){
        this(context, name,null,version);
    }

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);

        // 数据库实际被创建是在getWritableDatabase()或getReadableDatabase()方法调用时
        //Log.d(AppConstants.LOG_TAG, "DatabaseHelper Constructor");
        // CursorFactory设置为null,使用系统默认的工厂类
    }


    //创建数据库
    public void onCreate(SQLiteDatabase db) {
        Log.i(SWORD,"create a Database");
        //创建数据库sql语句
        String sql = "create table user(portraitString varchar(2000),name varchar(20),motto varchar(30))";
        //执行创建数据库操作
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //创建成功，日志输出提示
        Log.i(SWORD,"update a Database");
    }

}
