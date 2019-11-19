import java.util.Comparator;

public class DistanceComparator implements Comparator<Integer> {
    private int[] distance;

    DistanceComparator(int[] distanceArr) {
        this.distance = distanceArr;
    }

    @Override
    public int compare(Integer node1, Integer node2) {
        return distance[node1] - distance[node2];
    }
}
