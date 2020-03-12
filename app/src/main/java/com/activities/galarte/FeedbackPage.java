package com.activities.galarte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class FeedbackPage extends AppCompatActivity {
    Button btn_next,btn_retake;
    TextView fb_text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_feedback);

        addListenerOnButtons();

        int[] answers = getIntent().getIntArrayExtra("Answers");
        calculateStyle(answers);
    }

    protected void addListenerOnButtons() {
        btn_next = findViewById(R.id.fb_btn_next);
        btn_retake = findViewById(R.id.fb_btn_retake);


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

    protected void calculateStyle(int[] answers){
        fb_text = findViewById(R.id.fb_text);
        fb_text.setText(Arrays.toString(answers).toCharArray(), 0, answers.length*3);

    }
}
