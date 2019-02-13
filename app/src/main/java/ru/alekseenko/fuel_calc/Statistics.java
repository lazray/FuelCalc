package ru.alekseenko.fuel_calc;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import static ru.alekseenko.fuel_calc.DBHelper.capacity;
import static ru.alekseenko.fuel_calc.DBHelper.cost;
import static ru.alekseenko.fuel_calc.DBHelper.odometr;

public class Statistics extends Activity implements View.OnClickListener{


    // Метка для журналирования
    public static final String TAG = "Statistics";

    // Объявление переменной для списка
    ListView listView;


    // Переменная для кнопки
    Button button;

    // Переменная для инициализации DB
    DBHelper dbHelper;

    // Переменная для управления DB, через методы:
    // query(),insert(),delete(),update(), execSQL()
    SQLiteDatabase sqLiteDatabase;

    // Переменная для курсора - временного объекта для хранения записей
    Cursor cursor;

    // Переменная для адаптера
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        //Определение списка из макета activity_main.xml
        listView = (ListView) findViewById(R.id.list_view);



        //Экземпляр класса базы данных
        dbHelper = new DBHelper(this);
        //объект класса для получения доступа к управлению с поддержкой записи данных
        sqLiteDatabase = dbHelper.getWritableDatabase();

        Log.d(TAG, "dbHelper.getWritableDatabase() has done");

        // Объект Cursor типа MAP-коллекция
        cursor = sqLiteDatabase.query(DBHelper.Rashod,null,null,null,null,null,null);

        // Вывод данных из базы
        if(cursor.moveToFirst()) {
            do {
                Log.d(TAG, "Cursor = " + cursor.getPosition() + ", ID = " + cursor.getInt(0) + " , " + DBHelper.date + " = " + cursor.getString(1) + " , " + DBHelper.odometr + " = " + cursor.getString(2) + " , " + DBHelper.capacity + " = " + cursor.getString(3));
            } while (cursor.moveToNext());
        }
//        cursor.close();

        simpleCursorAdapter = new SimpleCursorAdapter(this,
                R.layout.statistics, cursor,
                new String[]{DBHelper.odometr}, new int[]{R.id.item},0);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(simpleCursorAdapter);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Statistics.this, "position = " + position, Toast.LENGTH_SHORT).show();
                getResources().getString(R.string.app_name);

            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}









