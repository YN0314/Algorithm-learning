package com.intheriv.algorithm.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class LoggerTest extends TestCase{
    public LoggerTest(){
        super();
    }
    
    public void testCase01() {
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        logger.info("hello world.");
    }
}
