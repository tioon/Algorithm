package algorithm;

import java.util.*;

public class Alice_06 {
    static int[] parent;
    static int[] size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] colors = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            colors[i] = sc.nextInt();
        }

        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int redEdges = 0;

        for (int color : colors) {
            List<List<Integer>> components = new ArrayList<>();
            Map<Integer, List<Integer>> componentMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int root = find(i);
                if (!componentMap.containsKey(root)) {
                    componentMap.put(root, new ArrayList<>());
                }
                componentMap.get(root).add(i);
            }

            for (List<Integer> component : componentMap.values()) {
                components.add(component);
            }

            if (color == 0) { // 빨간 간선
                components.sort(Comparator.comparingInt(List::size));
                int u = components.get(0).get(0);
                int v = components.get(1).get(0);
                if (find(u) != find(v)) {
                    redEdges++;
                    union(u, v);
                }
            } else { // 파란 간선
                components.sort((a, b) -> b.size() - a.size());
                int u = components.get(0).get(0);
                int v = components.get(1).get(0);
                union(u, v);
            }
        }

        System.out.println(redEdges);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}
