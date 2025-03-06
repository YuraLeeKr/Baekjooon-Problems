import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // dp 배열 크기 N + 1 (0부터 N까지)
        int[] dp = new int[N + 1];
        
        // dp[0]을 1로 설정 (기본 초기값)
        dp[0] = 1;
        
        // 첫 번째 칸과 두 번째 칸은 미리 값 초기화
        if (N == 1) {
            System.out.println(3);
            return;
        }

        dp[1] = 3;
        dp[2] = 7;

        // dp[i]를 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901;
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}
