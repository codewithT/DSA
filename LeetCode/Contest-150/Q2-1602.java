// Floating-Point Precision Issues

// double values cannot always represent exact numbers, so direct comparisons (left < right) can lead to infinite loops or incorrect results.
// Since double arithmetic has small rounding errors, left may never exactly equal right.
// Stopping Condition for Binary Search

// Binary search keeps narrowing the range [left, right], but it never truly "converges" in floating-point.
// right - left > epsilon ensures we stop when the difference is small enough, avoiding unnecessary iterations.
// Ensures Required Precision (1e-5 Accuracy)

// The problem asks for accuracy within 10^-5.
// The condition guarantees that the difference between left and right is at most 1e-5, which is the required precision.

class Solution {
    public double separateSquares(int[][] squares) {
        double left = 0, right = getMaxHeight(squares);
        double epsilon = 1e-6; 

        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            if (getTotalAreaAbove(squares, mid) > getTotalAreaBelow(squares, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.round(left * 100000.0) / 100000.0;  
    }

    private double getTotalAreaAbove(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            int yi = square[1], l = square[2];
            int top = yi + l;
            if (top > y) {
                area += (top - Math.max(yi, y)) * l;
            }
        }
        return area;
    }

    private double getTotalAreaBelow(int[][] squares, double y) {
        double area = 0;
        for (int[] square : squares) {
            int yi = square[1], l = square[2];
            if (yi < y) {
                area += (Math.min(yi + l, y) - yi) * l;
            }
        }
        return area;
    }

    private double getMaxHeight(int[][] squares) {
        double maxHeight = 0;
        for (int[] square : squares) {
            maxHeight = Math.max(maxHeight, square[1] + square[2]);
        }
        return maxHeight;
    }

     
}
