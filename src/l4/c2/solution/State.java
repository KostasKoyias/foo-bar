package l4.c2.solution;

import java.util.Arrays;

class State implements Comparable<State> {
    int node;
    int[] bunnies;

    State(int node, int[] bunnies) {
        this.node = node;
        this.bunnies = bunnies;
    }

    @Override
    public String toString() {
        return "State{node = " + node +
                ", bunnies=" + Arrays.toString(bunnies) + '}';
    }

    @Override // give priority to the state with the most bunnies
    public int compareTo(State state) {
        return state.bunnies.length - this.bunnies.length;
    }
}
