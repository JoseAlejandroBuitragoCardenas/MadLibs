package com.example.guest.madlibs;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    @Bind(R.id.storyTextView) TextView mStoryTextView;
    @Bind(R.id.homeAgain) Button mHomeAgain;
    private String[] mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);
        mStory = getResources().getStringArray(R.array.story_choices);

        Intent intent = getIntent();
        String [] userWords = intent.getStringArrayExtra("userWords");
        int radioValue = intent.getIntExtra("radioValue", 0);

        String storyText = String.format(mStory[radioValue], userWords[2], userWords[1], userWords[0], userWords[3]);
        mStoryTextView.setText(storyText);
        mHomeAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
