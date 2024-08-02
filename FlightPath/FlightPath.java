import java.util.*;

public class FlightPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of flights: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<int[][]> paths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Coordinates for Flight " + (i + 1) + " (format: x1,y1 x2,y2 ...): ");
            String line = sc.nextLine();
            String[] coords = line.split(" ");
            int[][] path = new int[coords.length][2];

            for (int j = 0; j < coords.length; j++) {
                String[] pair = coords[j].split(",");
                path[j][0] = Integer.parseInt(pair[0]);
                path[j][1] = Integer.parseInt(pair[1]);
            }

            paths.add(path);
        }

        adjustPaths(paths);

        System.out.println("\nAdjusted Paths:");
        for (int i = 0; i < paths.size(); i++) {
            System.out.print("Flight " + (i + 1) + ": ");
            printPath(paths.get(i));
        }

        sc.close();
    }

    private static void printPath(int[][] path) {
        for (int[] p : path) {
            System.out.print("(" + p[0] + ", " + p[1] + ") ");
        }
        System.out.println();
    }

    private static void adjustPaths(List<int[][]> paths) {
        Set<String> usedCoordinates = new HashSet<>();
        
        for (int[] point : paths.get(0)) {
            usedCoordinates.add(point[0] + "," + point[1]);
        }

        for (int i = 1; i < paths.size(); i++) {
            int[][] path = paths.get(i);
            for (int j = 0; j < path.length; j++) {
                while (usedCoordinates.contains(path[j][0] + "," + path[j][1])) {
                    path[j][0] += 1;
                    path[j][1] += 1;
                }
                usedCoordinates.add(path[j][0] + "," + path[j][1]);
            }
        }
    }
}
