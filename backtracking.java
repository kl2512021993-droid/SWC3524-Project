import java.util.*;

public class UPTMMarketingOptimization {

    static int[][] costMatrix = {
        {0, 15, 25, 35},
        {15, 0, 30, 28},
        {25, 30, 0, 20},
        {35, 28, 20, 0}
    };

    static String[] locations = {"UPTM", "City B", "City C", "City D"};

    static int minCost = Integer.MAX_VALUE;
    static String bestPath = "";

    public static String backtrackingMCOP(int[][] dist) {

        int n = dist.length;
        boolean[] visited = new boolean[n];

        visited[0] = true;

        StringBuilder path = new StringBuilder();
        path.append(locations[0]).append(" -> ");

        mcopBacktracking(0, dist, visited, n, 1, 0, path);

        return "Minimum Cost: " + minCost + "\nBest Path: " + bestPath;
    }

    private static void mcopBacktracking(int pos, int[][] dist,
                                         boolean[] visited, int n,
                                         int count, int cost,
                                         StringBuilder path) {

        if (count == n) {
            int totalCost = cost + dist[pos][0];

            String finalPath = path.toString() + locations[0];

            if (totalCost < minCost) {
                minCost = totalCost;
                bestPath = finalPath;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                visited[i] = true;
                path.append(locations[i]).append(" -> ");

                mcopBacktracking(i, dist, visited, n, count + 1,
                        cost + dist[pos][i], path);

                visited[i] = false;
                path.delete(path.length() - (locations[i].length() + 4), path.length());
            }
        }
    }

    public static void main(String[] args) {

        String result = backtrackingMCOP(costMatrix);

        System.out.println(result);
    }
}
