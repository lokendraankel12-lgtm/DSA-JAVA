import java.util.*;
class Main {
    public static int buyandsellstock(int prize[]){
        int buyprize=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0; i<prize.length; i++){
            if (buyprize<prize[i]){
                int profit= prize[i]-buyprize;
                maxprofit=Math.max(maxprofit,profit);
            }else{
                buyprize=prize[i];
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
       int prize[]={7,1,5,3,6,4};
      System.out.println( buyandsellstock( prize));
    }
}
