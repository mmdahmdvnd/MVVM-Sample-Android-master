package com.mmd.mvvmexample;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserModelTest {

    private UserModel userModel;

    @Before
    public void setUp() throws Exception {
        // کاربر فرضی برای تست
        userModel = new UserModel("testUser", "testPass");
    }

    @Test
    public void testGetUsername() {
        assertEquals("testUser", userModel.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("testPass", userModel.getPassword());
    }

    @Test
    public void testCheckUserValidity_ValidUser() {
        int result = userModel.checkUserValidity("testUser", "testPass");
        assertEquals(0, result); // تست برای کاربر معتبر
    }

    @Test
    public void testCheckUserValidity_InvalidUser() {
        int result = userModel.checkUserValidity("", ""); // تست برای کاربر نامعتبر
        assertEquals(-1, result);
    }
}
