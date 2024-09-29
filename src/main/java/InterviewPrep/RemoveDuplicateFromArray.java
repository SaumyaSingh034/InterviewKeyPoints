package InterviewPrep;

import java.util.*;

public class RemoveDuplicateFromArray {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);  // Removes duplicates

        list.clear();  // Clear the list to add unique values
        list.addAll(uniqueSet);

        System.out.println(list);  // Output: [1, 2, 3, 4, 5]


    }
}
