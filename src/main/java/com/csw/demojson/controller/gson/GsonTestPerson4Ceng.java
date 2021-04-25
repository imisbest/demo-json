package com.csw.demojson.controller.gson;


import com.csw.demojson.entity.Person;
import com.csw.demojson.fengZhuang.Person4Ceng;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonTestPerson4Ceng {
    public static void main(String[] args) {
        //要求，如下输入格式
        // String json = "{ 'a':[{'b':'c'},{ 'd':'e' } ] , 'a1': [ { 'b1': 'c1' } , { 'd1': 'e1' } ] }";
        Map<String, List> mapList = Person4Ceng.getMapPerson4Ceng();
        String json = new Gson().toJson(mapList);//map->list-map-person
        System.out.println("JSON]" + json);
        findObj(json);

    }


    public static void findObj(String json) {
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        for (Object aa : map.keySet()) {
            Object o1 = map.get(aa);//一层结束
            List<Object> list = gson.fromJson(gson.toJson(o1), (Type) Object.class);
            for (Object mapPerson : list) {//两层结束
                Map mapNei = gson.fromJson(gson.toJson(mapPerson), Map.class);
                for (Object bb : mapNei.keySet()) {
                    Object o2 = mapNei.get(bb);//三层结束
                    Person person = gson.fromJson(gson.toJson(o2), Person.class);
                    System.out.println("名字" + person.getName() + ",年龄" + person.getAge());//四层获取
                }
            }
        }

    }
}
