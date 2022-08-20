package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@SuiteClasses({ EmailValidatorTest.class, PasswordValidatorTest.class })
public class TestSuite {

	
}