package com.csw.demojson.controller.jackson;

import com.csw.demojson.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        //总结 ObjectMapper mapper = new ObjectMapper();
        //map对象,list对象,或实体对象转JSONString    //mapper.writeValueAsString(对象);
        //JSONString转map    //mapper.readValue(jsonString, Map.class);
        //JSONString转实体对象  //mapper.readValue(jsonString, 对象.class);
        //JSONString转list<实体对象>
        //CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, 对象.class);
        //  List<对象> listJson = mapper.readValue(jsonString, listType);
        ////当里面是Object或其他类型的时候，对象换成object
        //JSONArray和JSONObject先转换成JSONString，再按照上面方法转，记住JSONString是中转

        User user1 = new User("小明");
        User user2 = new User("小白");
        List<User> userList = new ArrayList<>();
        Map<String, String> maps = new HashMap<>();
        maps.put("name1", "妲己");
        maps.put("name2", "甄姬");
        maps.put("name3", "小乔");
        userList.add(user1);
        userList.add(user2);

        // 首先万年不变的是new一个对象
        ObjectMapper mapper = new ObjectMapper();

        //Map转json字符串
        String jsonMap=mapper.writeValueAsString(maps);
        System.out.println("Map转json字符串" + jsonMap);
        // json字符串转Map
        Map mapJson = mapper.readValue(jsonMap, Map.class);
        System.out.println("json字符串转Map"+mapJson);
        System.out.println("/////////////////////////////////////////////////");

        //list转json字符串
        String jsonList=  mapper.writeValueAsString(userList);
        System.out.println("数组list转json字符串" + jsonList);
        //json字符串转对象数组List
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
        List<User> listJson = mapper.readValue(jsonList, listType);
        System.out.println("json字符串转对象数组List" + listJson);
        System.out.println("/////////////////////////////////////////////////");

        //对象转json字符串
        String jsonBean=mapper.writeValueAsString(user1);
        System.out.println("对象转json字符串" + jsonBean);
        //Json字符串转对象
        User userJson = mapper.readValue(jsonBean, User.class);
        System.out.println("Json字符串转对象" + userJson);




    }


}
