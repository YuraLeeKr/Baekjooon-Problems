import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 개수

        for(int i=0; i<n; i++){
            int l = sc.nextInt(); // 체스판 크기
            int [] start = {sc.nextInt(), sc.nextInt()}; //현재 위치
            int [] end = {sc.nextInt(), sc.nextInt()}; // 목표 위치
            System.out.println(KnightMoves.BFS(l,start, end));
        }
    }

    static public class KnightMoves{
        //나이트의 8가지 이동방향
        //(-2,-1) (-2,1) (2,-1) (2,1) (1,-2) (1,2) (-1,-2) (-1,2)
        static int[] dx = {-2, -2, 2, 2, 1, 1, -1, -1};
        static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};

        public static int BFS(int l, int[] start, int[] end){
            // BFS 구현을 위한 Queue
            Queue<int[]> queue = new LinkedList<>();
            //방문된 노드를 체크하기 위한 배열
            boolean[][] visited = new boolean[l][l];

            queue.add(start); //큐에 start위치 추가
            visited[start[0]][start[1]] = true; // visited 표시
            int result = 0; // 이동 횟수 변수

            while(!queue.isEmpty()){ // 큐가 empty될 때까지 반복
                int n = queue.size();

                for(int i=0;i<n;i++) { 
                    int[] current = queue.poll();

                    if (current[0] == end[0] && current[1] == end[1]) { // 현재 위치가 end 위치와 같다면 result 반환
                        return result;
                    }

                    for(int j=0;j<8;j++){ // 나이트의 8가지 이동 경우 체크
                        int nx = current[0] + dx[j];
                        int ny = current[1] + dy[j];

                        if(nx>=0 && nx<l && ny>=0 && ny<l){ // 이동 위치가 범위 안에 있는 경우
                            if(!visited[nx][ny]){// 아직 방문되지 않았다면
                                visited[nx][ny] = true; // visited 표시
                                queue.add(new int[]{nx,ny}); // 큐에 추가
                            }
                        }
                    }
                }
                result++;
            }
            return -1;
        }

    }

}


