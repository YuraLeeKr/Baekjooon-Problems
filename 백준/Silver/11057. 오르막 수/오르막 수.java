import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        final int MOD = 10007;
        int[][] dp = new int[N + 1][10]; // dp[n][d]를 길이가 n이고 마지막 숫자가 d인 오르막 수의 개수

        // 길이가 1일 때 0~9까지는 각각 한 개의 오르막 수
        for (int d = 0; d < 10; d++) {
            dp[1][d] = 1;
        }

        // 길이가 n−1인 오르막 수 중에서 마지막 숫자가 0부터 d까지인 경우를 더함
        // dp[n][d] = dp[n-1][d] + dp[n][d-1]
        for (int n = 2; n <= N; n++) {
            for (int d = 0; d < 10; d++) {
                if (d == 0) {
                    dp[n][d] = dp[n - 1][d]; // 0으로 끝나는 경우는 이전 길이에서도 0으로 끝나는 경우뿐
                } else {
                    dp[n][d] = (dp[n][d - 1] + dp[n - 1][d]) % MOD;
                }
            }
        }

        // 길이가 N인 오르막 수 개수 합산
        int result = 0;
        for (int d = 0; d < 10; d++) {
            result = (result + dp[N][d]) % MOD;
        }

        System.out.println(result);
    }
}
