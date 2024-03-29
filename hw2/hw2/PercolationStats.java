package hw2;

public class PercolationStats {

    private int size;
    private int count;
    private double[] data;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        size = N;
        count = T;

        data = new double[count];

        for (int i = 0; i < count; i += 1) {
            Percolation lab = pf.make(size);
            int[] operation = edu.princeton.cs.algs4.StdRandom.permutation(size * size);
            int j = 0;
            while (!lab.percolates() && j < size * size) {
                int index = operation[j];
                int r = index / size;
                int c = index % size;
                lab.open(r, c);
                j += 1;
            }
            data[i] = (double)lab.numberOfOpenSites() / (double)(size * size);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return edu.princeton.cs.algs4.StdStats.mean(data);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (count == 1) {
            return Double.NaN;
        }
        return edu.princeton.cs.algs4.StdStats.stddev(data);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - (1.96 * stddev()) / Math.sqrt(count);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + (1.96 * stddev()) / Math.sqrt(count);
    }


}
