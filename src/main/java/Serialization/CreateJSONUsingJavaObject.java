package Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.google.gson.Gson;

public class CreateJSONUsingJavaObject {
    public static void main(String[] args) throws JsonProcessingException {
        TestSerialization ts = new TestSerialization();
        ts.setName("Saumya");
        ts.setAge(29);

        //Using Gson

        Gson gs = new Gson();
        String data = gs.toJson(ts);
        System.out.println(data);

        TestSerialization response = gs.fromJson(data, TestSerialization.class);
        System.out.println(response.getName());


        //Using Jackson
        ObjectMapper  obj = new ObjectMapper();
        String data1 = obj.writeValueAsString(ts);
        System.out.println(data1);
        TestSerialization responseJac = obj.readValue(data1, TestSerialization.class);
        System.out.println(responseJac.getName());




    }
}
