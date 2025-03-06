import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int n = decrese_arr(k, sc);
        System.out.println(n);
    }

    public static int decrese_arr(int k, Scanner sc){
        if(k == 0) return 0;

        int[] arr = new int[k];
        int[] dp = new int[k];

        for(int i=0; i<k; i++){
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for(int i=1; i<k; i++){
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int m = Arrays.stream(dp).max().getAsInt();
        return m;
    }
}