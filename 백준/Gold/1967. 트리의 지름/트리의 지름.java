import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static List<Edge>[] graph;
    static int max = Integer.MIN_VALUE;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new List[n+1]; // 맞아요
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] parents = new int[n+1];
        
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            
            // 양방향
            graph[node1].add(new Edge(node2, len));
            graph[node2].add(new Edge(node1, len));

            parents[node2] = node1;
        }

        int root = 0;
        for (int i = 1; i < parents.length; i++) {
            if (parents[i] == 0) {
                root = i;
            }
        }

        boolean[] check = new boolean[n+1];
        check[root] = true;
        findLeaf(root, 0, check);

        check = new boolean[n+1];
        check[index] = true;
        max = 0;
        findLeaf(index, 0, check);

        System.out.println(max);
    }
    // 가장 먼 노드 찾기
    public static void findLeaf(int node, int longest, boolean[] check) {
        max = Math.max(max, longest);
        if (max == longest) {
            index = node;
        }
        // 배고파서 머리가 안 돌아가는 거 같아요 확실해요
        // 밥 먹었는데도 머리가 안 돌아가는데요
        // 아니야 걔도 나한테 관심 있어 -> ?? 자의식 과잉
        // 배 만지지마 니트 입어서 아니라 그냥 ㅍ폭신할듯 야 고개 숙이면서 웃깆마 모니터 뒤에 숨지마 이건 배신이야
        // ㄴ강사님을?!?!?!?!?!?? ㅣㅇㄹ러야겠따 일러야겠다 ,,ㅠㅜㅜ
        for (int i = 0; i < graph[node].size(); i++) {
            if (!check[graph[node].get(i).node]) {
                check[graph[node].get(i).node] = true;
                findLeaf(graph[node].get(i).node, longest+graph[node].get(i).dis, check);
                check[graph[node].get(i).node] = false;
            }
        }


    }

    
// 기억을 다시 잃었따 .... ...ㅠ
    static class Edge {
        int node;
        int dis;

        public Edge() {
        }
    
        public Edge(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    
        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", dis=" + dis +
                    '}';
        }
    }
}
