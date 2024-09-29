package InterviewPrep;

public class PrintSumOfNumbers {
    public static void main(String[] args){
        int number = 123;
        int sum = 0;
        int n;
        while(number!=0){
            n = number %10;
            sum += n;
            number = number/10;

        }
        System.out.println(sum);
    }
}
