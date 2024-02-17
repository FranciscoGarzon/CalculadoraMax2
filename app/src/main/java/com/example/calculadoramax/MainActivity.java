package com.example.calculadoramax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculadoramax.R;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private double operand1;
    private double operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        operand1 = 0;
        operand2 = 0;
        operator = "";

        // Inicializar los botones y asignar los listeners
        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnEquals = findViewById(R.id.btnEquals);
        Button btnFactorial = findViewById(R.id.btnFactorial);
        Button btnFibonacci = findViewById(R.id.btnFibonacci);
        Button btnback = findViewById(R.id.backButton);

        btn0.setOnClickListener(v -> appendNumber("0"));
        btn1.setOnClickListener(v -> appendNumber("1"));
        btn2.setOnClickListener(v -> appendNumber("2"));
        btn3.setOnClickListener(v -> appendNumber("3"));
        btn4.setOnClickListener(v -> appendNumber("4"));
        btn5.setOnClickListener(v -> appendNumber("5"));
        btn6.setOnClickListener(v -> appendNumber("6"));
        btn7.setOnClickListener(v -> appendNumber("7"));
        btn8.setOnClickListener(v -> appendNumber("8"));
        btn9.setOnClickListener(v -> appendNumber("9"));
        btnDot.setOnClickListener(v -> appendNumber("."));
        btnClear.setOnClickListener(v -> clearDisplay());
        btnPlus.setOnClickListener(v -> handleOperator("+"));
        btnMinus.setOnClickListener(v -> handleOperator("-"));
        btnMultiply.setOnClickListener(v -> handleOperator("*"));
        btnDivide.setOnClickListener(v -> handleOperator("/"));
        btnEquals.setOnClickListener(v -> evaluateExpression());
        btnFactorial.setOnClickListener(v -> calculateFactorial());
        btnFibonacci.setOnClickListener(v -> calculateFibonacci());
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar de vuelta al MainActivity
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });
    }

    private void appendNumber(String number) {
        String currentText = tvDisplay.getText().toString();
        if (!currentText.equals("0")) {
            tvDisplay.setText(currentText + number);
        } else {
            tvDisplay.setText(number);
        }
    }

    private void clearDisplay() {
        tvDisplay.setText("0");
    }

    private void handleOperator(String operator) {
        String currentText = tvDisplay.getText().toString();
        operand1 = Double.parseDouble(currentText);
        this.operator = operator;
        tvDisplay.setText("0");
    }

    private void evaluateExpression() {
        String currentText = tvDisplay.getText().toString();
        operand2 = Double.parseDouble(currentText);
        double result = calculate();
        tvDisplay.setText(String.valueOf(result));
    }

    public static double suma(double a, double b) {
        return a + b;
    }

    public static double resta(double a, double b) {
        return a - b;
    }
public static double multiplicacion(double a, double b) {
        return a * b;
    }
public static double division(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        } else {
            return a / b;
        }
    }



    private double calculate() {
        double result = 0;
        switch (operator) {
            case "+":
                result = suma(operand1, operand2);
                break;
            case "-":
                result = resta(operand1, operand2);
                break;
            case "*":
                result = multiplicacion(operand1, operand2);
                break;
            case "/":
                result = division(operand1, operand2);
                break;
        }
        return result;
    }

    private void calculateFactorial() {
        String currentText = tvDisplay.getText().toString();
        int number = Integer.parseInt(currentText);
        int result = factorial(number);
        tvDisplay.setText(String.valueOf(result));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private void calculateFibonacci() {
        String currentText = tvDisplay.getText().toString();
        int n = Integer.parseInt(currentText);
        int result = fibonacci(n);
        tvDisplay.setText(String.valueOf(result));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fib = 1, prevFib = 1;
        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
