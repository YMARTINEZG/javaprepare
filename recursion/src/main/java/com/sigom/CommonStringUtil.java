package com.sigom;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.sqrt;

public class CommonStringUtil implements CommonUtils{

    @Override
    public String getFibonacci(int n){
        StringBuilder str = new StringBuilder();
        for(int j=0; j< n; j++){
            str.append(Fibonacci(j)+",");
        }
        return str.deleteCharAt(str.length()-1).toString();
    }

    @Override
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for(int i=2; i< sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isPalindrome(String str) {
        int j = str.length() - 1;
        char[] temp = str.toLowerCase().toCharArray();
        for(int i=0 ; i < temp.length / 2 ; i++){
            if(temp[i] != temp[j]){
                return false;
            }
            j--;
        }
        return true;
    }

    @Override
    public boolean isNumberPalindrome(int n) {
        StringBuilder val = new StringBuilder();
        int ini = n;
        while ( n > 0) {
            val.append(String.valueOf(n % 10));
            n = n /10;
        }
        Integer rev = Integer.valueOf(val.toString());
        return rev == ini;

    }

    @Override
    public String reverseString(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i=s.length() - 1; i >= 0 ;i--){
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    @Override
    public String removeDuplicates(String array) {
        return array.chars()
                .distinct()
                .mapToObj(c-> (char)c)
//                map.put(c, map.get(c) + 1);
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    @Override
    public String printRepeatedWordInListOfString(List<String> list) {
        Map<String, Integer> result = new HashMap<>();
        list.stream().map(s -> result.merge(s, 1, Integer::sum));

        Optional<Map.Entry<String,Integer>> ent = result.entrySet().stream().reduce((e1, e2) -> e1.getValue() < e2.getValue()? e1 : e2);
        if (ent.isPresent()){
            System.out.println(ent.get().getKey());
        }else {
            System.out.println("Nothing");
        }

//        str = "sdhaskjhdkjashk"
//        Map<Integer, Integer> map = new HashMap<>();
//        str.chars().forEach(c -> {
//            if(map.containsKey(c)){
//            } else {
//                map.put(c,1);
//            }
//        });
//
//        for(int ch : map.keySet()){
//            int total = map.get(ch);
//            if (total > 1){
//                System.out.println(((char)ch + " " + total));
//            }
//
//        }
        return null;
    }

    @Override
    public boolean checkIfTwoStringAreAnagram(String s1, String s2) {
        return false;
    }

    @Override
    public String[] reverseArrayInPlace(String[] str) {
        for(int ind = 0; ind < str.length / 2 ; ind++){
            String tmp = str[ind];
            str[ind] = str[str.length - 1 - ind];
            str[str.length - 1 - ind] = tmp;
        }
        return str;
    }

    @Override
    public char[] reverseStringInPlace(char[] str) {
         return str;
    }

    @Override
    public String stringCompresion(String str) {
        return null;
    }

    @Override
    public void findSecondNotRepeatedOrderedCharOfString(String str) {

        Character ch = str.chars()
                .distinct()
                .mapToObj(c -> (char)c)
                .sorted(Comparator.naturalOrder())
                .skip(1)
                .findFirst()
                .orElse('N');

        System.out.println(ch);

        //int[] listInt = new int[]{2,6, 2,2,2,2,2, 3};
        //Optional<Integer> result = Arrays.stream(listInt).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst();
        //Optional<Integer> val = Arrays.asList(listInt).stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst();
        List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        Map<String, Integer> wordMap = new HashMap<>();
        words.forEach(s -> wordMap.merge(s, 1, Integer::sum));
        for(Map.Entry<String, Integer> entry: wordMap.entrySet()){
            System.out.println("[" + entry.getKey() + ", " + entry.getValue() +"]");
        }
    }

    @Override
    public String[] camelCaseSplit(String str) {
        String regex = "(?<=[a-z])(?=[A-Z])";
        String[] list = str.split(regex);
        System.out.println(Arrays.toString(list));
        return list;
    }

    private int Fibonacci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
