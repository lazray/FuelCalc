package ru.alekseenko.fuel_calc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper implements IDBHelper {

    public static final String TAG = "IDHelper";

    // Переменные базы данных
    public static final String DB_NAME = "myDB";
    public static final int DB_VERSION = 1;
    public static final String Rashod = "Rashod";
    public static final String RASHOD_ID = "_id";
    public static final String date = "date";
    public static final String capacity = "capacity";
    public static final String cost = "cost";
    public static final String odometr = "odometr";


    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        // Создание таблицы расходы
        sqLiteDatabase.execSQL("create table " + Rashod + "("
                + RASHOD_ID + " integer primary key, "
                + date + " text,"
                + odometr + " text,"
                + capacity + " text,"
                + cost + " text"
                + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }

    @Override
    public void addRashod(Rashod rashod) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(date, rashod.getDate());
        cv.put(odometr, rashod.getOdometr());
        cv.put(capacity, rashod.getCapacity());
        cv.put(cost, rashod.getCost());


        db.insert(Rashod, null, cv);
        db.close();
    }

    public ru.alekseenko.fuel_calc.Rashod getRashod(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Rashod, new String[]{RASHOD_ID,
                        date, capacity, cost, odometr}, RASHOD_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Rashod rashod = new Rashod((cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        return rashod;


//        public List<Rashod> getAllRashod;
//        {
//            List<Rashod> rashodList = new ArrayList<Rashod>();
//            String selectQuery = "SELECT  * FROM " + Rashod;
//
//            db = this.getWritableDatabase();
//            cursor = db.rawQuery(selectQuery, null);
//
//            if (cursor.moveToFirst()) {
//                do {
//                    rashod = new Rashod();
//                    rashod.setRASHOD_ID(cursor.getString(0));
//                    rashod.setDate(cursor.getString(1));
//                    rashod.setCapacity(cursor.getString(2));
//
//                    rashodList.add(rashod);
//                } while (cursor.moveToNext());
//            }


        }


    @Override
    public List<ru.alekseenko.fuel_calc.Rashod> getAllRashod() {
        return null;
    }

    @Override
    public int getRashodCount() {
        return 0;
    }

    @Override
    public int updateRashod(ru.alekseenko.fuel_calc.Rashod rashod) {
        return 0;
    }

    @Override
    public void deleteRashod(ru.alekseenko.fuel_calc.Rashod rashod) {

    }

    @Override
    public void deleteAll() {

    }
}










