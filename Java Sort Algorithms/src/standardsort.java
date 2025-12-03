import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class standardsort {

      static void StandardSort(int arr[]){
        Arrays.sort(arr);
      }

    static int[] readFile (String fileName) throws Exception {
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = br.readLine()) != null) {
            for (String s : line.trim().split("[,\s]+")) {
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

         StandardSort(arr);

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
