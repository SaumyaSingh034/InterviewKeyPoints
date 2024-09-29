package InterviewAskedQuestions;

import javax.print.DocFlavor;

public class Vowels {

    public static void main(String[] args){
        String str = "helloSaumya";
        String processedString = str.replaceAll("[aeiouAEIOU]","");

        if(processedString.length()>5){
            System.out.println("Success");
        }
        else{
            System.out.println("Length of String is less than 5");
        }

        if(processedString.length() == str.length()){
            System.out.println("False: the string donot have any vowels");
        }
        else{
            System.out.println("The String contains vowels");
        }
    }
}
