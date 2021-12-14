
import java.util.*;

public class Graph {

    private final List<LinkedList<Integer>> adjList;
    private final int size;

    Graph(int size) {
        adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjList.add(new LinkedList<>());
        }
        this.size = size;
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);

        System.out.println("DFS traversal: ");
        processDFS(v, visited);
    }

    private void processDFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);

        for (Integer w:adjList.get(v)) {
            if (!visited[w]) {
                processDFS(w, visited);
            }
        }
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[size];
        Queue<Integer> visitQ = new LinkedList<>();
        Arrays.fill(visited, false);
        visitQ.add(v);
        visited[v] = true;

        System.out.println("BFS traversal:");
        processBFS(visited, visitQ);
    }

    private void processBFS(boolean[] visited, Queue<Integer> visitQ) {
        Integer v;
        while ((v = visitQ.poll()) != null) {
            System.out.println(v);

            for(int w: adjList.get(v)) {
                if (!visited[w]) {
                    visitQ.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        g.DFS(0);

        g.BFS(0);
    }
}
