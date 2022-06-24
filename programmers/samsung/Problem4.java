package samsung;

import java.io.*;
import java.util.*;


public class Problem4 {
    static HashMap<Integer, List<Integer>> stationInfo;
    static HashMap<Integer, List<Integer>> linkedNode;
    //    static List<int[]> line;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("programmers/samsung/sample4_input.txt")));
        int testCase = Integer.parseInt(br.readLine());

        String format = "#%d %d";
        for (int i = 0; i < testCase; i++) {
            double before = System.currentTimeMillis();
            //초기화
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int station = info[0];  //역의 개수
            int node = info[1];     // 호선의 개수
            int startStation = info[2];
            int targetStation = info[3];
//            line = new ArrayList<>();
            linkedNode = new HashMap<>();
            stationInfo = new HashMap<>();
            answer = 1001;

            br.readLine();  //각 호선의 역 개수
            for (int j = 0; j < node; j++) {
                int[] jLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int stationByNode : jLine) {
                    List<Integer> list = stationInfo.getOrDefault(stationByNode, new ArrayList<>());
                    list.add(j + 1);
                    stationInfo.put(stationByNode, list);
                }
//                line.add(jLine);
            }

            for (List<Integer> nodes : stationInfo.values()) {
                if (nodes.size() <= 1) continue;

                for (int n : nodes) {
                    List<Integer> getList = linkedNode.getOrDefault(n, new ArrayList<>());
                    List<Integer> link = nodes.stream().filter(x -> x != n).toList();
                    link.forEach(x -> {
                        if (!getList.contains(x)) getList.add(x);
                    });
                    linkedNode.put(n, getList);
                }
            }

            boolean[] nodeVisit = new boolean[node + 1];  //각 호선 방문 여부
            nodeVisit[0] = true;

            for (int startNode : stationInfo.get(startStation)) {
                List<Integer> targetNodes = stationInfo.get(targetStation);

                nodeVisit[startNode] = true;
                Go(startNode, targetNodes, 0, nodeVisit);
                nodeVisit[startNode] = false;
            }

            if (answer == 1001) answer = -1;
            System.out.format(format, i + 1, answer);
            System.out.println();

            double after = System.currentTimeMillis();
            double time = (after - before) / 1000;
            System.out.println("걸린 시간 : " + time);
        }
    }

    static void Go(int curNode, List<Integer> targetNodes, int count, boolean[] nodeVisit) {
        if (count >= answer) return;
        if (targetNodes.contains(curNode)) {
            answer = count;
            return;
        }
        if (linkedNode.getOrDefault(curNode, new ArrayList<>()).size() == 0) {
            nodeVisit[curNode] = true;
            return;   //갈수 있는 곳 없음
        }
        for (int nextNode : linkedNode.get(curNode)) {
            if (nodeVisit[nextNode]) continue;
            nodeVisit[nextNode] = true;
//            System.out.println("현재 " + curNode + "호선에서 " + nextNode + "호선으로 환승합니다. " + count+"번 환승");
            Go(nextNode, targetNodes, count + 1, nodeVisit);
            nodeVisit[nextNode] = false;
        }
    }
}
