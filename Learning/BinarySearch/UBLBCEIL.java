package BinarySearch;
// Key Differences
// Function	Returns	Condition
// Upper Bound	First index where arr[i] > target	arr[mid] > target
// Lower Bound	First index where arr[i] ≥ target	arr[mid] >= target
// Ceil	Smallest value ≥ target	arr[mid] >= target
// Floor	Largest value ≤ target	arr[mid] <= target
public class UBLBCEIL {
    public static int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                r = mid;  // Move left
            } else {
                l = mid + 1;  // Move right
            }
        }
        return l;
    }

    public static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;  // Move left
            } else {
                l = mid + 1;  // Move right
            }
        }
        return l;
    }
    public static int findCeil(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ceil = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                ceil = arr[mid];  // Potential ceil
                r = mid - 1;  // Move left
            } else {
                l = mid + 1;  // Move right
            }
        }
        return ceil;
    }
    public static int findFloor(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int floor = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                floor = arr[mid];  // Potential floor
                l = mid + 1;  // Move right
            } else {
                r = mid - 1;  // Move left
            }
        }
        return floor;
    }
            
}
