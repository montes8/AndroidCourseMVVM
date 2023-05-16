package com.gb.vale.androidcoursemvvm.ui.login

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.gb.vale.androidcoursemvvm.R
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun validateLoginLabel() {
        Espresso.onView(ViewMatchers.withId(R.id.editUserLogin))
            .perform(ViewActions.typeText("gabbi0812@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.editPassLogin))
            .perform(ViewActions.typeText("gabbi@1"))
        Espresso.onView(ViewMatchers.withId(R.id.btnLogin)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("gabbi0812@gmail.com"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("gabbi@1"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}