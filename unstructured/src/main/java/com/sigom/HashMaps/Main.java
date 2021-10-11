package com.sigom.HashMaps;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        HashMapUserCase client = new UserCaseImpl();

        Map<String, Integer> score = new HashMap<>();
        score.put("ALIANZA", 17);
        score.put("UNIVERSITARIO", 24);
        score.put("CINCIANO", 5);
        score.put("BINACIONAL", 12);
        score.put("UTC", 17);

        Map<Object,Object> finalScore = client.sortMapByValue(score);
        System.out.println(finalScore.keySet().iterator().next().toString());

    }
}
