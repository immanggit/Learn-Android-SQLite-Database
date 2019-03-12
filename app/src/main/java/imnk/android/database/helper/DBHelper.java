package imnk.android.database.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import imnk.android.database.Adapter.RecyclerData;

public class DBHelper extends SQLiteOpenHelper {

    public static final String COL_1 = "ID";
    public static final String COL_2 = "SUMMARY";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "STATUS";
    private static final String DATABASE_NAME = "Data.db";
    private static final String TABLE_NAME = "Data_table";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SUMMARY TEXT,DESCRIPTION TEXT,STATUS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String summary, String description, String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, summary);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, status);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public List<RecyclerData> dataList() {
        List<RecyclerData> dataList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM Data_table";
        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                RecyclerData recyclerData = new RecyclerData();
                recyclerData.setId(cursor.getString(0));
                recyclerData.setSummary(cursor.getString(1));
                recyclerData.setDescription(cursor.getString(2));
                recyclerData.setStatus(cursor.getString(3));
                dataList.add(recyclerData);
            } while (cursor.moveToNext());
        }

        Log.d("data size", String.valueOf(dataList.size()));

        db.close();
        return dataList;
    }
}
