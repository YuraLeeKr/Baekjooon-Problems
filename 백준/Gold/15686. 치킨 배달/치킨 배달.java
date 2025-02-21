import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 도시의 크기
        int M = sc.nextInt(); // 유지시킬 치킨집의 수

        int[][] Map = new int[N][N];
        List<int[]> house = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();

        //도시 맵 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Map[i][j] = sc.nextInt();
                if (Map[i][j] == 1) house.add(new int[]{i, j});
                if (Map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }

        //치킨집의 M 조합의 경우 구하기
        List<List<int[]>> result = new LinkedList<>();
        getCombine(0, chicken.size(),M, new ArrayList<int[]>(), result, chicken);

        //최소 치킨 거리 계산
        int MinDistanceSum = Integer.MAX_VALUE;

        for(List<int[]> combi : result){ //각 치킨집 조합 확인
            int Totaldistance = 0;
           for(int[] h : house){
                int Min = N*N;
               for(int[] c : combi){
                   int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    Min = Math.min(Min,distance);
               }
               Totaldistance += Min;
           }
           MinDistanceSum = Math.min(Totaldistance, MinDistanceSum);
        }
        System.out.println(MinDistanceSum);
    }

    // start, value개수, 조합 개수, selected, 조합 모을 list
    static void getCombine(int start, int n, int k, List<int[]> arr, List<List<int[]>> result, List<int[]> chicken){
        if(k == 0){
            result.add(new ArrayList<>(arr));
            return;
        }

        for(int i=start; i<n; i++){
            arr.add(chicken.get(i));
            getCombine(i+1, n, k-1, arr, result, chicken);
            arr.remove(arr.size()-1);
        }
    }
}