package com.example.easycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText, inputText;

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEq;
    Button buttonClear, buttonAllClear, buttonDot;

    double num1 = 0, num2 = 0, result = 0;
    String operator = "";
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.result_tv);
        inputText = findViewById(R.id.solution_tv);

        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);

        buttonAdd = findViewById(R.id.button_plus);
        buttonSub = findViewById(R.id.button_minus);
        buttonMul = findViewById(R.id.button_multiply);
        buttonDiv = findViewById(R.id.button_divide);
        buttonEq = findViewById(R.id.button_equals);

        buttonClear = findViewById(R.id.button_c);
        buttonAllClear = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("0"); }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("1"); }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("2"); }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("3"); }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("4"); }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("5"); }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("6"); }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("7"); }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("8"); }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNumber("9"); }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.contains(".")) {
                    if (input.isEmpty()) input = "0.";
                    else input += ".";
                    inputText.setText(input);
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setOperator("+"); }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setOperator("-"); }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setOperator("*"); }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { setOperator("/"); }
        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { calculateResult(); }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    inputText.setText(input);
                }
            }
        });

        buttonAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "";
                num1 = num2 = result = 0;
                operator = "";
                inputText.setText("");
                resultText.setText("0");
            }
        });
    }

    private void addNumber(String number) {
        input += number;
        inputText.setText(input);
    }

    private void setOperator(String op) {
        if (!input.isEmpty()) {
            num1 = Double.parseDouble(input);
            operator = op;
            inputText.setText(num1 + " " + op + " ");
            input = "";
        }
    }

    private void calculateResult() {
        if (!input.isEmpty() && !operator.isEmpty()) {
            num2 = Double.parseDouble(input);

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 != 0) result = num1 / num2;
                    else {
                        resultText.setText("Error");
                        return;
                    }
                    break;
            }
            
            resultText.setText(String.valueOf(result));
            input = String.valueOf(result);
            operator = "";
        }
    }
}
