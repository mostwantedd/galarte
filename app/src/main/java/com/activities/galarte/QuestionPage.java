package com.activities.galarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QuestionPage extends AppCompatActivity {
    private Button btn_next;
    private RadioGroup[] questions = new RadioGroup[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_page);

        addListenerOnButton();
        addListenerOnQuestions();
    }

    protected void addListenerOnButton() {
        btn_next = findViewById(R.id.qs_btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextQuestions = new Intent(view.getContext(),QuestionPage2.class);
                int[] answers = new int[questions.length];
                RadioButton radBtn;

                for (int i =0; i < questions.length; i++) {
                    radBtn = findViewById(questions[i].getCheckedRadioButtonId());

                    switch(radBtn.getText().toString()) {
                        case "1":
                            answers[i] = 1;
                            break;
                        case "2" :
                            answers[i] = 2;
                            break;
                        case "3" :
                            answers[i] = 3;
                            break;
                        case "Don't Know":
                            answers[i] = -1;
                            break;
                        default:
                            //not supposed to happen
                            break;
                    }
                }
                nextQuestions.putExtra("Answers", answers);
                startActivity(nextQuestions);
            }
        });
    }

    protected void addListenerOnQuestions() {
        questions[0] = findViewById(R.id.q0_rad_group);
        questions[1] = findViewById(R.id.q1_rad_group);
        questions[2] = findViewById(R.id.q2_rad_group);
        questions[3] = findViewById(R.id.q3_rad_group);
        questions[4] = findViewById(R.id.q4_rad_group);
        questions[5] = findViewById(R.id.q5_rad_group);
        questions[6] = findViewById(R.id.q6_rad_group);

        questions[0].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

            }

        });

        questions[1].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

            }

        });

        questions[2].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

            }

        });

        questions[3].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

                //Something to do with the question
            }

        });

        questions[4].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

                //Something to do with the question
            }

        });

        questions[5].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

                //Something to do with the question
            }

        });

        questions[6].setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                findViewById(R.id.qs_btn_next).setEnabled(areAllQsAnswered());

                //Something to do with the question
            }

        });
    }

    private boolean areAllQsAnswered() {
        int i = 0;
        while(i < questions.length && (questions[i].getCheckedRadioButtonId()) != -1) {
            i++;
        }

        return i==questions.length;
    }
}
