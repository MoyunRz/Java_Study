package com.arrayList;

import java.util.*;

/**
 * @author RZ
 * @date 2020/6/22 21:38
 */
public class ArrayListTest {

    public static void main(String[] args) {
        Random rm = new Random();
        List<Map<String ,Object>> listmap = new ArrayList<>();
        for (int i=1; i<=10; i++){
            Map<String, Object> map = new HashMap<>();
            map.put("index", rm.nextInt(100) + 1);
            listmap.add(map);
        }

        Collections.sort(listmap, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer index1 = Integer.valueOf(o1.get("index").toString()) ;
                Integer index2 = Integer.valueOf(o2.get("index").toString()) ;
                return index1.compareTo(index2);
            }
        });

        for (Map<String, Object> map : listmap) {
            System.out.println("index->"+map.get("index"));
        }
    }
}
