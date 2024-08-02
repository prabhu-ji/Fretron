import java.util.*;

class State {
    int posX, posY;
    String status;

    State(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return posX + " " + posY + " " + status;
    }
}

public class CastlePathFinder {

    public static boolean check(int curx, int cury, char dir, int homeX, int homeY) {
        if (dir == 's' && homeX == curx && homeY > cury) {
            return true;
        }
        if (dir == 'e' && homeX > curx && homeY == cury) {
            return true;
        }
        if (dir == 'n' && homeX == curx && homeY < cury) {
            return true;
        }
        if (dir == 'w' && homeX < curx && homeY == cury) {
            return true;
        }
        return false;
    }

    public static void solve(int curx, int cury, char dir, int homeX, int homeY, List<List<State>> ans, List<State> path, Set<int[]> soldiers) {
        if (curx == homeX && cury == homeY && path.size() > 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        List<int[]> toRemove = new ArrayList<>();

        for (int[] soldier : soldiers) {
            int x = soldier[0];
            int y = soldier[1];

            if (dir == 's' && x == curx && y > cury) {
                if (x == homeX && y == homeY) {
                    solve(x, y, 's', homeX, homeY, ans, path, soldiers);
                    return;
                }
                State newState = new State(x, y);
                newState.setStatus("kill");
                path.add(newState);
                toRemove.add(soldier);
                soldiers.remove(soldier);
                solve(x, y, 'e', homeX, homeY, ans, path, soldiers);
                path.remove(path.size() - 1);
                soldiers.add(soldier);
            }
            if (dir == 'e' && x > curx && y == cury) {
                if (x == homeX && y == homeY) {
                    solve(x, y, 'e', homeX, homeY, ans, path, soldiers);
                    return;
                }
                State newState = new State(x, y);
                newState.setStatus("kill");
                path.add(newState);
                toRemove.add(soldier);
                soldiers.remove(soldier);
                solve(x, y, 'n', homeX, homeY, ans, path, soldiers);
                path.remove(path.size() - 1);
                soldiers.add(soldier);
            }
            if (dir == 'n' && x == curx && y < cury) {
                if (x == homeX && y == homeY) {
                    solve(x, y, 'n', homeX, homeY, ans, path, soldiers);
                    return;
                }
                State newState = new State(x, y);
                newState.setStatus("kill");
                path.add(newState);
                toRemove.add(soldier);
                soldiers.remove(soldier);
                solve(x, y, 'w', homeX, homeY, ans, path, soldiers);
                path.remove(path.size() - 1);
                soldiers.add(soldier);
            }
            if (dir == 'w' && x < curx && y == cury) {
                if (x == homeX && y == homeY) {
                    solve(x, y, 'w', homeX, homeY, ans, path, soldiers);
                    return;
                }
                State newState = new State(x, y);
                newState.setStatus("kill");
                path.add(newState);
                toRemove.add(soldier);
                soldiers.remove(soldier);
                solve(x, y, 's', homeX, homeY, ans, path, soldiers);
                path.remove(path.size() - 1);
                soldiers.add(soldier);
            }
        }

        soldiers.addAll(toRemove);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Find my home castle - soldiers: ");
        int noOfSoldiers = scanner.nextInt();
        System.out.println("NOTE: Enter the coordinate in this format -> x y");

        Set<int[]> soldiers = new HashSet<>();
        for (int i = 1; i <= noOfSoldiers; i++) {
            System.out.print("Enter coordinates for soldier " + i + ": ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            soldiers.add(new int[]{x, y});
        }

        System.out.print("Enter the coordinates for your special castle: ");
        int castleX = scanner.nextInt();
        int castleY = scanner.nextInt();
        soldiers.add(new int[]{castleX, castleY});

        char dir = 's';
        List<List<State>> ans = new ArrayList<>();
        List<State> path = new ArrayList<>();
        State s = new State(castleX, castleY);
        s.setStatus("start");
        path.add(s);

        solve(castleX, castleY, dir, castleX, castleY, ans, path, soldiers);

        System.out.println("Number of paths found: " + ans.size());
        for (List<State> p : ans) {
            System.out.println("Path:");
            for (State state : p) {
                System.out.println(state);
            }
        }

        scanner.close();
    }
}
