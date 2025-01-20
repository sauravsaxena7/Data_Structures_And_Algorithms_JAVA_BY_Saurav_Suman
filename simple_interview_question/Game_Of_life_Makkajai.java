package simple_interview_question;


import java.util.HashSet;
import java.util.Set;

 class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}


public class Game_Of_life_Makkajai {

    // Represents a point in the grid with x, y coordinates


    // Get the neighbors of a given point
    private static Set<Point> getNeighbors(Point p) {
        Set<Point> neighbors = new HashSet<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    System.out.println("dx,dy"+dx+" , "+dy);
                    neighbors.add(new Point(p.x + dx, p.y + dy));
                }
            }
        }
        return neighbors;
    }

    // Get the next state of the universe
    public static Set<Point> getNextGeneration(Set<Point> aliveCells) {
        Set<Point> newAliveCells = new HashSet<>();
        Set<Point> candidates = new HashSet<>();

        // Add all neighbors of alive cells as candidates for evaluation
        for (Point cell : aliveCells) {
            candidates.add(cell);
            candidates.addAll(getNeighbors(cell));
        }

        // Evaluate each candidate cell
        for (Point cell : candidates) {
            Set<Point> neighbors = getNeighbors(cell);
            int liveNeighbors = 0;

            for (Point neighbor : neighbors) {
                if (aliveCells.contains(neighbor)) {
                    liveNeighbors++;
                }
            }

            // Apply the Game of Life rules
            if (aliveCells.contains(cell)) {
                if (liveNeighbors == 2 || liveNeighbors == 3) {
                    newAliveCells.add(cell); // Live cell stays alive
                }
            } else {
                if (liveNeighbors == 3) {
                    newAliveCells.add(cell); // Dead cell comes to life
                }
            }
        }

        return newAliveCells;
    }

    // Helper to print the state of the universe
    public static void printUniverse(Set<Point> aliveCells) {
        for (Point cell : aliveCells) {
            System.out.println(cell.x + ", " + cell.y);
        }
    }

    public static void main(String[] args) {
        // Input: Block pattern (Still life)
        Set<Point> aliveCells = new HashSet<>();
//        aliveCells.add(new Point(1, 1));
//        aliveCells.add(new Point(1, 2));
//        aliveCells.add(new Point(1, 3));
//        aliveCells.add(new Point(2, 2));
//        aliveCells.add(new Point(2, 3));
//        aliveCells.add(new Point(2, 4));


        aliveCells.add(new Point(1, 1));
        aliveCells.add(new Point(1, 0));
        aliveCells.add(new Point(1, 2));
//        aliveCells.add(new Point(2, 2));
//        aliveCells.add(new Point(2, 3));
//        aliveCells.add(new Point(2, 4));

        // Get next generation
        Set<Point> nextGeneration = getNextGeneration(aliveCells);

        // Output the next generation
        printUniverse(nextGeneration);
    }
}