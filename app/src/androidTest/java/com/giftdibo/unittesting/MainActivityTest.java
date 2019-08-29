package com.giftdibo.unittesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;

    Instrumentation.ActivityMonitor moniter = getInstrumentation().addMonitor(SecondActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mainActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfSecondctivityOnButtonClick(){

        assertNotNull(mainActivity.findViewById(R.id.clickBtn));
        onView(withId(R.id.clickBtn)).perform(click());
        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(moniter,500);
        assertNotNull(secondActivity);

    }

    @After
    public void tearDown() throws Exception {
    }
}