import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int k = sc.nextInt();
            long result = MaxStocks(k, sc);
            System.out.println(result);
        }


    }

    public static long MaxStocks(int k, Scanner sc){
        int[] stocks = new int[k];

        for(int i=0; i<k; i++){
            stocks[i] = sc.nextInt();
        }

        int Max = 0;
        long sum = 0;
        for(int i=k-1; i>=0; i--){
            if(stocks[i] > Max) Max = stocks[i];
            else sum +=(long)Max - stocks[i];
        }

        return sum;
    }

}