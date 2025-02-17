import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사다리 수
        int M = sc.nextInt(); // 뱀의 수

        int[] Board = new int[101];


        for(int i=0; i<M+N; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            Board[from] = to;
        }

        int result = BFSgame(Board);
        System.out.println(result);
    }

    public static int BFSgame(int[] Board){
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[]{1,0}); // 1번칸에서 시작, 주사위 굴린 횟수 0번
        visited.add(1);

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int location = node[0];
            int dice = node[1];

            if(location == 100) return dice;

            for(int i=1; i<=6; i++){
                int after = location + i;

                if(after > 100 || visited.contains(after)) continue;

                if(Board[after] != 0 ) {
                    after = Board[after];
                }

                if(!visited.contains(after)){
                    queue.add(new int[]{after, dice + 1});
                    visited.add(after);
                }

            }
        }
        return -1;
    }
}

