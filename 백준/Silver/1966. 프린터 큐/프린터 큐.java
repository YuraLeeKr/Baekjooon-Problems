import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int i=0; i<testcase; i++) {
            int N = sc.nextInt(); //문서의 개수
            int M = sc.nextInt(); // 궁금한 문서의 위치
            int k = Printer(N, M, sc);
            System.out.println(k);
        }
    }

    public static int Printer(int N, int M, Scanner sc){
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            int k = sc.nextInt();
            queue.add(new int[]{i,k}); // 인덱스, 중요도
        }
        int count = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            boolean isMax = true;

            for(int[] arr: queue){
                if(arr[1] > node[1]){
                    isMax = false;
                    break;
                }
            }

            if(isMax){
                count++;
                if(node[0] == M) return count;
            }else{
                queue.add(node);
            }

        }
        return count;
    }
}