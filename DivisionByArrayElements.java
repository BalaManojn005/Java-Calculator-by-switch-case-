import java.util.*;
public class Main{
    public static void main(String args[]){
        int arr[]={10,11,15,0,5};
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter any Number:");
        int a=sc.nextInt();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                throw new ArithmeticException();
            }
            else{
                System.out.println(a/arr[i]);
            }
        }
    }
}
