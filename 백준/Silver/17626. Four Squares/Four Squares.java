import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1]; //dp[i]: i를 만들기 위한 최소 제곱수의 개수
        for(int i=0; i<=n; i++){
            dp[i] = i; // 최악의 경우
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}