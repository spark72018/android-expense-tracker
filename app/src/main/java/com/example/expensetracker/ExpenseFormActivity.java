package com.example.expensetracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import java.util.Objects;

public class ExpenseFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_form);

        initHideKeyboardOnTouch();
        initSubmitFormListener();
    }

    private void initSubmitFormListener() {
        final Button button = findViewById(R.id.submit_form);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitExpenseForm(v);
            }
        });
    }

    public void submitExpenseForm(View view) {
        System.out.println("Some shit here");
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initHideKeyboardOnTouch() {
        ConstraintLayout parent = findViewById(R.id.parent_constraint);
        if (parent == null) return;
        parent.setOnTouchListener(hideKeyboardOnTouchListener());
    }

    private View.OnTouchListener hideKeyboardOnTouchListener() {
        return new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                IBinder windowToken = Objects.requireNonNull(getWindow().getCurrentFocus()).getWindowToken();

                if (imm == null || windowToken == null)
                    return false;

                imm.hideSoftInputFromWindow(windowToken, 0);

                return false;
            }
        };
    }
}
