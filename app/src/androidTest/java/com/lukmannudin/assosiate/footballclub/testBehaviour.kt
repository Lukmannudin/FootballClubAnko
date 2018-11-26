package com.lukmannudin.assosiate.footballclub

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.lukmannudin.assosiate.footballclub.R.id.*
import org.junit.Rule
import org.junit.Test


class testBehaviour {
    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)
    @Test
    fun testAppBehaviour(){
        Thread.sleep(5000) // Time in Millisecond
        onView(withId(spinner))
            .check(matches(isDisplayed()))
        onView(withId(spinner)).perform(click())
        onView(withText("Spanish La Liga")).perform(click())

        Thread.sleep(5000) // Time in Millisecond
        onView(withText("Barcelona"))
            .check(matches(isDisplayed()))
        onView(withText("Barcelona")).perform(click())

        Thread.sleep(5000) // Time in Millisecond
        onView(withId(add_to_favorite))
            .check(matches(isDisplayed()))

        Thread.sleep(5000) // Time in Millisecond
        pressBack()

        Thread.sleep(5000) // Time in Millisecond
        onView(withId(bottom_navigation))
            .check(matches(isDisplayed()))
        onView(withId(favorites)).perform(click())
    }

}