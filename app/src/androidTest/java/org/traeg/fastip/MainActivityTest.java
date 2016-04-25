package org.traeg.fastip;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest{

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);



    //Test case01 - Validating bill total with percentage change of (5%)
    @Test
    public void testCalcTotalPercentageEdit(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("5"), closeSoftKeyboard());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withId(R.id.billAmtEditText)).perform(typeText("200"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$210.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$10.00")));

    }

    //Test case02 - Validating bill total with percentage change of (10%)
    @Test
    public void testCalcTotalAmount(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withId(R.id.billAmtEditText)).perform(typeText("500"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$550.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$50.00")));
    }

    //Test case03 - Calculate the value of the empty bill
    @Test
    public void testCalcTotalNull(){
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$0.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$0.00")));
    }


    //test case04 - Calculate 0 dolar bill
    @Test
    public void testCalcTotalZero(){
        onView(withId(R.id.billAmtEditText)).perform(typeText("0000"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$0.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$0.00")));
    }

    //test case05 - Calculate tip with a negative value
    @Test
    public void testCalcTotalNegative(){
        onView(withId(R.id.billAmtEditText)).perform(typeText("-0000"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$-0.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$-0.00")));
    }

    //test case06 - Validating percentage change to 0%
    @Test
    public void testCalcTotalPercentageZero(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withId(R.id.billAmtEditText)).perform(typeText("35"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$35.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$0.00")));

    }


    ////test case07 - Validating value with a special character
    @Test
    public void testCalcTotalSpecialCharacter(){
        onView(withId(R.id.billAmtEditText)).perform(typeText("-"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$0.00")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$0.00")));

    }

    //Test case08 - Validating letters and numbers input
    @Test
    public void testCalcTotalWithLetter(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withId(R.id.billAmtEditText)).perform(typeText("tt833"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$916.30")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$83.30")));
    }

    //Test case9 - Validating letters and numbers on the percentage of tip
    @Test
    public void testCalcTotalPercentageWithLetter(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.tipPercentageEditText)).perform(typeText("tt10"), closeSoftKeyboard());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withId(R.id.billAmtEditText)).perform(typeText("78"), closeSoftKeyboard());
        onView(withId(R.id.calcTipButton)).perform(click());
        onView(withId(R.id.totalAmtTextView)).check(matches(withText("$85.80")));
        onView(withId(R.id.tipAmtTextView)).check(matches(withText("$7.80")));
    }


    //Test case10 - Validating percentage null
    @Test
    public void testCalcTotalPercentageNull(){
        onView(withId(R.id.menu_settings)).perform(click());
        onView(withId(R.id.tipPercentageEditText)).perform(clearText());
        onView(withId(R.id.saveSettingsButton)).perform(click());
        onView(withText(containsString("A decimal value is required"))).check(matches(anything()));

    }


}




