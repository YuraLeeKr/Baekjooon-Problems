import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][M];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = 0;

        // 땅 높이 입력 및 최소/최대 높이 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, land[i][j]);
                maxHeight = Math.max(maxHeight, land[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int bestHeight = 0;

        // 가능한 모든 높이에 대해 탐색 (최소 높이 ~ 최대 높이)
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int removeBlocks = 0;
            int addBlocks = 0;

            // 현재 높이 targetHeight로 맞추는 데 필요한 블록 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - targetHeight;
                    if (diff > 0) {
                        removeBlocks += diff; // 블록 제거
                    } else {
                        addBlocks -= diff; // 블록 추가
                    }
                }
            }

            // 인벤토리 블록 확인
            if (removeBlocks + B >= addBlocks) {
                int time = (removeBlocks * 2) + addBlocks;

                // 최소 시간을 찾되, 동일하면 더 높은 높이 선택
                if (time < minTime || (time == minTime && targetHeight > bestHeight)) {
                    minTime = time;
                    bestHeight = targetHeight;
                }
            }
        }

        // 결과 출력
        System.out.println(minTime + " " + bestHeight);
    }
}
