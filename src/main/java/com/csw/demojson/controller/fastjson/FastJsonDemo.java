package com.csw.demojson.controller.fastjson;

import com.alibaba.fastjson.JSON;
import com.csw.demojson.entity.Person;

import java.util.List;
import java.util.Map;

public class FastJsonDemo {
    public static void main(String[] args) {

        //总结
        //map对象,list对象,或实体对象转JSONString    //JSON.toJSONString(对象)
        //JSONString转map    //JSON.parseObject(JSONString, Map.class)
        //JSONString转实体对象  //JSON.parseObject(JSONString, 对象.class)
        //JSONString转list<实体对象>  //JSON.parseArray(JSONString, 对象.class),
        // //当里面是Object的时候还是用JSON.parseObject(JSON.toJSONString(o1), (Type) Object.class)
        //map转对象或者是对象转map先转换成JSONString，再按照上面方法转
        // 扩展
        //JSONArray和JSONObject先转换成JSONString，再按照上面方法转，记住JSONString是中转

        //json字符串转map
        System.out.println("json字符串转map对象");
        String s = "{'age':11,'name':'Java'}";
        Map map = JSON.parseObject(s, Map.class);
        System.out.println("【从map中获取name值】" + map.get("name"));
        //map转json字符串
        System.out.println("【map转json字符串】" + JSON.toJSONString(map));
        System.out.println("///////////////////////////////////////////////");

        //json字符串转对象
        System.out.println("json字符串转对象");
        String s1 = "{name:'aaa',age:11}";
        Person person = JSON.parseObject(s1, Person.class);
        System.out.println("【从对象中获取name值】" + person.getName());
        //对象转json字符串
        System.out.println("【对象转json字符串】" + JSON.toJSONString(person));
        System.out.println("///////////////////////////////////////////////");

        //json字符串转list
        System.out.println("json字符串转list");
        String ss = "[{name:'aaa',age:11},{name:'bbb',age:22}]";
        List<Person> personList = JSON.parseArray(ss, Person.class);
        System.out.println("【获取第一个人的姓名】" + personList.get(0).getName());
        //list转json字符串
        System.out.println("【list转json字符串】" + JSON.toJSONString(personList));
        System.out.println("///////////////////////////////////////////////");

        //map转对象
        System.out.println("map转对象");
        Person person1 = JSON.parseObject(JSON.toJSONString(map), Person.class);
        System.out.println("【从对象中获取name值】" + person1.getName());
        //对象转map
        System.out.println("对象转map");
        Map map1 = JSON.parseObject(JSON.toJSONString(person1), Map.class);
        System.out.println("【从map中获取name值】" + map1.get("name"));


    }
}


