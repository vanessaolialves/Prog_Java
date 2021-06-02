import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Ordem c = new Ordem();
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[] vec = new int[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            vec[i] = read.nextInt();
        }
        for (int k = 0; k < 7; k++){
            for(int i = 0; i < n; i++){
                arr[i] = vec[i];
            }
            switch (k) {
                case 0:
                    c.selectionSort(arr, n);
                    break;

                case 1:
                    c.insetionSort(arr, n);
                    break;

                case 2:
                    c.bubbleSort(arr, n);
                    break;
                
                case 3:
                    c.mergeSort(arr, n);
                    break;
                
                case 4:
                    c.quickSort(arr, n);
                    break;

                case 5:
                    c.heapSort(arr, n);
                    break;
            
                default:
                    c.radixSort(arr, n);
                    break;
            }
            for(int i = 0; i < n; i++){
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
        }
        
    }
}
