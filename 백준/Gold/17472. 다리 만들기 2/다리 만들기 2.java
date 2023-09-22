import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int island = 2; // 섬 맵핑할 숫자 선언
    static boolean[][] vis;
    static List<Bridge> edges;
    static int[] roots;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬마다 맵핑
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    mapIsland(i,j);
                }
            }
        }

        roots = new int[island];

        for (int i = 0; i < roots.length; i++) {
            roots[i] = i; // 아 집중안돼
        }

        edges = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]>0 && edgeCheck(i,j)) { // 외곽인가?
                    // 내자신 너무 잘했어.. 지금까지 아주 잘하고 있어..
                    findBridge(i, j);
                }
            }
        }
//        for (int i = 0; i < edges.size(); i++) {
//            System.out.println(edges.get(i));
//        }
        // Bridge 정렬
        Collections.sort(edges);
//        System.out.println("----------------------------------");
//        for (int i = 0; i < edges.size(); i++) {
//            System.out.println(edges.get(i));
//        }
        graph = new List[island];
        for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
        
        union();
    }

    // 섬 다 다른 숫자로 맵핑
    public static void mapIsland(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j});
        map[i][j] = island;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int d = 0; d < dc.length; d++) {
                int ni = temp[0] + dr[d];
                int nj = temp[1] + dc[d];

                if (borderCheck(ni, nj)&& map[ni][nj]==1) {
                    map[ni][nj] = island; // 섬이라면(1) -> island 값으로 맵핑
                    q.add(new int[] {ni, nj});
                }
            }
        }
        island++; // while문 다 끝나면 island 값 올려서 다음 섬 찾기
    }

    public static boolean borderCheck(int i, int j) {
        if (i>=0 && i<map.length && j>=0 && j<map[0].length) {
            return true;
        }
        return false;
    }


    public static boolean edgeCheck(int i, int j) {
        for (int d = 0; d < dc.length; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];

            if (borderCheck(ni, nj) && map[ni][nj] == 0) { // 0이 인접해있으면 외곽
                return true;
            }
        }
        return false; // 주변에 0이 없으면 false
    }

    public static void findBridge(int r, int c) {
        for (int d = 0; d < dc.length; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            while (borderCheck(nextR, nextC)) {
                if (map[nextR][nextC] != 0) {
                    break;
                }
                nextR += dr[d];
                nextC += dc[d];
            }
            if (borderCheck(nextR, nextC) && map[nextR][nextC] != map[r][c]) {
                int len = Math.abs(nextR - r) + Math.abs(nextC - c) - 1;

                if (len > 1) {
                    boolean check = true;
                    Bridge bridge = new Bridge(map[r][c], map[nextR][nextC], len);
                    for (int i = 0; i < edges.size(); i++) {
                        if(edges.get(i).end == bridge.end && edges.get(i).start == bridge.start && edges.get(i).length == bridge.length) {
                            check = false;
                            break;
                        }
                        if(edges.get(i).end == bridge.start && edges.get(i).start == bridge.end && edges.get(i).length == bridge.length) {
                            check = false;
                            break;
                        }
                    }
                    if(check) {
                        edges.add(bridge);
                    }
                }
            }
        }
    }

    static int find(int a) {
        if (a == roots[a]) {
            return a;
        } else {
            return find(roots[a]);
        }
    }

    static void union() {
        int totalLen = 0;
        
        for (int i = 0; i < edges.size(); i++) {
            int r1 = find(edges.get(i).start);
            int r2 = find(edges.get(i).end);

            if (r1 > r2) {
                roots[r1] = r2;
                totalLen += edges.get(i).length;
                graph[r1].add(r2);
                graph[r2].add(r1);
            } else if (r2 > r1) {
                roots[r2] = r1;
                totalLen += edges.get(i).length;
                graph[r1].add(r2);
                graph[r2].add(r1);
            }
        }


        if (!connectCheck()) {
            System.out.println(-1);
        } else {
            System.out.println(totalLen);
        }
    }
    
    static boolean connectCheck() {
    	Queue<Integer> q = new LinkedList<>();
    	boolean[] vis = new boolean[island];
    	vis[2] = true;
    	q.add(2);
    	while (!q.isEmpty()) {
    		// 도와줘요..
    		int temp = q.poll();
    		
    		for (int i = 0; i < graph[temp].size(); i++) {
				if (!vis[graph[temp].get(i)]) {
					vis[graph[temp].get(i)] = true;
					q.add(graph[temp].get(i));
				}
			}
		}
    	for (int i = 2; i < vis.length; i++) {
			if (!vis[i]) {
				return false;
			}
		}
		return true;
    }


    static class Bridge implements Comparable<Bridge>{ // 노드 생성 완료
        int start;
        int end;
        int length;
        public Bridge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
        @Override
        public String toString() {
            return "Bridge [start=" + start + ", end=" + end + ", length=" + length + "]";
        }

        // 브릿지 길이 정렬
        @Override
        public int compareTo(Bridge o) {
            // TODO Auto-generated method stub
            return this.length - o.length;
        }

    }
}