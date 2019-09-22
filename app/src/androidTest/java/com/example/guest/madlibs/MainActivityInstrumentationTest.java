package com.example.guest.madlibs;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Guest on 11/15/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.adjective)).perform(typeText("pickle"))
                .check(matches(withText("pickle")));
    }

    @Test
    public void nounIsSentToStoryActivity() {
        String [] userWords = new String [] {"pickle", "egg", "tofu", "biscuit"};
        onView(withId(R.id.adjective)).perform(typeText(userWords[0]));
        onView(withId(R.id.gerund)).perform(typeText(userWords[1]));
        onView(withId(R.id.name)).perform(typeText(userWords[2]));
        onView(withId(R.id.color)).perform(typeText(userWords[3]));
        onView(withId(R.id.submitWords)).perform(click());
        onView(withId(R.id.storyTextView)).check(matches
                (withText("One day " + userWords[2] + " was " + userWords[1] + " and they saw a " + userWords[0] + " cat. The cat cast a spell and turned " + userWords[2] + " " + userWords[3] + ".")));
    }
}
