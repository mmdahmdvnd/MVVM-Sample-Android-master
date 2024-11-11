package com.mmd.mvvmexample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testLoginButtonClicked() {
        // وارد کردن نام کاربری و رمز عبور
        onView(withId(R.id.et_name)).perform(ViewActions.typeText("validUser"));
        onView(withId(R.id.et_password)).perform(ViewActions.typeText("validPass"));

        // کلیک بر روی دکمه لاگین
        onView(withId(R.id.bt_submit)).perform(ViewActions.click());

        // بررسی اینکه Toast نمایش داده شده است
        onView(ViewMatchers.withText("Login Successful"))
                .inRoot(new ToastMatcher())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
