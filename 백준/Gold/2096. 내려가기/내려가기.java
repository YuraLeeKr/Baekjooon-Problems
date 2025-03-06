import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 첫 번째 줄의 세 개 숫자 입력받기
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        // maxDP와 minDP 배열 초기화
        int[] maxDP = arr.clone(); // maxDP = arr
        int[] minDP = arr.clone(); // minDP = arr

        // N-1개의 줄을 처리
        for (int i = 1; i < N; i++) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            // maxDP 업데이트
            int max0 = arr[0] + Math.max(maxDP[0], maxDP[1]);
            int max1 = arr[1] + Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]);
            int max2 = arr[2] + Math.max(maxDP[1], maxDP[2]);
            maxDP[0] = max0;
            maxDP[1] = max1;
            maxDP[2] = max2;

            // minDP 업데이트
            int min0 = arr[0] + Math.min(minDP[0], minDP[1]);
            int min1 = arr[1] + Math.min(Math.min(minDP[0], minDP[1]), minDP[2]);
            int min2 = arr[2] + Math.min(minDP[1], minDP[2]);
            minDP[0] = min0;
            minDP[1] = min1;
            minDP[2] = min2;
        }

        // 결과 출력
        System.out.println(Math.max(Math.max(maxDP[0], maxDP[1]), maxDP[2]) + " " +
                Math.min(Math.min(minDP[0], minDP[1]), minDP[2]));

        sc.close();
    }
}
