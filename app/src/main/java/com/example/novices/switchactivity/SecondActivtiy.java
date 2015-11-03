package com.example.novices.switchactivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivtiy extends AppCompatActivity {

    private int count = 1;
    static int isActive = 0;
    private static RadioGroup rg_quiz;
    private static RadioButton rb_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activtiy);

        final TextView questionNo = (TextView) findViewById(R.id.questionNo);
        questionNo.setText("#1");

        final Button nextButton = (Button) findViewById(R.id.next_button_quiz);

        // disable the button until a radiobutton is clicked
        nextButton.setEnabled(false);

        rg_quiz = (RadioGroup) findViewById(R.id.rg_quiz);
        rg_quiz.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // enabling the button to perform given action
                nextButton.setEnabled(true);

            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_option = rg_quiz.getCheckedRadioButtonId();
                rb_quiz = (RadioButton) findViewById(selected_option);

                // match if the checked answer is correct or not
                // by using a switch statement

                // uncheck the checked radio button
                rg_quiz.clearCheck();

                // disable the nextButton until option is selected
                // for next question
                nextButton.setEnabled(false);

                // Toast to display when next button is clicked
                Context context = getApplicationContext();
                CharSequence toastMessage = "Wrong Answer";
                int toastDuration = Toast.LENGTH_SHORT;
                Toast nextButtonToastMessage = Toast.makeText(context, toastMessage, toastDuration);
                nextButtonToastMessage.show();

                //increase Question Number and update TextView
                ++count;
                questionNo.setText("#" + count);
            }
        });
    }
}
