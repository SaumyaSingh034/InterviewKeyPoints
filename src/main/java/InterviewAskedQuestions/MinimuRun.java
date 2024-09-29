package InterviewAskedQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimuRun {
    public static void main(String[] args){
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Rohit", 30);
        data.put("Virat", 28);
        data.put("Jadega", 25);
        data.put("Rishabh", 98);
        data.put("Shubham", 38);
        Map.Entry<String, Integer> min = null;

        for(Map.Entry<String, Integer> run : data.entrySet()){
            if(min==null || run.getValue() < min.getValue()){
                    min = run;
            }
        }
        System.out.println(min.getKey()+" ---> "+min.getValue());
        int mini = Collections.min(data.values());
        System.out.println(mini);
        int max = Collections.max(data.values());
        System.out.println(max);
    }


}
