package foo.bar.l4.c2.solution;

import java.util.Arrays;
import java.util.Objects;

class State{
    int node;
    int[] bunnies;

    State(int node, int[] bunnies) {
        this.node = node;
        this.bunnies = bunnies;
    }

    @Override // override equals & hash to store instances of State in a HashMap
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        State state = (State) object;
        return this.node == state.node &&
                Arrays.equals(this.bunnies, state.bunnies);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.node);
        result = 31 * result + Arrays.hashCode(this.bunnies);
        return result;
    }
}
