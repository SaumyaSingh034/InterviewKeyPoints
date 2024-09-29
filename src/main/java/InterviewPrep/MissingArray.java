package InterviewPrep;

public class MissingArray {

    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
        int sum1 =0 , sum2=0;
        for(int i=0;i< arr.length;i++){
            sum1 += arr[i];
        }
        for(int i=1;i<=10;i++){
            sum2 += i;
        }
        System.out.println(sum1+ "----------- "+sum2);
        System.out.println("Missing Number : "+(sum2-sum1));

    }
}
