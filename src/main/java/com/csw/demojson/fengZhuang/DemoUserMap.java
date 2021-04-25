package com.csw.demojson.fengZhuang;

import com.csw.demojson.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoUserMap {
    private static void jsonDemoUserMap() {
        User user1 = new User("小明");
        User user2 = new User("小白");
        List<User> userList = new ArrayList<>();
        Map<String, String> maps = new HashMap<>();
        maps.put("name1", "妲己");
        maps.put("name2", "甄姬");
        maps.put("name3", "小乔");
        userList.add(user1);
        userList.add(user2);
    }
}
