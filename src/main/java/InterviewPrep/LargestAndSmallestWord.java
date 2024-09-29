package InterviewPrep;

public class LargestAndSmallestWord {

    public static void main(String[] args){
        String str = "Rahul Shetty is a greater teacher";
        String[] words = str.split(" ");
        String shortest = words[0];
        String largest = words[0];
        for(String word : words){
            if(shortest.length()>word.length() ) {
                shortest = word;
            }
            if(largest.length() < word.length())
                largest = word;
        }
        System.out.println("ShortestWord : "+shortest+" Largest Word : "+largest);
    }
}
