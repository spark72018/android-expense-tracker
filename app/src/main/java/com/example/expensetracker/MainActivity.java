package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLoginButtonListener();
    }

    private void initLoginButtonListener() {
        final Button loginButton = findViewById(R.id.login_button);

        if (loginButton == null) return;

        loginButton.setOnClickListener(getLoginButtonClickListener());
    }

    private View.OnClickListener getLoginButtonClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick(v);
            }
        };
    }

    private void onLoginClick(View v) {
        Intent nextActivity = new Intent(getApplicationContext(), ExpenseFormActivity.class);
        startActivity(nextActivity);
    }
}
