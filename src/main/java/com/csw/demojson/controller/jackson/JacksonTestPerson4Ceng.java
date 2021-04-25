package com.csw.demojson.controller.jackson;


import com.csw.demojson.entity.Person;
import com.csw.demojson.fengZhuang.Person4Ceng;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JacksonTestPerson4Ceng {
    public static void main(String[] args) throws JsonProcessingException {
        //要求，如下输入格式
        // String json = "{ 'a':[{'b':'c'},{ 'd':'e' } ] , 'a1': [ { 'b1': 'c1' } , { 'd1': 'e1' } ] }";
        Map<String, List> mapList = Person4Ceng.getMapPerson4Ceng();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(mapList);//map->list-map-person
        System.out.println("JSON]" + json);
        findObj(json);

    }


    public static void findObj(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(json, Map.class);
        for (Object aa : map.keySet()) {
            Object o1 = map.get(aa);//一层结束
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Object.class);
            List<Object> list = mapper.readValue(mapper.writeValueAsString(o1), listType);
            for (Object mapPerson : list) {//两层结束
                Map mapNei = mapper.readValue(mapper.writeValueAsString(mapPerson), Map.class);
                for (Object bb : mapNei.keySet()) {
                    Object o2 = mapNei.get(bb);//三层结束
                    Person person = mapper.readValue(mapper.writeValueAsString(o2), Person.class);
                    System.out.println("名字" + person.getName() + ",年龄" + person.getAge());//四层获取
                }
            }
        }

    }
}
