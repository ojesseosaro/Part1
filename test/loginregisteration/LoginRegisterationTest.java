/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package loginregisteration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginRegisterationTest {

    @Test
    public void testCorrectUsernameFormat() {
        assertTrue(LoginRegisteration.checkUserName("kyl_1"));
    }

    @Test
    public void testIncorrectUsernameFormat() {
        assertFalse(LoginRegisteration.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testValidPasswordComplexity() {
        assertTrue(LoginRegisteration.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPasswordComplexity() {
        assertFalse(LoginRegisteration.checkPasswordComplexity("password"));
    }

    @Test
    public void testCorrectPhoneNumberFormat() {
        assertTrue(LoginRegisteration.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testIncorrectPhoneNumberFormat() {
        assertFalse(LoginRegisteration.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testValidateUsernameSuccessMessage() {
        String result = LoginRegisteration.validateUsername("kyl_1");
        assertEquals("Username successfully captured.", result);
    }

    @Test
    public void testValidateUsernameFailureMessage() {
        String result = LoginRegisteration.validateUsername("kyle!!!!!!!");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testValidatePasswordSuccessMessage() {
        String result = LoginRegisteration.validatePassword("Ch&&sec@ke99!");
        assertEquals("Password successfully captured.", result);
    }

    @Test
    public void testValidatePasswordFailureMessage() {
        String result = LoginRegisteration.validatePassword("password");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterUserSuccess() {
        String result = LoginRegisteration.registerUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Registration successful.", result);
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        String result = LoginRegisteration.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        String result = LoginRegisteration.registerUser("kyl_1", "password");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testRegisterUserBothInvalid() {
        String result = LoginRegisteration.registerUser("kyle!!!!!!!", "password");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.\n"
                   + "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testLoginSuccessMessage() {
        String result = LoginRegisteration.returnLoginStatus("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertEquals("*****Login Successful*****\nWelcome back, Kyle Smith!", result);
    }

    @Test
    public void testLoginFailureMessage() {
        String result = LoginRegisteration.returnLoginStatus("kyl_1", "Ch&&sec@ke99!", "wrong", "wrongpass", "Kyle", "Smith");
        assertEquals("Login failed: Username or password incorrect.", result);
    }
} 
