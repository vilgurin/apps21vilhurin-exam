package json;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String,Json> hash_map = new HashMap<>();

    public JsonObject(JsonPair... jsonPairs) {

        for (int i = 0; i<jsonPairs.length;i++){
            hash_map.put(jsonPairs[i].key,jsonPairs[i].value);
        }
    }

    @Override
    public String toJson() {
        String result = "{";
        int lenCounter = 0;
        if (hash_map.size() == 0){
        return "{}";
        }

        for (String name: hash_map.keySet()){
            if (lenCounter == hash_map.size()-1){

                result += "'"+name+"'" + ": "+hash_map.get(name).toJson()+"}";
                break;
            }
            result +=  "'"+name+"'" + ":"+hash_map.get(name).toJson()+", ";
            lenCounter += 1;
        }
        return result;
    }

    public void add(JsonPair jsonPair) {
        hash_map.put(jsonPair.key,jsonPair.value);
    }

    public Json find(String name) {
       return hash_map.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject jsonObj = new JsonObject();
        for (int i = 0; i < names.length;i++){
            if (hash_map.containsKey(names[i])){
                jsonObj.add(new JsonPair(names[i],hash_map.get(names[i])));
            }
        }
        return jsonObj;
    }

    public static void main(String[] args) {
        JsonObject jo = new JsonObject();
//        JsonPair jsonPair = new JsonPair("surname", new JsonString("Nik"));
        String expectedJSON = "{}";
//        jo.add(jsonPair);
        System.out.println(jo.toJson());
    }
}
