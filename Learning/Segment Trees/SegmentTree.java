class SegmentTree {
    private int[] segmentTree;
    private int n;

    // Constructor: Builds the segment tree
    public SegmentTree(int[] arr) {
        this.n = arr.length;
        segmentTree = new int[4 * n];  // Allocating 4*N space to be safe
        build(arr, 0, 0, n - 1);
    }

    // Recursive function to build the segment tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            // Leaf node stores the value from the original array
            segmentTree[node] = arr[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;

            // Recursively build the left and right subtrees
            build(arr, leftChild, start, mid);
            build(arr, rightChild, mid + 1, end);

            // Internal node stores the sum of both children
            segmentTree[node] = segmentTree[leftChild] + segmentTree[rightChild];
        }
    }

    // Function to get the sum of a given range [L, R]
    public int rangeSumQuery(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    // Recursive function for range sum query
    private int query(int node, int start, int end, int L, int R) {
        // Case 1: Total Overlap (current segment is completely inside [L, R])
        if (L <= start && end <= R) {
            return segmentTree[node];
        }

        // Case 2: No Overlap
        if (end < L || start > R) {
            return 0;
        }

        // Case 3: Partial Overlap
        int mid = start + (end - start) / 2;
        int leftSum = query(2 * node + 1, start, mid, L, R);
        int rightSum = query(2 * node + 2, mid + 1, end, L, R);
        return leftSum + rightSum;
    }

    // Function to update an element at a given index
    public void update(int index, int newValue) {
        updateTree(0, 0, n - 1, index, newValue);
    }

    // Recursive function to update the segment tree
    private void updateTree(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            // Leaf node: update the value
            segmentTree[node] = newValue;
        } else {
            int mid = start + (end - start) / 2;
            if (index <= mid) {
                updateTree(2 * node + 1, start, mid, index, newValue);
            } else {
                updateTree(2 * node + 2, mid + 1, end, index, newValue);
            }

            // Update the current node after modifying child nodes
            segmentTree[node] = segmentTree[2 * node + 1] + segmentTree[2 * node + 2];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);

        // Query sum of range [1, 3]
        System.out.println("Sum of range (1,3): " + segTree.rangeSumQuery(1, 3));  // Output: 15

        // Update index 2 to 10
        segTree.update(2, 10);
        System.out.println("Sum of range (1,3) after update: " + segTree.rangeSumQuery(1, 3)); // Output: 20
    }
}
