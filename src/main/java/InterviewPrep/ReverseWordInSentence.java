package InterviewPrep;

public class ReverseWordInSentence {
    public static void main(String[] args){
        String str = "I am a Java Tester";
        StringBuffer reverse = new StringBuffer();
        String[] words = str.split(" ");
        for(String word : words){
            StringBuffer sb = new StringBuffer(word);
            reverse.append(sb.reverse().append(" "));
        }
        System.out.println(reverse);



    }
}
