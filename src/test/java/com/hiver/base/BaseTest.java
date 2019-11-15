package com.hiver.base;

import com.hiver.Base;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends Base {

    @BeforeSuite
    public static void before() {
        initialization();
    }
}
