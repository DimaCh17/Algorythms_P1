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
    // create N-by-N grid, with all sites blocked
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
            connect(position, getPos(i+1, j));
        }
        if (j>0 && isOpen(i, j-1)) {
            connect(getPos(i, j-1), position);
        }
        if (j<N-1 && isOpen(i, j+1)) {
            connect(position, getPos(i, j+1));
        }
    }

    public void connect(int from, int to) {
        //find parent
        int rootA = from;
        int rootB = to;
        while (matrix[rootA] != rootA && matrix[rootB] != rootB) {
            rootA = matrix[rootA];
            rootB = matrix[rootB];
        }
        if (matrix[rootA] == rootA) {
            while (matrix[rootB] != rootB) rootB = matrix[rootB];
            matrix[rootA] = rootB;
        } else {
            while (matrix[rootA] != rootA) rootA = matrix[rootA];
            matrix[rootB] = rootA;
        }
    }

    public boolean isOpen(int i, int j) {    // is site (row i, column j) open?
        return matrix[getPos(i,j)] > 0;
    }

    public boolean isFull(int i, int j) {    // is site (row i, column j) full?
        return false;
    }

    public boolean percolates()  {           // does the system percolate?
        return matrix[1] == matrix[N*N+2];
    }

    public static void main(String[] args) { // test client (optional)
        Scanner in  = new Scanner(System.in);


        int N = in.nextInt();
        int T = in.nextInt();
    }
}