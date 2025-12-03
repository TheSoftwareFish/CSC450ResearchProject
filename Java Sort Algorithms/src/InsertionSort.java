import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class InsertionSort {

    void InsertSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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

         InsertionSort sort = new InsertionSort();
         sort.InsertSort(arr);

         System.gc();
         Thread.sleep(50); 
         long timeEnd = System.nanoTime();
         long timeTotal = timeEnd - timeStart;

         long memEnd = run.totalMemory() - run.freeMemory();
         long totalMem = memEnd - memStart;

         System.out.println("Execution time: " + timeTotal + " nanoseconds");
         System.out.println("Memory usage: " + totalMem + "b");




     } catch (Exception e) {
        System.out.println("Warning Error: " + e.getMessage());
     }
    }
}