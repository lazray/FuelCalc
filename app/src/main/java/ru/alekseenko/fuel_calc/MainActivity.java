package ru.alekseenko.fuel_calc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.TextView;







    public class MainActivity extends Activity {



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);




    }

        //Описываем процесс перехода с MainActivity в SecondActivity,
        // который будет происходить при нажатии на нашу кнопку:
        public void Click(View view) {
            //Создаем переход:
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            //Запускаем его при нажатии:
            startActivity(intent);
        }
    }
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

