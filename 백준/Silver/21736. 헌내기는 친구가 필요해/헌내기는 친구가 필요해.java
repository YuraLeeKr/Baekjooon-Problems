import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //행의 개수
        int N = sc.nextInt(); //열의 개수

        //2차원 배열 생성
        Character[][] Map = new Character[M][N];

        //2차원 배열 입력 받기
        sc.nextLine();
        for(int i=0; i<M; i++){
            String line = sc.nextLine();
            for(int j=0; j<N; j++){
                Map[i][j] = line.charAt(j);
            }
        }

        int k = BFS(Map, M, N);
        if(k == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(k);
        }

    }

    public static int BFS(Character[][] Map, int M, int N){
        int[] dx = {+1, 0, -1, 0};
        int[] dy = {0, +1, 0, -1};

        int [] start = new int[2];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(Map[i][j].equals('I')){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start[0] + "," + start[1]);

        int result = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N
                        && !visited.contains(nx + "," + ny) && Map[nx][ny] != 'X') {
                    visited.add(nx + "," + ny);
                    if (Map[nx][ny] == 'P') result++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return result;
    }


}