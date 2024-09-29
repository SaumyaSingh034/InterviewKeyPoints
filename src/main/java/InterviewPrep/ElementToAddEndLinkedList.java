package InterviewPrep;

import java.util.LinkedList;

public class ElementToAddEndLinkedList {

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        list.offerLast("LastTest");
        list.offerFirst("FirstTest");
        System.out.println(list);
    }
}
