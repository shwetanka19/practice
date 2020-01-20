import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class VictoryKnight {

    public static void main(String args[]){
        Kattio io = new Kattio(System.in, System.out);
        String start = io.getWord();
        String pos = io.getWord();
        String cap = io.getWord();

        int[] stCoords = new int[2];
        int[] posCoords = new int[2];
        int[] capCoords = new int[2];

        String tmp[] = start.split(" ");
        stCoords[0] = Integer.valueOf(tmp[0]);
        stCoords[1] = Integer.valueOf(tmp[1]);

        tmp = pos.split(" ");
        posCoords[0] = Integer.valueOf(tmp[0]);
        posCoords[1] = Integer.valueOf(tmp[1]);

        tmp = cap.split(" ");
        capCoords[0] = Integer.valueOf(tmp[0]);
        capCoords[1] = Integer.valueOf(tmp[1]);

        int chances [][] = new int[][]{{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, -2}, {-1, 2}, {1, 2}, {-1, -2}};
        Queue<Box> queue = new ArrayDeque<>();

        queue.add(new Box(posCoords[0], posCoords[1], 0));

        Map<String, Integer> visited = new HashMap<>();
        while (!queue.isEmpty()){
            Box b = ((ArrayDeque<Box>) queue).getFirst();

            for (int [] c : chances){
                Box tb = new Box(b.getRow()+c[0], b.getCol()+c[1], 0);
            }


            if (!visited.containsKey(b.toString())){
                visited.put(b.toString(), 1);
                queue.add(b);
            }else {
                //if (b.getRow()<0 || )
                b.setSteps(b.getSteps()+1);
                queue.add(b);
            }
        }


    }
}


class Box {
    private int row;
    private int col;
    private int steps;

    public Box(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return row+","+col;
    }
}