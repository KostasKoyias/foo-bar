package l4.c2.solution;

import java.util.Arrays;

class State implements Comparable<State> {
    int node;
    int pathCost;
    int[] bunnies;

    State(int node, int pathCost, int[] bunnies) {
        this.node = node;
        this.pathCost = pathCost;
        this.bunnies = bunnies;
    }

    @Override
    public String toString() {
        return "State{node = " + node +
                ", pathCost=" + pathCost +
                ", bunnies=" + Arrays.toString(bunnies) + '}';
    }

    @Override
    public int compareTo(State state) {
        return state.pathCost - this.pathCost;
    }
}
