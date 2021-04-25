package com.csw.demojson.controller;

import com.alibaba.fastjson.JSON;
import com.csw.demojson.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSON_GeShi {
    public static void main(String[] args) {
        //总结
        //实体类json格式
        //{"age":11,"name":"Java"}

        //字符串型map json格式
        //{"sex":"男","name":"张三","age":"20"}
        //对象型map json格式
        //{"person3":{"age":33,"name":"Python"},"person2":{"age":22,"name":"C++"},"person1":{"age":11,"name":"Java"}}

        //整型list json格式
        // [1,2,3]
        //字符串类型list json格式
        // ["张三","李四","王五"]
        //对象类型list json格式
        // [{"age":11,"name":"Java"},{"age":22,"name":"C++"},{"age":33,"name":"Python"}]
        //map型list json格式
        // [{"person3":{"age":33,"name":"Python"},"person2":{"age":22,"name":"C++"},"person1":{"age":11,"name":"Java"}}]

        //实体类
        Person person1 = new Person("Java", 11);
        Person person2 = new Person("C++", 22);
        Person person3 = new Person("Python", 33);
        System.out.println("实体类文本格式： " + person1);
        String PersonJson = JSON.toJSONString(person1);//alt+enter
        System.out.println("实体类json格式】： " + PersonJson);//{"age":11,"name":"Java"}
        System.out.println("-----------------------------------");

        //字符串型map
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("name", "张三");
        stringMap.put("age", "20");
        stringMap.put("sex", "男");
        System.out.println("字符串型map文本格式： " + stringMap);
        String stringMapJson = JSON.toJSONString(stringMap);
        System.out.println("字符串型map json格式：】 " + stringMapJson);//{"sex":"男","name":"张三","age":"20"}
        System.out.println("-----------------------------------");
        //对象型map
        Map<String, Object> PersonMap = new HashMap<>();
        PersonMap.put("person1", person1);
        PersonMap.put("person2", person2);
        PersonMap.put("person3", person3);
        System.out.println("对象型map文本格式： " + PersonMap);
        String personMapJson = JSON.toJSONString(PersonMap);
        System.out.println("对象型map json格式：】 " + personMapJson);
        // {"person3":{"age":33,"name":"Python"},"person2":{"age":22,"name":"C++"},"person1":{"age":11,"name":"Java"}}
        System.out.println("-----------------------------------");

        //整型list
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println("整型list文本格式： " + integerList);
        String integerListJson = JSON.toJSONString(integerList);
        System.out.println("整型list json格式】： " + integerListJson);//[1,2,3]
        System.out.println("-----------------------------------");
        //字符串类型list
        List<String> stringList = new ArrayList<>();
        stringList.add("张三");
        stringList.add("李四");
        stringList.add("王五");
        System.out.println("字符串类型list文本格式： " + stringList);
        String stringListJson = JSON.toJSONString(stringList);
        System.out.println("字符串类型list json格式：】" + stringListJson);//["张三","李四","王五"]
        System.out.println("-----------------------------------");
        //对象类型list
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        System.out.println("对象类型list文本格式： " + personList);
        String personListJson = JSON.toJSONString(personList);
        System.out.println("对象类型list json格式：】 " + personListJson);
        //[{"age":11,"name":"Java"},{"age":22,"name":"C++"},{"age":33,"name":"Python"}]
        System.out.println("-----------------------------------");
        //map型list
        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(PersonMap);
        System.out.println("map型list文本格式： " + mapList);
        String mapListJson = JSON.toJSONString(mapList);
        System.out.println("map型list json格式：】 " + mapListJson);
        // [{"person3":{"age":33,"name":"Python"},"person2":{"age":22,"name":"C++"},"person1":{"age":11,"name":"Java"}}]
        System.out.println("-----------------------------------");
    }
}
