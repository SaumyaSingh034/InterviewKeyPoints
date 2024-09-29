package InterviewPrep;

import java.util.HashMap;
import java.util.Map;

public class CountOccurenceOfEachCharacter {

    public static void main(String[] args){
        Map<Character, Integer> hashmap = new HashMap<>();
        String str = "Hello World";
        char[] ch = str.replaceAll("\\s","").toCharArray();
        for(int i=0;i<ch.length;i++){
            if(hashmap.containsKey(ch[i])){
                hashmap.put(ch[i],hashmap.get(ch[i])+1);
            }else{
                hashmap.put(ch[i],1);
            }
        }

        for(Map.Entry entry : hashmap.entrySet()){
            System.out.println(entry.getKey()+" -----> "+entry.getValue());
        }
    }
}
