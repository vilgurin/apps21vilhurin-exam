//package domain;
//
//import json.*;
//
//import java.util.HashMap;
//
///**
// * Created by Andrii_Rodionov on 1/3/2017.
// */
//public class Student extends BasicStudent {
//
//    HashMap<String, Json> student = new HashMap<>();
//
//    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
//
//        student.put("name", new JsonString(name));
//        student.put("surname", new JsonString(surname));
//        student.put("year", new JsonNumber(year));
//
//        for (int i = 0; i < exams.length;i++){
//
//        }
//
//    }
//
//    @Override
//    public JsonObject toJsonObject() {
//        // ToDo
//        return null;
//    }
//}