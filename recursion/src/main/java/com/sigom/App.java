package com.sigom;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CommonUtils util = new CommonStringUtil();
        //util.findSecondNotRepeatedOrderedCharOfString("xxpmwddkaxx");
        List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
        util.printRepeatedWordInListOfString(words);

        util.camelCaseSplit("SomeString");
        util.camelCaseSplit("SomeString1");
        util.camelCaseSplit("someString");


//       for(int i = 1; i < 41 ; i++ ){
//           if (util.isPrime(i)){
//               System.out.println(i);
//           }
//       }

    }
}
