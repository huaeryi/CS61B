package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] opened;
    private int top;
    private int bottem;
    private int size;
    private int num;
    private WeightedQuickUnionUF percolated;
    private WeightedQuickUnionUF ispercolated;

    /**
     * create N-by-N grid, with all sites initially blocked
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        size = N;
        num = 0;
        opened = new boolean[size][size];
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                opened[i][j] = false;
            }
        }
        percolated = new WeightedQuickUnionUF(size * size + 1);
        ispercolated = new WeightedQuickUnionUF(size * size + 2);
        top = size * size;
        bottem = size * size + 1;
    }

    /**
     * open the site (row, col) if it is not open already
     */
    private boolean isOpenhelper(int row, int col) {
        if (!isLegal(row, col)) {
            return false;
        }
        return opened[row][col];
    }
    public void open(int row, int col) {
        if (!isLegal(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            opened[row][col] = true;
            num += 1;
            int index = index(row, col);
            if (row == 0) {
                percolated.union(index, top);
                ispercolated.union(index, top);
            }
            if (row == size - 1) {
                ispercolated.union(index, bottem);
            }
            if (isOpenhelper(row - 1, col)) {
                percolated.union(index, index(row - 1, col));
                ispercolated.union(index, index(row - 1, col));
            }
            if (isOpenhelper(row, col - 1)) {
                percolated.union(index, index(row, col - 1));
                ispercolated.union(index, index(row, col - 1));
            }
            if (isOpenhelper(row, col + 1)) {
                percolated.union(index, index(row, col + 1));
                ispercolated.union(index, index(row, col + 1));
            }
            if (isOpenhelper(row + 1, col)) {
                percolated.union(index, index(row + 1, col));
                ispercolated.union(index, index(row + 1, col));
            }
        }
    }

    /**
     * is the site (row, col) open?
     */
    public boolean isOpen(int row, int col) {
        if (!isLegal(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return opened[row][col];
    }

    /**
     * is the site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        if (!isLegal(row, col)) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)) {
            return false;
        }
        int index = index(row, col);
        if (percolated.connected(index, top)) {
            return true;
        }
        return false;
    }

    /**
     * number of open sites
     */
    public int numberOfOpenSites() {
        return num;
    }

    /**
     * does the system percolate?
     */
    public boolean percolates() {
        if (ispercolated.connected(top, bottem)) {
            return true;
        }
        return false;
    }

    private boolean isLegal(int row, int col) {
        if ((row >= 0 && row < size) && (col >= 0 && col < size)) {
            return true;
        }
        return false;
    }

    private int index(int i, int j) {
        return size * i + j;
    }

    public static void main(String[] args) {
        Percolation t = new Percolation(3);
        t.open(2, 1);
        System.out.println(t.numberOfOpenSites());
    }

}
