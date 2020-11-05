package CSE101;


public class SelectionSortRecursive {
    public static void main(String[] args) {
        int[] myList = LinearSearch.createRandomArray(20,50);
        SelectionSort.printArray(myList);
        selectionSort(myList);
        SelectionSort.printArray(myList);
    }
    public static void selectionSort(int[] list){
        selectionSort(list, 0, list.length-1);
    }
    public static void selectionSort(int[] list, int low, int high) {
        if (low < high) {
            int min = list[low];
            int minIndex = low;
            for (int i = low; i < list.length; i++) {
                if (min > list[i]) {
                    min = list[i];
                    minIndex = i;
                }
            }
            list[minIndex] = list[low];
            list[low] = min;
            selectionSort(list, low + 1, high);
        }
    }
}
