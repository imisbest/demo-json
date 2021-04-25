package com.csw.demojson.fengZhuang;

import com.csw.demojson.entity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person4Ceng {
    public static Map<String, List> getMapPerson4Ceng() {
        Person person1 = new Person("小明", 11);
        Person person2 = new Person("小白", 22);
        Person person3 = new Person("小黄", 33);
        Person person4 = new Person("小蓝", 44);
        Person person10 = new Person("小明0", 110);
        Person person20 = new Person("小白0", 220);
        Person person30 = new Person("小黄0", 330);
        Person person40 = new Person("小蓝0", 440);
        Map<String, Person> map1 = new HashMap<>();
        map1.put("person1", person1);
        map1.put("person2", person2);
        Map<String, Person> map2 = new HashMap<>();
        map2.put("person3", person3);
        map2.put("person4", person4);
        Map<String, Person> map10 = new HashMap<>();
        map10.put("person10", person10);
        map10.put("person20", person20);
        Map<String, Person> map20 = new HashMap<>();
        map20.put("person30", person30);
        map20.put("person40", person40);
        List<Map<String, Person>> list1 = new ArrayList<>();
        list1.add(map1);
        list1.add(map2);
        List<Map<String, Person>> list10 = new ArrayList<>();
        list10.add(map10);
        list10.add(map20);

        Map<String, List> mapList = new HashMap<>();
        mapList.put("list1", list1);
        mapList.put("list2", list10);
        return mapList;
    }
}
