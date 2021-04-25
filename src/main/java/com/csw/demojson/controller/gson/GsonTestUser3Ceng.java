package com.csw.demojson.controller.gson;


import com.csw.demojson.entity.User;
import com.csw.demojson.fengZhuang.User3Ceng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonTestUser3Ceng {
    public static void main(String[] args) {
        //要求，如下输入格式
        // String json = "{ 'a':[{'b':'c'},{ 'd':'e' } ] , 'a1': [ { 'b1': 'c1' } , { 'd1': 'e1' } ] }";
        Map<String, List> mapList = User3Ceng.getMapUser3Ceng();
        String json = new Gson().toJson(mapList);
        System.out.println(json);//{"list1":[{"name":"小明"},{"name":"小白"}],"list2":[{"name":"小黄"},{"name":"小蓝"}]}

        String input20 = "list2[0].name";//传一个参数，找出值是多少。
        String obj20 = findObj(json, input20);
        System.out.println(input20 + "的值是" + obj20);//list2[0].name的值是小黄
        //
        String input21 = "list2[1].name";//传一个参数，找出值是多少。
        String obj21 = findObj(json, input21);
        System.out.println(input21 + "的值是" + obj21);//list2[1].name的值是小蓝
        //
        String input10 = "list1[0].name";//传一个参数，找出值是多少。
        String obj10 = findObj(json, input10);
        System.out.println(input10 + "的值是" + obj10);//list1[0].name的值是小明
        //
        String input11 = "list1[1].name";//传一个参数，找出值是多少。
        String obj11 = findObj(json, input11);
        System.out.println(input11 + "的值是" + obj11);//list1[1].name的值是小白

    }


    public static String findObj(String json, String input) {
        Gson gson = new Gson();
        Map listMap = gson.fromJson(json, Map.class);
        int preIndex = input.indexOf("[");
        int lastIndex = input.indexOf("]");
        String pre = input.substring(0, preIndex);
        String middle = input.substring(preIndex + 1, lastIndex);
        String last = input.substring(lastIndex + 1);
        char c = last.charAt(0);
        int middleInt = Integer.parseInt(middle);
        ///////////////////////////////////////////////////
        Object listMaoGet = listMap.get(pre);
        List<User> list = gson.fromJson(gson.toJson(listMaoGet), new TypeToken<List<User>>(){}.getType());
        if (last.equals(".name")) {
            return list.get(middleInt).getName();
        }
        return null;

    }
}
