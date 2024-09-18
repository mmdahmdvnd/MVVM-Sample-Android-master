package com.mmd.mvvmexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28) // یا sdk نسخه اندروید مدنظر
public class LoginViewModelTest {

    private LoginViewModel loginViewModel;

    @Before
    public void setUp() {
        loginViewModel = new LoginViewModel();
    }

    @Test
    public void testLoginSuccess() {
        // فراخوانی متد login
        loginViewModel.doLogin("validUsername", "validPassword");

        // اجرای task های Handler
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        // بررسی نتیجه
        assertEquals("Login Successful", loginViewModel.loginStatus.getValue());
    }
}

/*
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import org.junit.Rule;
import org.robolectric.shadows.ShadowLooper;

public class LoginViewModelTest {

    private LoginViewModel loginViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        loginViewModel = new LoginViewModel();
    }

   // @Test
   // public void testDoLogin_Success() {
   //     loginViewModel.doLogin("validUser", "validPass");

   //     loginViewModel.loginStatus.observeForever(status -> {
   //         assertEquals("Login Successful", status);
   //     });
   // }

   @Test
   public void testLoginSuccess() {
       LoginViewModel loginViewModel = new LoginViewModel();
       loginViewModel.doLogin("validUsername", "validPassword");

       ShadowLooper.runUiThreadTasksIncludingDelayedTasks(); // اجرای همه تاخیرهای Handler

       assertEquals("Login Successful", loginViewModel.loginStatus.getValue());
   }

    @Test
    public void testDoLogin_Fail() {
        loginViewModel.doLogin("", "");

        loginViewModel.loginStatus.observeForever(status -> {
            assertEquals("Login Fail", status);
        });
    }
}
*/

