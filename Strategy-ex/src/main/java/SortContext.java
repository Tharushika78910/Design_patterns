
public class SortContext {

    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void executeSort(int[] array) {

        if (sortStrategy == null) {
            throw new IllegalStateException("Sorting strategy not set.");
        }

        sortStrategy.sort(array);
    }
}