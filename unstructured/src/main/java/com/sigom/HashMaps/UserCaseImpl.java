package com.sigom.HashMaps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class UserCaseImpl implements HashMapUserCase{
    @Override
    public Map<Object, Object> sortMapByValue(Map<String, Integer> map) {
        Map<Object,Object> result = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));
        return result;
    }
}
