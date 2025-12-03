
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;




class MergeSort {


    static void merge(int arr[], int l, int m, int r){
        

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

           
            int m = l + (r - l) / 2;

            
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

        
            merge(arr, l, m, r);
        }
    }
    static int[] readFile (String fileName) throws Exception {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = br.readLine()) != null) {
            for (String s : line.trim().split("[,\\s]+")) {
                list.add(Integer.parseInt(s));
            }
        }
        br.close();

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;

    }


    public static void main(String args[]){
     try {
         String fileName = "arraytenmil.txt";
         int[] arr = readFile(fileName);
         Runtime run = Runtime.getRuntime();
         System.gc();
         Thread.sleep(50); 
         long memStart = run.totalMemory() - run.freeMemory();

         long timeStart = System.nanoTime();

         mergeSort(arr, 0, arr.length-1);
         System.gc();
         Thread.sleep(50); 
         long timeEnd = System.nanoTime();
         long timeTotal = timeEnd - timeStart;

         long memEnd = run.totalMemory() - run.freeMemory();
         long totalMem = memEnd - memStart;

         System.out.println("Execution time: " + timeTotal + " nanoseconds");
         System.out.println("Memory usage: " + totalMem + " b");




     } catch (Exception e) {
        System.out.println("Warning Error: " + e.getMessage());
     }
    }
}