package Learning.sorting;
import java.util.*;
public class MergeSort {
    public static void mergeSort(int[] ar, int left, int right){
        if(left>=right){
            return;
        }
         
            int mid =left + (right-left) /2;
            mergeSort(ar, left, mid);
            mergeSort(ar, mid+1, right);
            merge(ar, left, mid, right);
    }
    public static void merge(int[] ar, int left , int mid,  int right){
         int leftSize = mid-left+1;
         int rightSize = right-mid;
         int[] leftArray = new int[leftSize];
         int [] rightArray = new int[rightSize];
         for (int i = 0; i < leftSize; i++) {
            leftArray[i] = ar[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = ar[mid + 1 + i];
        }
        
         int l = 0, r= 0;
         int k = left;.
         while(l<leftSize && r < rightSize){
            if(leftArray[l] <= rightArray[r]){
                ar[k] = leftArray[l];
                l++;
            }
            else{
                ar[k] = rightArray[r];
                r++;
            }
            k++;
         }
         while(l<leftSize){
            ar[k] = leftArray[l];
            k++;l++;
         }
         while(r<rightSize){
            ar[k] = rightArray[r];
            r++;k++;
         }

    }
     
    public static void main(String[] args) {
        int[] ar = {3, 12, 6, 9,1,3,11, 45};
        mergeSort(ar, 0, ar.length-1);
        System.out.println(Arrays.toString(ar));
    }
}
