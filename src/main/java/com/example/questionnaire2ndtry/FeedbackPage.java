package com.example.questionnaire2ndtry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackPage extends AppCompatActivity {
    Button btn_next,btn_retake;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_feedback);

        addListenerOnButtons();
    }

    protected void addListenerOnButtons() {
        btn_next = (Button) findViewById(R.id.fb_btn_next);
        btn_retake = (Button) findViewById(R.id.fb_btn_retake);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainMenu = new Intent(view.getContext(),MainPage.class);
                startActivityForResult(mainMenu,0);
            }
        });

        btn_retake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionnaire = new Intent(view.getContext(), QuestionPage.class);
                startActivityForResult(questionnaire,0);
            }
        });
    }
}
