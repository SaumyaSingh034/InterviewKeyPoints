package InterviewPrep;

import java.util.Arrays;

public class AnagramString {
    public static void main(String[] args){
        String str1  = "Mother In Law";
        String str2 = "Hitler Woman";
        boolean status;
        String s1 = str1.replaceAll("\\s","");
        String s2 = str1.replaceAll("\\s","");
        if(s1.length()!=s2.length()){
            status = false;
        }else{
            char[] ch1 = s1.toLowerCase().toCharArray();
            char[] ch2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            status = Arrays.equals(ch1, ch2);
            if(status)
                System.out.println("Anangram Strings");
            else
                System.out.println("Not Anangram Strings");
        }


    }
}
