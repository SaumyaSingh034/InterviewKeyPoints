package InterviewPrep;

public class SecondLargestElement {
    public static void main(String[] args){
        int[] arr = {2,3,1,6,9,9};
        int secondLargest = arr[0];
        int largest = arr[0];
        for(int i=0;i< arr.length;i++){
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i]!= largest) {
                secondLargest = arr[i];
                
            }
        }
        System.out.println(largest+" ----------------- "+secondLargest);

        int sc = 0;
        int l = 0;
        int[] arr1 = {2,3,1,6,9,9};
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] > l){
                sc = l;
                l = arr1[i];
            }
        }
        System.out.println(sc+"   "+l);
    }
}
