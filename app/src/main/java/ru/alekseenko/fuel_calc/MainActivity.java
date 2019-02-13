package ru.alekseenko.fuel_calc;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.Button;

public class MainActivity extends Activity {

    // Метка для журналирования
    public static final String TAG = "MainActivity";


    TextView dateCurrent;
    TextView mileageCurrent;

    ImageButton consumptionTotalB;
    ImageButton statisticsButton4;


    // Переменная для инициализации DB
    DBHelper dbHelper;

    // Переменная для управления DB, через методы:
    // query(),insert(),delete(),update(), execSQL()
    SQLiteDatabase sqLiteDatabase;

    // Переменная для курсора - временного объекта для хранения записей
    Cursor cursor;

    // Переменная для адаптера
    SimpleCursorAdapter simpleCursorAdapter;
    private Object AdapterView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateCurrent = (TextView) findViewById(R.id.dateCurrent);
        mileageCurrent = (TextView) findViewById(R.id.dateCurrent);
        consumptionTotalB = (ImageButton) findViewById(R.id.consumptionTotalB);
        statisticsButton4 = (ImageButton) findViewById(R.id.statisticsButton4);


//    //Описываем процесс перехода с MainActivity в SecondActivity,
//    // который будет происходить при нажатии на нашу кнопку:
//
//
//

        //Экземпляр класса базы данных
        dbHelper = new DBHelper(this);
        //объект класса для получения доступа к управлению с поддержкой записи данных
        sqLiteDatabase = dbHelper.getWritableDatabase();

        Log.d(TAG, "dbHelper.getWritableDatabase() has done");

        // Объект Cursor типа MAP-коллекция
        cursor = sqLiteDatabase.query(DBHelper.Rashod, null, null, null, null, null, null);

        // Вывод данных из базы
        if (cursor.moveToFirst()) {
            do {
                Log.d(TAG, "Cursor = " + cursor.getPosition() + ", ID = " + cursor.getInt(0) + " , " + DBHelper.date + " = " + cursor.getString(1));
            } while (cursor.moveToNext());
        }
//        cursor.close();

        simpleCursorAdapter = new SimpleCursorAdapter(this,
                R.layout.activity_main, cursor,
                new String[]{DBHelper.date}, new int[]{R.id.dateCurrent}, 0);
        dateCurrent.setText(DBHelper.date);



//                @Override
//                public void onItemClick;(AdapterView<?> parent, View view, int position, long id) {
//                    Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
//                    getResources().getString(R.string.app_name);
//
////                }
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.consumptionTotalB:
                // Вызов ввода данных активити
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.statisticsButton4:
                // Вызов статистики активити
                Intent intent2 = new Intent(this, Statistics.class);
                startActivity(intent2);
                break;
            default:
                break;

        }
    }
}
//        Альтернативный метод встваки данных в поле TextView
//
// String date = "";
//
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Rashod", null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            date += cursor.getString(1) + " | ";
//            cursor.moveToNext();
//        }
//        cursor.close();
//
//        dateCurrent.setText(date);
//    }}












































    /*// public class MainActivity extends Activity implements View.OnClickListener {

    //Объявляем программе о существовании следующих объектов:
    private EditText mE0;
    private EditText mE1;
    private EditText mE2;
    private TextView mResult;
    private Button mB1;
    private Button mB2;
    private Button mB3;
    private Button mB4;
    private String mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Привязываем введенные программные объекты к созданным в файле разметки элементам:
        mE0=findViewById(R.id.et0);
        mE1=findViewById(R.id.et1);
        mE2=findViewById(R.id.et2);
        mResult=findViewById(R.id.result);
        mB1=findViewById(R.id.fuel);
        mB2=findViewById(R.id.oil);
        mB3=findViewById(R.id.atf);
        mB4=findViewById(R.id.antifreese);

        //Приписываем нашим кнопочкам нажатие:
        mB1.setOnClickListener(this);
        mB2.setOnClickListener(this);
        mB3.setOnClickListener(this);
        mB4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        //Вводим переменные, с которыми будем оперировать:
        float value1 = 0;
        float value2 = 0;
        float value3 = 0;
        float result = 0;

        //Принимаем значения для value1  value2 value 3 с элементов ввода:
        value1=Float.parseFloat(mE0.getText().toString());
        value2=Float.parseFloat(mE1.getText().toString());
        value3=Float.parseFloat(mE2.getText().toString());

        //Описываем действия кнопок:
        switch (v.getId()) {
            case R.id.fuel:
                mCount = "Рассчитать";
                result = value3  / (value2 - value1) * 100;
                break;
        }

        //настраиваем отображение результата:


        mResult.setText(result + " литров на 100 км");
    }
}//*/

