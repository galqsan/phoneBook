import java.util.Comparator;

public class Sorting implements Comparator<Pair> {

    public int compare(Pair o1, Pair o2) {
        return o2.getCount() - o1.getCount();
    }
}
