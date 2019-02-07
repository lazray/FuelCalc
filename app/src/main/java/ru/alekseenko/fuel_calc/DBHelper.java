package ru.alekseenko.fuel_calc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




   public class DBHelper extends SQLiteOpenHelper {

        public static final String TAG = "DBHelper";

        // Переменные базы данных
        public static final String DB_NAME = "myDB";
        public static final int DB_VERSION = 1;
        public static final String rashod = "rashod";
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
            sqLiteDatabase.execSQL("create table " + rashod + "("
                    + RASHOD_ID + " integer primary key, "
                    + date + " text,"
                    + capacity + " text,"
                    + cost + " text,"
                    + odometr + " text"
                    + ")"
                    );
        }

       @Override
       public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

       }
   }





