import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer = sc.nextInt();
        int n = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=1; i<=computer; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(BFS(1, graph));
    }

    public static int BFS(int root, Map<Integer, List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(root);
        visited.add(root);
        int infected = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int k: graph.get(node)){
                if(!visited.contains(k)){
                    queue.add(k);
                    visited.add(k);
                    infected++;
                }
            }

        }
        return infected;
    }
}