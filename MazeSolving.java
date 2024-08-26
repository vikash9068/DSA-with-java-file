import java.util.ArrayList;
import java.util.List;

public class MazeSolving {

    static List<String> strList = new ArrayList<>();
    static String path = "";

    static boolean isSafe(int row, int col, int m[][], boolean[][] visited, int n) {
        if (row >= 0 && row < n && col >= 0 && col < n && m[row][col] == 1 && !visited[row][col]) {
            return true;
        }
        return false;
    }

    static void printPathHelper(int row, int col, int m[][], boolean[][] visited, int n) {

        if (row == n - 1 && col == n - 1) {
            strList.add(path);
            return;
        }

        visited[row][col] = true;

        // Move Down
        if (isSafe(row + 1, col, m, visited, n)) {
            path += 'D';
            printPathHelper(row + 1, col, m, visited, n);
            path = path.substring(0, path.length() - 1);
        }

        // Move Right
        if (isSafe(row, col + 1, m, visited, n)) {
            path += 'R';
            printPathHelper(row, col + 1, m, visited, n);
            path = path.substring(0, path.length() - 1);
        }

        // Move Up
        if (isSafe(row - 1, col, m, visited, n)) {
            path += 'U';
            printPathHelper(row - 1, col, m, visited, n);
            path = path.substring(0, path.length() - 1);
        }

        // Move Left
        if (isSafe(row, col - 1, m, visited, n)) {
            path += 'L';
            printPathHelper(row, col - 1, m, visited, n);
            path = path.substring(0, path.length() - 1);
        }

        visited[row][col] = false;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 0, 0, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
        int n = arr.length;

        boolean[][] visited = new boolean[n][n];

        printPathHelper(0, 0, arr, visited, n);

        if (strList.isEmpty()) {
            System.out.println("No path found");
        } else {
            for (String s : strList) {
                System.out.println(s + " ");
            }
        }
    }
}
