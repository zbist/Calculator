package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String SaveAnswer = "ANSWER";
    private static final String SaveText = "TEXT";
    private static final String SaveCheckBox = "CHECKBOX";
    private static final String SaveOperation = "OPERATION";
    private static final String SavePoint = "POINT";

    private Calc calc = new Calc();
    private TextView answerView;
    private TextView textView;
    private boolean hasOperation = false;
    private boolean hasPoint = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SaveAnswer, answerView.getText().toString());
        outState.putString(SaveText, textView.getText().toString());
        outState.putBoolean(SavePoint, hasPoint);
        outState.putBoolean(SaveOperation, hasOperation);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        answerView.setText(savedInstanceState.getString(SaveAnswer));
        textView.setText(savedInstanceState.getString(SaveText));
        hasPoint = savedInstanceState.getBoolean(SavePoint);
        hasOperation = savedInstanceState.getBoolean(SaveOperation);
    }

    private void init(){
        answerView = findViewById(R.id.answer_view);
        textView = findViewById(R.id.text_view);
        initButton0ClickListener();
        initButton1ClickListener();
        initButton2ClickListener();
        initButton3ClickListener();
        initButton4ClickListener();
        initButton5ClickListener();
        initButton6ClickListener();
        initButton7ClickListener();
        initButton8ClickListener();
        initButton9ClickListener();
        initButtonPointClickListener();
        initButtonDelClickListener();
        initButtonDivClickListener();
        initButtonSumClickListener();
        initButtonMulClickListener();
        initButtonSubClickListener();
        initButtonEqualClickListener();
    }

    private void initButton0ClickListener(){
        findViewById(R.id.button_0).setOnClickListener(v -> textView.append("0"));
    }

    private void initButton1ClickListener(){
        findViewById(R.id.button_1).setOnClickListener(v -> textView.append("1"));
    }

    private void initButton2ClickListener(){
        findViewById(R.id.button_2).setOnClickListener(v -> textView.append("2"));
    }

    private void initButton3ClickListener(){
        findViewById(R.id.button_3).setOnClickListener(v -> textView.append("3"));
    }

    private void initButton4ClickListener(){
        findViewById(R.id.button_4).setOnClickListener(v -> textView.append("4"));
    }

    private void initButton5ClickListener(){
        findViewById(R.id.button_5).setOnClickListener(v -> textView.append("5"));
    }

    private void initButton6ClickListener(){
        findViewById(R.id.button_6).setOnClickListener(v -> textView.append("6"));
    }

    private void initButton7ClickListener(){
        findViewById(R.id.button_7).setOnClickListener(v -> textView.append("7"));
    }

    private void initButton8ClickListener(){
        findViewById(R.id.button_8).setOnClickListener(v -> textView.append("8"));
    }

    private void initButton9ClickListener(){
        findViewById(R.id.button_9).setOnClickListener(v -> textView.append("9"));
    }

    private void initButtonPointClickListener(){
        findViewById(R.id.button_point).setOnClickListener(v -> {
            if (!hasPoint){
                textView.append(".");
                hasPoint = true;
            }
        });
    }

    private void initButtonDelClickListener(){
        findViewById(R.id.button_del).setOnClickListener(v -> {
            textView.setText("");
            hasPoint = false;
            hasOperation = false;
        });
    }

    private void initButtonDivClickListener(){
        findViewById(R.id.button_div).setOnClickListener(v -> {
            if(textView.getText().toString().length() != 0 && !hasOperation) {
                textView.append("/");
                hasOperation = true;
                hasPoint = false;
            }
        });
    }

    private void initButtonMulClickListener(){
        findViewById(R.id.button_mul).setOnClickListener(v -> {
            if(textView.getText().toString().length() != 0 && !hasOperation) {
                textView.append("*");
                hasOperation = true;
                hasPoint = false;
            }
        });
    }

    private void initButtonSumClickListener(){
        findViewById(R.id.button_sum).setOnClickListener(v -> {
            if(textView.getText().toString().length() != 0 && !hasOperation) {
                textView.append("+");
                hasOperation = true;
                hasPoint = false;
            }
        });
    }

    private void initButtonSubClickListener(){
        findViewById(R.id.button_sub).setOnClickListener(v -> {
            if(textView.getText().toString().length() != 0 && !hasOperation) {
                textView.append("-");
                hasOperation = true;
                hasPoint = false;
            }
        });
    }

    private void initButtonEqualClickListener(){
        findViewById(R.id.button_equal).setOnClickListener(v -> {
            if(hasOperation) {
                try {
                    calc.solveEquation(textView.getText().toString());
                    answerView.setText(calc.solveEquation(textView.getText().toString()) + "");
                } catch (RuntimeException e) {
                    answerView.setText("Так низя!!!");
                } finally {
                    textView.setText("");
                    hasOperation = false;
                    hasPoint = false;
                }

            }
        });
    }
}