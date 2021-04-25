package com.csw.demojson.fengZhuang;

import com.csw.demojson.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User3Ceng {
    public static Map<String, List> getMapUser3Ceng() {
        User user1 = new User("小明");
        User user2 = new User("小白");
        User user3 = new User("小黄");
        User user4 = new User("小蓝");
        List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        List<User> list2 = new ArrayList<>();
        list2.add(user3);
        list2.add(user4);
        Map<String, List> mapList = new HashMap<>();
        mapList.put("list1", list1);
        mapList.put("list2", list2);
        return mapList;
    }
}
