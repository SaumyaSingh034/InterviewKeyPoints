package InterviewPrep;

import java.util.ArrayList;
import java.util.List;

public class ReplaceElementinArray {
    public static void main(String[] args){


        List<String> data = new ArrayList<>();
        data.add("Test1");
        data.add("Test2");
        data.add("Test3");
        data.add("Test4");
        data.add("Test5");

        System.out.println("Before Replacing : "+data);
        int index = data.indexOf("Test2");
        data.add(index, "ReplacedTest");
        System.out.println("After Replacing : "+data);

    }
}
