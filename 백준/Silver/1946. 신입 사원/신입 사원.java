import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            int p = Integer.parseInt(br.readLine());
            int[][] scores = new int[p][2];

            for (int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[i][0] = Integer.parseInt(st.nextToken());
                scores[i][1] = Integer.parseInt(st.nextToken());
            }


            //서류 성적 기준으로 오름차순 정렬
            Arrays.sort(scores, (a, b) -> Integer.compare(a[0], b[0]));

            int result = 1;
            int bestInterview = scores[0][1];

            for (int i = 1; i < p; i++) {
                if (scores[i][1] < bestInterview) {
                    result++;
                    bestInterview = scores[i][1];
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

}