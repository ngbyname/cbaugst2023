package com.code.bull.commonutils.actions;

import com.code.bull.commonutils.commonlib.CommonLib;
import io.netty.util.internal.StringUtil;
import org.testng.Assert;

public class BaseActions {

    public static Boolean assertFlag = null;
    public static CommonLib commonLib;

    public Boolean assertEqualsBoolean(boolean actual, boolean expected) {
        return assertEqualsBoolean(actual, expected, "", "");
    }

    public static Boolean assertEqualsBoolean(boolean actual, boolean expected, String passDesc, String failDescription) {
        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
        } catch (AssertionError e) {

        }
        return assertFlag;
    }

    public static Boolean assertEqualsString(String actual, String expected, String passDesc, String failDesc) {

        assertFlag = false;
        try {
            Assert.assertEquals(actual, expected);
            assertFlag = true;
            CommonLib.pass(passDesc);
        } catch (AssertionError e) {
            CommonLib.error(failDesc);
        }
        return assertFlag;
    }

    public static void checkAllAssert(StringBuilder assertCheck) {
        if (assertCheck.isEmpty() || assertCheck.toString().contains("false")) {
            Assert.fail("Some assertions got failed");
        } else {
            commonLib.pass("All assertions are verified and passed");
        }
    }
}
