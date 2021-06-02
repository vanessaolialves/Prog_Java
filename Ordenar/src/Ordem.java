

public class Ordem{

    //Selection Sort
    public void selectionSort(int[] vec, int n){
        int menor;
        for(int i = 0; i < n; i++){
            menor = i;
            for(int j = i+1; j < n; j++){
                if (vec[j] < vec[menor]){
                    menor = j;
                }
            }
            int aux = vec[i];
            vec[i] = vec[menor];
            vec[menor] = aux;
        }
    }

    //Insertion Sort
    public void insetionSort(int[] vec, int n){
        int aux;
        for(int i = 1, j; i < n; i++){
            for(j = i-1, aux = vec[i]; j>= 0 && vec[j] > aux;j--){
                vec[j+1] = vec[j];
            }
            vec[j+1] = aux;
        }
        
    }

    //Bubble Sort
    public void bubbleSort(int[] vec, int n){
        boolean flag = true;
        for(int i = n-1; i > 0 && flag; i--){
            flag = false;
            for(int j = 0; j < i; j++){
                if (vec[j] > vec[j+1]){
                    int aux = vec[j];
                    vec[j] = vec[j+1];
                    vec[j+1] = aux;
                    flag = true;
                }
            }
        }
    }

    //Merge Sort
    public void mergeSort(int[] vec, int n){
        mergeR(vec, 0, n-1);
    }

    private void mergeR(int[] vec, int pi, int pf){
        if (pi < pf){
            int mid = (pi + pf)/2;
            mergeR(vec, pi, mid);
            mergeR(vec, mid+1, pf);
            merge(vec, pi, mid, pf);
        }
    }

    private void merge(int[] vec, int pi, int mid, int pf){
        int n = pf - pi + 1;
        int[] vt = new int[n];
        int i , j, k;
        for (i = pi, j = mid + 1, k = 0; i <= mid && j <= pf; k++){
            if (vec[i] > vec[j]){
                vt[k] = vec[j];
                j++;
            }else{
                vt[k] = vec[i];
                i++;
            }
        }
        for (; i <= mid; i++, k++){
            vt[k] = vec[i];
        }
        for (; j <= pf; j++, k++){
            vt[k] = vec[j];
        }
        for (k-- ; pf >= pi; pf--, k--){
            vec[pf] = vt[k];
        }
    }

    //Quick Sort
    public void quickSort(int [] vec, int n){
        quickR(vec, 0, n-1);
    }

    private void quickR(int [] v, int pi, int pf){
        while (pi < pf){
            int pv = partition(v, pi, pf);
            if (pv - pi < pf - pv) {
                quickR(v, pi, pv-1);
                pi = pv + 1;
            } else {
                quickR(v, pv + 1, pf);
                pf = pv - 1;
            }
        }
    }

    private int partition(int [] v, int pi, int pf){
        int pivot = v[pi], esq, dir;
        for (esq = pi, dir = pf+ 1; esq < dir;){
            do esq++;
            while (esq <= pf && v[esq] < pivot);
            do dir--;
            while (v[dir] > pivot);
            if (esq < dir){
                int aux = v[esq];
                v[esq] = v[dir];
                v[dir] = aux;
            }
        }
        int aux = v[pi];
        v[pi] = v[dir];
        v[dir] = aux;
        return dir;
    }
    
    //Heap Sort
    public void heapSort(int[] vec, int n){
        for (int i = n/2; i > 0; i--){
            maxHeapfy(vec, n, i);
        }
        for (int i = n -1; i > 1; i--){
            int aux = vec[0];
            vec[0] = vec[i];
            vec[i] = aux;
            maxHeapfy(vec, i, 1); 
        }
        int aux = vec[0];
        vec[0] = vec[1];
        vec[1] = aux;
    }

    private void maxHeapfy(int[] v, int n, int f){
        int high = f;
        int left = 2*f;
        int right = 2*f + 1;
        if (left <= n && v[left-1] > v[high-1]){
            high = left;
        }
        if (right <= n && v[right-1] > v[high-1]){
            high = right;
        }
        if (high != f){
            int aux = v[f-1];
            v[f-1] = v[high-1];
            v[high-1] = aux;
            maxHeapfy(v, n, high);
        }
    }

    //Radix Sort e counting Sort
    public void radixSort(int [] vec, int n){
        int pos = getMax(vec, n);
        for (int exp = 1; vec[pos]/exp > 0; exp *= 10){
            countSort(vec, n, exp);
        }
    }

    private int getMax(int [] v, int n){
        int high = 0;
        for (int i = 1; i < n; i++){
            if (v[i] > v[high]){
                high = i;
            }
        }
        return high;
    }

    private void countSort(int [] vec, int n, int exp){
        int [] saida = new int[n];
        int [] conta = new int[10];
        for (int i = 0; i < 10; i++)
            conta[i] = 0;
        for (int i = 0; i < n; i++)
            conta[ (vec[i]/exp)%10 ]++;
        for (int i = 1; i < 10; i++)
            conta[i] += conta[i - 1];
        for (int i = n - 1; i >= 0; i--){
            saida[conta[ (vec[i]/exp)%10 ] - 1] = vec[i];
            conta[ (vec[i]/exp)%10 ]--;
        }
        for (int i = 0; i < n; i++)
            vec[i] = saida[i];
    }
}