package com.csw.demojson.controller.gson;

import com.csw.demojson.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonDemo {
    public static void main(String[] args) {
        //总结Gson gson = new Gson();
        //map对象,list对象,或实体对象转JSONString    //gson.toJson(对象)
        //JSONString转map    //gson.fromJson(jsonMap, Map.class);
        //JSONString转实体对象  //gson.fromJson(JSONString, 对象.class)
        //JSONString转list<实体对象>  //gson.fromJson(JSONString, new TypeToken<List<对象>>() {}.getType());
        ////当里面是Object或其他类型的时候还是用gson.fromJson(gson.toJson(o1), (Type) Object.class)
        //JSONArray和JSONObject先转换成JSONString，再按照上面方法转，记住JSONString是中转

        //创建学生
        User user1 = new User("小明");
        User user2 = new User("小白");
        List<User> userList = new ArrayList<>();
        Map<String, String> maps = new HashMap<>();
        maps.put("name1", "妲己");
        maps.put("name2", "甄姬");
        maps.put("name3", "小乔");
        userList.add(user1);
        userList.add(user2);

        //测试javaBean转json
        Gson gson = new Gson();
        String jsonBean = gson.toJson(user1);
        System.out.println("javaBean转json：" + jsonBean);
        //测试json转javaBean
        User user3 = gson.fromJson(jsonBean, User.class);
        System.out.println("json转javaBean：" + user3);
        System.out.println("-----------------------------------------------------------------");

        //List集合转为Json字符串
        String jsonList = gson.toJson(userList);
        System.out.println("List集合转为Json字符串：" + jsonList);
        //Json字符串转为List集合
        List<User> userList1 = gson.fromJson(jsonList, new TypeToken<List<User>>() {
        }.getType());
        System.out.println("Json字符串转为List集合：" + userList1);
        System.out.println("-----------------------------------------------------------------");


        //Map转为Json字符串
        String jsonMap = gson.toJson(maps);
        System.out.println("Map转为Json字符串：" + jsonMap);
        //Json字符串转为Map
        Map maps1 = gson.fromJson(jsonMap, Map.class);
        System.out.println("Json字符串转为Map：" + maps1);

    }
}
