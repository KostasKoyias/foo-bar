package l4.c2.solution;

class State{
    int node;
    int pathCost;
    int[] bunnies;

    State(int node, int pathCost, int[] bunnies) {
        this.node = node;
        this.pathCost = pathCost;
        this.bunnies = bunnies;
    }
}
