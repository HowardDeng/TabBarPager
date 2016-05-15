package com.example.goko3210.tabbarpager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by goko3210 on 16/5/10.
 */
public class DBManager
{
    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context)
    {
        //Log.d(AppConstants.LOG_TAG, "DBManager --> Constructor");
        helper = new DataBaseHelper(context);
        // 因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0,
        // mFactory);
        // 所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
    }

    /**
     * add persons
     *
     */
    public void add(User user)
    {
        //Log.d(AppConstants.LOG_TAG, "DBManager --> add");
        // 采用事务处理，确保数据完整性
        db.beginTransaction(); // 开始事务
        try
        {
                db.execSQL("INSERT INTO " + DataBaseHelper.TABLE_NAME
                        + " VALUES( ?, ?, ?)", new Object[] { user.getPortraitString(),
                        user.getName(), user.getMotto() });
                // 带两个参数的execSQL()方法，采用占位符参数？，把参数值放在后面，顺序对应
                // 一个参数的execSQL()方法中，用户输入特殊字符时需要转义
                // 使用占位符有效区分了这种情况
            db.setTransactionSuccessful(); // 设置事务成功完成
        }
        finally
        {
            db.endTransaction(); // 结束事务
        }
    }

    /**
     * query all persons, return list
     *
     * @return List<Person>
     */
    public User query()
    {
        //Log.d(AppConstants.LOG_TAG, "DBManager --> query");
        User user = new User();
        Cursor c = queryTheCursor();
        while (c.moveToNext())
        {
            user.setName(c.getString(c.getColumnIndex("name")));
            user.setMotto(c.getString(c.getColumnIndex("motto")));
            user.setPortraitString(c.getString(c.getColumnIndex("portraitString")));
        }
        c.close();
        return user;
    }

    /**
     * query all persons, return cursor
     *
     * @return Cursor
     */
    public Cursor queryTheCursor()
    {
        //Log.d(AppConstants.LOG_TAG, "DBManager --> queryTheCursor");
        Cursor c = db.rawQuery("SELECT * FROM " + DataBaseHelper.TABLE_NAME,
                null);
        return c;
    }

    /**
     * close database
     */
    public void closeDB()
    {
        //Log.d(AppConstants.LOG_TAG, "DBManager --> closeDB");
        // 释放数据库资源
        db.close();
    }

}
