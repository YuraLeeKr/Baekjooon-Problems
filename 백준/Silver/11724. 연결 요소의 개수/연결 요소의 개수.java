import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수

        Connected c = new Connected();

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            c.addEdge(a,b);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for(int i=1; i<=N; i++){
            if(!visited.contains(i)){
                c.DFS(i, visited);
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
    public static class Connected{
        Map<Integer, List<Integer>> graph = new HashMap<>();

        public void addEdge(int a,int b){
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        public void DFS(int start, Set<Integer> visited){
            Stack<Integer> stack = new Stack<>();
            stack.push(start);

            while(!stack.isEmpty()){
                int node = stack.pop();
                if(!visited.contains(node)){
                    visited.add(node);
                    List<Integer> list = graph.getOrDefault(node, new ArrayList<>());
                    for(int neighbor : list){
                        if (!visited.contains(neighbor)){
                            stack.push(neighbor);
                        }
                    }

                }
            }

        }
    }


}