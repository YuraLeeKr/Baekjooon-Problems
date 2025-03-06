import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭의 개수
        int w = sc.nextInt(); // 다리의 길이
        int L = sc.nextInt(); // 다리의 최대 하중

        Queue<Integer> trucks = new LinkedList<>(); // 트럭 대기열

        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            trucks.add(k);
        }

        Queue<Integer> bridge = new LinkedList<>(); // 다리 위 트럭들
        Queue<Integer> bridgeTime = new LinkedList<>(); // 각 트럭의 다리위 시간 추적
        int time = 0;  // 시간
        int weight = 0;  // 다리 위 트럭들의 총 무게

        // 다리 위에 트럭들이 있거나, 대기 중인 트럭이 남아있는 경우
        while(!trucks.isEmpty() || !bridge.isEmpty()) {
            time++;  // 1초 경과
            int size = bridgeTime.size();
            for(int i=0; i<size; i++){
                int remainingTime = bridgeTime.poll();
                remainingTime--;
                if(remainingTime > 0){
                    bridgeTime.add(remainingTime);
                }else{
                    weight -= bridge.poll();
                }
            }
            // 다리 위에 트럭을 올릴 수 있는지 체크
            if (!trucks.isEmpty() && weight + trucks.peek() <= L) {
                int truck = trucks.poll();  // 대기 중인 트럭을 하나 꺼냄
                bridge.add(truck);  // 다리 위에 올림
                bridgeTime.add(w);
                weight += truck;  // 다리 위의 총 무게 갱신
            }
        }

        System.out.println(time);  // 전체 시간이 끝난 후 출력
    }
}
