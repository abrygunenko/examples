package com.softserve.crashcourse.session8.example1;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.testng.Assert.*;

public class TestNGTest1 {
    private Collection collection;

    @BeforeClass
    public void oneTimeSetUp() {
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @BeforeMethod
    public void setUp() {
        collection = new ArrayList();
        System.out.println("@BeforeMethod - setUp");
    }

    @AfterMethod
    public void tearDown() {
        collection.clear();
        System.out.println("@AfterMethod - tearDown");
    }

    @Test
    public void testEmptyCollection() {
        assertEquals(collection.isEmpty(), true);
        assertTrue(collection.isEmpty());
        System.out.println("@Test - testEmptyCollection");
    }

    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        assertEquals(collection.size(), 1);
        System.out.println("@Test - testOneItemCollection");
    }
}
