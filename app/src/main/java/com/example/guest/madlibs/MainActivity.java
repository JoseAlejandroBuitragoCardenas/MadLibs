package com.example.guest.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.adjective) EditText mAdjective;
    @Bind(R.id.job) EditText mJob;
    @Bind(R.id.noun) EditText mNoun;
    @Bind(R.id.adjective2) EditText mAdjective2;
    @Bind(R.id.submitWords) Button mSubmitWords;
    int radioValue=0;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_story1:
                if (checked)
                    radioValue = 0;
                break;
            case R.id.radio_story2:
                if (checked)
                    radioValue = 1;
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitWords.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String adjective = mAdjective.getText().toString();
                String job = mJob.getText().toString();
                String noun = mNoun.getText().toString();
                String adjective2 = mAdjective2.getText().toString();
                if (adjective.matches("") || job.matches("") || noun.matches("") || adjective2.matches("")) {
                    Toast.makeText(MainActivity.this, "Los campos deben estar completos!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String [] userWords = new String [] {adjective, job, noun, adjective2};
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("userWords", userWords);
                intent.putExtra("radioValue", radioValue);
                startActivity(intent);
                mAdjective.setText("");
                mJob.setText("");
                mNoun.setText("");
                mAdjective2.setText("");
            }
        });
    }
}
