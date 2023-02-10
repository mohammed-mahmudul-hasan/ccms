package com.example.ccms;

import android.provider.ContactsContract;
import com.google.protobuf.Empty;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignupActivityTest {
    @Test
    public void failedtesting() {
        SignupActivity signupActivity = new SignupActivity();
        String signup_user_name = "";
        String signup_user_email = "";
        String signup_user_mobile = "";
        String signup_user_pass = "";
        String signup_user_confirm_pass = "";
    }
    @Test
    public void SuccessfulTesting() {
        SignupActivity signupActivity = new SignupActivity();
        String signup_user_name = "Mahmudul";
        String signup_user_email = "hasan256@gmail.com";
        String signup_user_mobile = "01521334452";
        String signup_user_pass = "Karim2564@";
        String signup_user_confirm_pass = "Karim2564@";
        assertEquals("Hasan","");
    }

}
