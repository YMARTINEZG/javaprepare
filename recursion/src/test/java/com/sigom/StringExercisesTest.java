package com.sigom;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringExercisesTest {

    private CommonUtils util;


    @Before
    public void init(){
        util = new CommonStringUtil();
    }


    @Test
    public void printFibonaciTest(){
        String result = util.getFibonacci(10);
        Assert.assertEquals(result,("0,1,1,2,3,5,8,13,21,34"));
    }
    @Test
    public void checkIfNumberIsPrime(){
        Assert.assertTrue(util.isPrime(17));
        Assert.assertFalse(util.isPrime(24));
    }
    @Test
    public void checkStringIsPalindrome(){
        Assert.assertTrue(util.isPalindrome("Bob"));
        Assert.assertTrue(util.isPalindrome("Racecar"));
        Assert.assertFalse(util.isPalindrome("aacbaa"));
    }
    @Test
    public void checkIfNumberIsPalindrome(){
        Assert.assertFalse(util.isNumberPalindrome(4221324));
    }
    @Test
    public void reverseStringTest(){
        Assert.assertEquals( util.reverseString("ahjsnb"), "bnsjha" );
    }

    @Test
    public void checkIfRemoveDuplicatesfromArray(){
        Assert.assertEquals(util.removeDuplicates("ahjsnbbuxjl"), "ahjsnbuxl");
    }

    @Test
    public void reverseArrayOfStringOnPlaceTest(){
        String[] in = new String[]{"cd", "ab", "bc"};
        String[] out = new String[]{"bc", "ab", "cd"};
        Assert.assertArrayEquals(util.reverseArrayInPlace(in), out);

    }
}
