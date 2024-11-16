package com.rusak.okr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextA = findViewById(R.id.editTextA);
        EditText editTextB = findViewById(R.id.editTextB);
        EditText editTextAlpha = findViewById(R.id.editTextAlpha);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Получение данных из полей ввода
                    double a = Double.parseDouble(editTextA.getText().toString());
                    double b = Double.parseDouble(editTextB.getText().toString());
                    double alpha = Double.parseDouble(editTextAlpha.getText().toString());

                    // Проверка на недопустимые значения
                    if (a <= 0 || b <= 0 || alpha <= 0 || alpha > 90) {
                        showInvalidInputToast("Недопустимые числа!");
                        return;
                    }

                    // Конвертация угла в радианы
                    double alphaInRadians = Math.toRadians(alpha);

                    // Вычисление площади
                    double result = a * b * Math.sin(alphaInRadians);

                    // Отображение результата
                    textViewResult.setText(String.format("%.3f", result));

                } catch (NumberFormatException e) {
                    showInvalidInputToast("Недопустимые символы!");
                }
            }
        });
    }

    // Функция для отображения уведомления о некорректных данных
    private void showInvalidInputToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
