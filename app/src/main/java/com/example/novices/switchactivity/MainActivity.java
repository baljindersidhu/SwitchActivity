package com.example.novices.switchactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    private static RadioGroup rg_topic;
    private static RadioButton rb_topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button next = (Button) findViewById(R.id.NextButton);

        // disable the button until a radiobutton is clicked
        next.setEnabled(false);

        rg_topic = (RadioGroup) findViewById(R.id.rg_topic);
        rg_topic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // enabling the button to perform given action
                next.setEnabled(true);

                // checkedId returns the Id of the checked radiobutton
                // that can be used inside the switch statement
                // to fire up the picked database
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checked_topic = rg_topic.getCheckedRadioButtonId();
                rb_topic = (RadioButton) findViewById(checked_topic);

                // use this to match the topic with database to import


                // switching to Quiz activity
                rg_topic.clearCheck();
                Intent intent = new Intent(MainActivity.this, SecondActivtiy.class);
                startActivity(intent);
            }
        });
    }
}
