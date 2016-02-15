package com.example.alexswenson.basicquizhw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.containerQuizFragment, QuizFragment_Question1.newInstance(0, 0))
                .addToBackStack(null)
                .commit();
    }
}
