package com.sigom;


import java.util.List;

public interface CommonUtils {
    String getFibonacci(int n);
    boolean isPrime(int n);
    boolean isPalindrome(String str);
    boolean isNumberPalindrome(int n);
    String reverseString(String s);
    String removeDuplicates(String array);
    String printRepeatedWordInListOfString(List<String> list);
    boolean checkIfTwoStringAreAnagram(String s1, String s2);
    String[] reverseArrayInPlace(String[] str);
    char[] reverseStringInPlace(char[] str);
    String stringCompresion(String str);
    void findSecondNotRepeatedOrderedCharOfString(String str);
    String[] camelCaseSplit(String str);
}
