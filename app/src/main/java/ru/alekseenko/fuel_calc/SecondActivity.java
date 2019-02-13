package ru.alekseenko.fuel_calc;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.security.cert.Extension;
import java.util.Calendar;

public class SecondActivity extends Activity implements View.OnClickListener {

    EditText currentDateTime;
    EditText editZalito;
    EditText editCostFuel;
    EditText currentOdometer; //поля для ввода данных

    Button buttonSave; //кнопак сохранить введеные данные
    Button dateButton;

    Calendar dateAndTime = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener d;


    final String LOG_TAG = "myLogs";


    DBHelper dbHelper;
    // Переменная для управления DB, через методы:
    // query(),insert(),delete(),update(), execSQL()
    SQLiteDatabase sqLiteDatabase;

    // Переменная для курсора - временного объекта для хранения записей
    Cursor cursor;

    // Переменная для адаптера
    SimpleCursorAdapter simpleCursorAdapter;


    // Вызывается когда создана впервые активность
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);
        dateButton = (Button) findViewById(R.id.dateButton);
        editZalito = (EditText) findViewById(R.id.editZalito);
        editCostFuel = (EditText) findViewById(R.id.editCostFuel);
        currentOdometer = (EditText) findViewById(R.id.currentOdometer);
        currentDateTime = (EditText) findViewById(R.id.currentDateTime);
        setInitialDateTime();

// создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(this);


    }

    @Override
    public void onClick(View v) {


        // создаем объект для данных Класс ContentValues используется для указания полей таблицы и значений, которые
        // мы в эти поля будем вставлять. Мы создаем объект cv, и позже его используем. Далее мы записываем в переменные
        // значения из полей ввода. Затем, с помощью метода getWritableDatabase подключаемся к БД и получаем объект SQLiteDatabase.
        // Он позволит нам работать с БД. Мы будем использовать его методы insert – вставка записи, query – чтение, delete – удаление.
        // У них много разных параметров на вход, но мы пока используем самый минимум.
        ContentValues cv = new ContentValues();

        // получаем данные из полей ввода
        String date = currentDateTime.getText().toString();

        String capacity = editZalito.getText().toString();
        String cost = editCostFuel.getText().toString();
        String odometr = currentOdometer.getText().toString();


        // подключаемся к БД
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.buttonSave:
                Log.d(LOG_TAG, "--- Insert in Rashod: ---");

                // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("date", date);
                cv.put("capacity", capacity);
                cv.put("cost", cost);
                cv.put("odometr", odometr);


                // вставляем запись и получаем ее ID
                long rowID = sqLiteDatabase.insert("Rashod", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
////                case R.id.btnRead:
////                    Log.d(LOG_TAG, "--- Rows in Rashod: ---");
//                    // делаем запрос всех данных из таблицы Rashod, получаем Cursor
//                    // Cursor c = db.query("Rashod", null, null, null, null, null, null);
//
//                    // ставим позицию курсора на первую строку выборки
//                    // если в выборке нет строк, вернется false
//                    if (c.moveToFirst()) {
//
//                        // определяем номера столбцов по имени в выборке
//                        int idColIndex = c.getColumnIndex("id");
//                        int dataColIndex = c.getColumnIndex("дата");
//                        int capacityColIndex = c.getColumnIndex("заправлено");
//                        int costColIndex = c.getColumnIndex("стоимость");
//
//                        do {
//                            // получаем значения по номерам столбцов и пишем все в лог
//                            Log.d(LOG_TAG,
//                                    "ID = " + c.getInt(idColIndex) +
//                                            ", дата = " + c.getString(dataColIndex) +
//                                            ", заправлено = " + c.getString(capacityColIndex) +
//                                            ", стоимость = " + c.getString(costColIndex));
//
//                            // переход на следующую строку
//                            // а если следующей нет (текущая - последняя), то false - выходим из цикла
//                        } while (c.moveToNext());
//                    } else
//                        Log.d(LOG_TAG, "0 rows");
//                    c.close();
//                    break;
//                case R.id.btnClear:
//                    Log.d(LOG_TAG, "--- Clear Rashod: ---");
//                    // удаляем все записи
//                    int clearCount = db.delete("Rashod", null, null);
//                    Log.d(LOG_TAG, "deleted rows count = " + clearCount);
//                    break;
        }



        // закрываем подключение к БД
        sqLiteDatabase.close();


    }

//            @Override
//           public void onCreate(Bundle savedInstanceState) {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.second);
//                currentDateTime = (TextView) findViewById(R.id.currentDateTime);
//                setInitialDateTime();
//
//            }


    public void setDate(View v) {
        new DatePickerDialog(SecondActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // авто установка текущей даты
    private void setInitialDateTime() {

        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
        ));

        // установка обработчика выбора даты и вставка в поле для даты
        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateAndTime.set(Calendar.YEAR, year);
                dateAndTime.set(Calendar.MONTH, monthOfYear);
                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                setInitialDateTime();
            }

        };

    }

}

