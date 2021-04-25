package com.csw.demojson.controller.fastjson;

import com.alibaba.fastjson.JSON;
import com.csw.demojson.entity.Person;
import com.csw.demojson.fengZhuang.Person4Ceng;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class FastJSONTestPerson4Ceng {
    public static void main(String[] args) {
        //要求，如下输入格式
        // String json = "{ 'a':[{'b':'c'},{ 'd':'e' } ] , 'a1': [ { 'b1': 'c1' } , { 'd1': 'e1' } ] }";
        Map<String, List> mapList = Person4Ceng.getMapPerson4Ceng();
        String json = JSON.toJSONString(mapList);//map->list-map-person
        //{"list1":[{"person2":{"age":22,"name":"小白"},"person1":{"age":11,"name":"小明"}},
        // {"person4":{"age":44,"name":"小蓝"},"person3":{"age":33,"name":"小黄"}}],
        // "list2":[{"person20":{"age":220,"name":"小白0"},"person10":{"age":110,"name":"小明0"}},
        // {"person30":{"age":330,"name":"小黄0"},"person40":{"age":440,"name":"小蓝0"}}]}
        System.out.println("JSON]" + json);
//        String input = "list1[1].person1.name";//传一个参数，找出值是多少。
//        String input2 = "list2[0].person20.age";//传一个参数，找出值是多少。
        findObj(json);
//        ArrayList<String> index = new ArrayList<>();
//        index.add(input);
//        index.add(input2);
        // String obj = findObj(json, index);
        //System.out.println(input + "的值是" + obj);
        //String obj2 = findObj(json, input2);
        //System.out.println(input2 + "的值是" + obj2);

    }

    public static void findObj(String json) {
        Map map = JSON.parseObject(json);
        for (Object aa : map.keySet()) {
            Object o1 = map.get(aa);//一层结束
            List<Object> list = JSON.parseObject(JSON.toJSONString(o1), (Type) Object.class);
            for (Object mapPerson : list) {//两层结束
                Map mapNei = JSON.parseObject(JSON.toJSONString(mapPerson));
                for (Object bb : mapNei.keySet()) {
                    Object o2 = mapNei.get(bb);//三层结束
                    Person person = JSON.parseObject(JSON.toJSONString(o2), Person.class);
                    System.out.println("名字" + person.getName() + ",年龄" + person.getAge());//四层获取
                }
            }
        }

    }
}
