package com.example.calculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText;
    private EditText num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1);
        num2EditText = findViewById(R.id.num2);
        resultTextView = findViewById(R.id.result);

        setupOperation(findViewById(R.id.btnAdd), '+');
        setupOperation(findViewById(R.id.btnSub), '-');
        setupOperation(findViewById(R.id.btnMul), '*');
        setupOperation(findViewById(R.id.btnDiv), '/');
    }

    private void setupOperation(Button button, char operation) {
        button.setOnClickListener(v -> calculate(operation));
    }

    private void calculate(char operation) {
        String firstValue = num1EditText.getText().toString().trim();
        String secondValue = num2EditText.getText().toString().trim();

        if (firstValue.isEmpty() || secondValue.isEmpty()) {
            resultTextView.setText("Enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(firstValue);
        double num2 = Double.parseDouble(secondValue);
        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultTextView.setText("Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                resultTextView.setText("Unknown operation");
                return;
        }

        resultTextView.setText(String.format(Locale.US, "Result: %s", result));
    }
}
