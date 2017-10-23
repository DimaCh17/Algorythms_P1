import java.util.Scanner;

/**
 * Created by stsymb on 10/22/17.
 */
public class Percolation {
    private int N;
    private int start;
    private int end;
    private int[] matrix;

    public Percolation(int N) {
    // create N-by-N grid, with all sites blocked (root == 0)
        this.matrix = new int[N*N + 3];
        this.N = N;
        this.start = 1;
        this.matrix[this.start] = this.start; //start
        this.end = N*N + 2;
        this.matrix[this.end] = this.end; //end
    }

    int getPos(int i, int j) {
        return 2 + i*N + j;
    }

    public void open(int i, int j) {
        // open site (row i, column j) if it is not open already
        int position = getPos(i, j);
        matrix[position] = position;

        if (i == 0) {
            connect(position, this.start);
        } else if (i == (N-1) ) {
            connect(position, this.end);
        }

        // check all neighbor cells
        if (i>0 && isOpen(i-1, j)) {
            connect(getPos(i-1, j), position);
        }
        if (i<N-1 && isOpen(i+1, j)) {
            connect(getPos(i+1, j), position);
        }
        if (j>0 && isOpen(i, j-1)) {
            connect(getPos(i, j-1), position);
        }
        if (j<N-1 && isOpen(i, j+1)) {
            connect(getPos(i, j+1), position);
        }
    }

    public int getRoot(int vertex) {
        while (matrix[vertex] != vertex) {
            vertex = matrix[vertex];
        }
        return vertex;
    }

    public int getDepth(int vertex) {
        int depth = 0;
        while (matrix[vertex] != vertex) {
            vertex = matrix[vertex];
            depth++;
        }
        return depth;
    }

    public void connect(int from, int to) {
        if (getDepth(from) > getDepth(to)) {
            matrix[getRoot(to)] = getRoot(from);
        } else {
            matrix[getRoot(from)] = getRoot(to);
        }
    }

    public boolean isOpen(int i, int j) {    // is site (row i, column j) open?
        return matrix[getPos(i,j)] > 0;
    }

    public boolean isFull(int i, int j) {    // is site (row i, column j) full?
        return false;
    }

    public boolean isConected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    public boolean percolates()  {           // does the system percolate?
        return isConected(start, end);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Start: ").append(matrix[start]).append("\n");
        int position = 2;
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++){
                sb.append(' ').append(matrix[position]);
                position++;
            }
            sb.append("\n");
        }
        sb.append("End: ").append(matrix[end]);
        return sb.toString();
    }

    public static void main(String[] args) { // test client (optional)
        Percolation pc = new Percolation(3);
        pc.open(0,0);
        pc.open(1,0);
        pc.open(2,0);
        System.out.println(pc);
        System.out.println("Percolates = " + pc.percolates() + ", expected: True");

        pc = new Percolation(3);
        pc.open(0,0);
        pc.open(1,1);
        pc.open(2,2);
        System.out.println(pc);
        System.out.println("Percolates = " + pc.percolates() + ", expected: False");
    }
}
