package InterviewPrep;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateWords {
    public static void main(String[] args){
        String str = "I love love love Java Java Programming ";
        String[] words  = str.split(" ");
        Map<String, Integer> hashMap = new HashMap<>();
        for(String word : words){
            if(hashMap.containsKey(word)){
                hashMap.put(word,hashMap.get(word)+1);
            }else{
                hashMap.put(word,1);
                System.out.print(word+" ");

            }
        }

    }
}
