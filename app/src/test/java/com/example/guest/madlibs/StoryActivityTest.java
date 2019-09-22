package com.example.guest.madlibs;


import android.os.Build;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

/**
 * Created by Guest on 11/15/16.
 */
public class StoryActivityTest {
    private StoryActivity activity;

}
