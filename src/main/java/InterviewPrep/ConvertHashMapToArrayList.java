package InterviewPrep;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertHashMapToArrayList {
    public static void main(String[] args){
        HashMap<String, String> hash_map = new HashMap<>();

        hash_map.put("India", "New Delhi");
        hash_map.put("France", "Paris");
        hash_map.put("Germany", "Berlin");
        hash_map.put("Australia", "Canberra");

        List<String> arrCountry = new ArrayList<>(hash_map.keySet());
        for(String country : arrCountry){
            System.out.println(country);
        }
        List<String> arrStates = new ArrayList<>(hash_map.values());
        for(String state : arrStates){
            System.out.println(state);
        }

    }
}
