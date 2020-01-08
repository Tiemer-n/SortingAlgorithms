package sortingalgorithms;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithms {

    
    public static ArrayList<Integer> InputNumbers = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        //infinite amount of inputs
        System.out.println("Input numbers (type 'stop' to finish): ");
        
        int i = 0;
        while (true) {
            ++i;
            System.out.print((i) + ": ");
            String Inputnum = input.next();
            if (!"stop".equals(Inputnum)) {
                int num = Integer.parseInt(Inputnum);
                InputNumbers.add(num);
            } else {
                break;
            }
        }
        System.out.println("unsorted list: ");
        for (int j = 0; j < InputNumbers.size(); j++) {
            System.out.print(InputNumbers.get(j) + " ");
        }
        System.out.println("");
        
        int[] Numbers = new int[InputNumbers.size()];
        
        for (int j = 0; j < Numbers.length; j++) {
            Numbers[j] = InputNumbers.get(j);
        }
        
        while(true){
            System.out.println("Do you want to use bubble sort(B) or Merge sort (M): ");
            String answer = input.next();
            if("B".equals(answer)){
                BubbleSort();
                break;
            }else if ("M".equals(answer)){
                MergeSort(Numbers,Numbers.length);
                
                for (int j = 0; j < Numbers.length; j++) {
                    InputNumbers.set(j, Numbers[j]);
                }
                
                break;
                
            }else{
                System.out.println("Invalid input...");
                System.out.println("");
                System.out.println("");
            }
        }

        System.out.println("sorted list: ");
        for (int j = 0; j < InputNumbers.size(); j++) {
            System.out.print(InputNumbers.get(j) + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("The smallest number is "+InputNumbers.get(0));
        System.out.println("The largest number it "+InputNumbers.get((InputNumbers.size()-1)));
        System.out.println("");
        
        int add = 0;
        for (int j = 0; j < Numbers.length; j++) {
            add+=Numbers[j];
        }
        int add2 = add/(Numbers.length);
        System.out.println("The average is "+ add2);
        
        
        
        
    }

    public static void BubbleSort() {
        //bubble sort-----------------------------------------
        
        for (int j = 0; j < (InputNumbers.size() * 100); j++) {

            for (int k = 0; k < InputNumbers.size(); k++) {

                if (k == (InputNumbers.size() - 1)) {
                    break;
                    //this breaks once all values have been swapped in one cycle
                    //as so it can go through it again
                } else {
                    if (InputNumbers.get(k) > InputNumbers.get(k + 1)) {
                        
                        //looks at first two places and then the next
                        //if the first value is bigger it swapps it with the one next to it
                        int temp = InputNumbers.get(k + 1);
                        InputNumbers.set(k + 1, InputNumbers.get(k));
                        InputNumbers.set(k, temp);
                    }
                }
            }
        }
        //bubble sort----------------------------------------
    }

    public static void MergeSort(int[] a, int n) {
        if (n < 2) {
            return;
            //returns if the length of the list is 1
        }
        int mid = n / 2;
        
        int[] Left = new int[mid];
        int[] Right = new int[n - mid];
        //makes two arrays for both halfs of the initial array
        
        
        for (int i = 0; i < mid; i++) {
            Left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            Right[i - mid] = a[i];
        }
        //places the corresponding value in the initial array in the two sub arrays
        
        MergeSort(Left, mid);
        MergeSort(Right, n - mid);
        // repeats the cycle until there are only arrays with length of one 
        
        // it then finally merges these single length arrays into the inital array at the ascending order
        Merge(a, Left, Right, mid, n - mid);
    }

    public static void Merge(int[] a, int[] l, int[] r, int Left, int Right) {

        int i = 0;
        int j = 0;
        int k = 0;
        
        //while loop breaks if one of the arrays are exhausted (for avoid out of bounds error)
        while (i < Left && j < Right) {
            //comparing in which array has the smallest value then puts that in the inital array
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        
        //filling up the initial array with the rest of the array that still has values inside
        while (i < Left) {
            a[k++] = l[i++];
        }
        while (j < Right) {
            a[k++] = r[j++];
        }
    }

}
