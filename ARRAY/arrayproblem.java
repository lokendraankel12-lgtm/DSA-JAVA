package ARRAY;
public class arrayproblem{
    // problem one is :Sum of Array
public static int sumofarray(int arr[]){
    int sum=0;
    for(int i=0; i<arr.length; i++){
        sum=sum+arr[i];
    }
    return sum;

}
    

public static void main (String args[]){
    int arr[]={1,3,2,2};
    System.out.println(sumofarray(arr));

   
}
}