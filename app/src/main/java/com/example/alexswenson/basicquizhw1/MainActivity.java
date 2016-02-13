package com.example.alexswenson.basicquizhw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        btnStartQuiz = (Button)findViewById(R.id.btnStartQuiz);
        btnStartQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startQuiz(view);
            }
        });
    }

    public void startQuiz(View view) {



    }
}
