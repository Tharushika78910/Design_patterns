
import java.util.Random;

public class SortingPerformanceDemo {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;

        int[] smallData = generateRandomArray(smallSize);
        int[] largeData = generateRandomArray(largeSize);

        SortContext context = new SortContext();

        System.out.println("===== SMALL DATASET (" + smallSize + " elements) =====");

        testAlgorithm(context, new BubbleSort(), smallData.clone(), "Bubble Sort");
        testAlgorithm(context, new InsertionSort(), smallData.clone(), "Insertion Sort");
        testAlgorithm(context, new QuickSort(), smallData.clone(), "Quick Sort");

        System.out.println("\n===== LARGE DATASET (" + largeSize + " elements) =====");

        testAlgorithm(context, new BubbleSort(), largeData.clone(), "Bubble Sort");
        testAlgorithm(context, new InsertionSort(), largeData.clone(), "Insertion Sort");
        testAlgorithm(context, new QuickSort(), largeData.clone(), "Quick Sort");
    }

    private static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }

    private static void testAlgorithm(SortContext context, SortStrategy strategy, int[] data, String name) {

        context.setSortStrategy(strategy);

        long start = System.nanoTime();

        context.executeSort(data);

        long end = System.nanoTime();

        long duration = end - start;

        System.out.println(name + " time: " + duration + " ns");
    }
}