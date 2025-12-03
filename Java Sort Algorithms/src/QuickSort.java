
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class QuickSort {


    static int partition(int[] arr, int low, int high) {
        

        int pivot = arr[high];
        

        int i = low - 1;

   
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
   
        swap(arr, i + 1, high);  
        return i + 1;
    }

    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            

            int pi = partition(arr, low, high);

           
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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

         quickSort(arr, 0, arr.length-1);

         long timeEnd = System.nanoTime();
         long timeTotal = timeEnd - timeStart;
         System.gc();
         Thread.sleep(50);
         long memEnd = run.totalMemory() - run.freeMemory();
         long totalMem = memEnd - memStart;

         System.out.println("Execution time: " + timeTotal+ " nanoseconds");
         System.out.println("Memory usage: " + totalMem + " b");




     } catch (Exception e) {
        System.out.println("Warning Error: " + e.getMessage());
     }
    }
}