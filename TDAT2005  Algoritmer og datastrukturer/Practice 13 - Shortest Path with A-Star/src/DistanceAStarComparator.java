import java.util.Comparator;

public class DistanceAStarComparator implements Comparator<Integer> {
    private int[] distance;
    private int[] actualDistance;

    DistanceAStarComparator(int[] distanceArr, int[] actualDistance) {
        this.distance = distanceArr;
        this.actualDistance = actualDistance;
    }

    @Override
    public int compare(Integer node1, Integer node2) {
        return distance[node1] + actualDistance[node1] - distance[node2] - actualDistance[node2];
    }
}
