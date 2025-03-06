import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];
    static int[] dx = {0, 1, 1, -1}; // 우, 하, 우하(↘), 좌하(↙)
    static int[] dy = {1, 0, 1, 1};  // 우, 하, 우하(↘), 좌하(↙)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바둑판 입력
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 승리 여부 탐색
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) { // 바둑알이 있는 경우만 체크
                    int winner = board[i][j];
                    for (int d = 0; d < 4; d++) { // 4가지 방향 체크
                        if (checkWin(i, j, dx[d], dy[d], winner)) {
                            System.out.println(winner);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 승부 미결정
        System.out.println(0);
    }

    // 승리 여부 확인 함수
    private static boolean checkWin(int x, int y, int dx, int dy, int color) {
        int count = 1;

        // 연속된 같은 색 바둑알 개수 세기
        for (int step = 1; step < 5; step++) {
            int nx = x + dx * step;
            int ny = y + dy * step;
            if (!isValid(nx, ny) || board[nx][ny] != color) break;
            count++;
        }

        // 6목 이상이면 승리 X
        if (count != 5) return false;

        // 앞뒤로 같은 색 바둑알이 있는지 확인 (6목 방지)
        int prevX = x - dx, prevY = y - dy;
        int nextX = x + dx * 5, nextY = y + dy * 5;
        if (isValid(prevX, prevY) && board[prevX][prevY] == color) return false;
        if (isValid(nextX, nextY) && board[nextX][nextY] == color) return false;

        return true;
    }

    // 좌표가 유효한지 확인하는 함수
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
