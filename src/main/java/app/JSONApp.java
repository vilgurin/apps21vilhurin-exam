package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        JsonObject jsonObject = null;

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));

        Json jYear = new JsonNumber(2);
        JsonPair year = new JsonPair("year", jYear);

        JsonPair courseOOP = new JsonPair("course",new JsonString("OOP"));
        JsonPair markOOP = new JsonPair("mark",new JsonNumber(3));
        JsonPair passedOOP = new JsonPair("passed",new JsonBoolean(true));

        JsonObject oopFinal = new JsonObject(courseOOP,markOOP,passedOOP);

        JsonPair courseEnglish = new JsonPair("course",new JsonString("English"));
        JsonPair markEnglish = new JsonPair("mark",new JsonNumber(5));
        JsonPair passedEnglish = new JsonPair("passed",new JsonBoolean(true));

        JsonObject englishFinal = new JsonObject(courseEnglish,markEnglish,passedEnglish);

        JsonPair courseMath = new JsonPair("course",new JsonString("Math"));
        JsonPair markMath = new JsonPair("mark",new JsonNumber(2));
        JsonPair passedMath = new JsonPair("passed",new JsonBoolean(false));

        JsonObject mathFinal = new JsonObject(courseMath,markMath,passedMath);

        JsonPair exams = new JsonPair("exams",new JsonArray(oopFinal,englishFinal,mathFinal));


//        JsonObject jsonObject = new JsonObject()
        return new JsonObject(name,surname,year,exams);
    }
}
