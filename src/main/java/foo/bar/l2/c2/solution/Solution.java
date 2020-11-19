package foo.bar.l2.c2.solution;

class Fraction {
    protected int numerator;            
    protected int denominator;

    // copy-constructor
    public Fraction(Fraction fraction){
        this.numerator = fraction.numerator;
        this.denominator = fraction.denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // euclidean algorithm finding the gcd of 2 numbers
    private int gcd(){
        int a = this.numerator, b = this.denominator, tmp;
        while(b > 0){
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
    
    public int toInt(){
        return this.numerator/this.denominator;
    }

    public void reduce() {
        int div = gcd();
        if (div != 0) {
            numerator /= div;
            denominator /= div;
        }
    }

}

public class Solution{

    public static int[] solution(int[] pegs){
        boolean even;
        int sum, j;
        Fraction firstGearRadius, radius; 

        // handle edge cases
        if(pegs == null || pegs.length == 1)
            return new int[]{-1, -1};

        even = pegs.length % 2 == 0;
        sum = even ? -pegs[0] + pegs[pegs.length - 1] : -pegs[0] - pegs[pegs.length - 1];

        if(pegs.length > 2)
            for(int i = 1; i < pegs.length - 1; i++)
                sum += 2 * (i % 2 != 0 ? 1 : -1) * pegs[i];


        // represent radius in the most simplified form of (numerator, denominator)
        // get the radius for the 1st gear so that the last has half that radius
        firstGearRadius = new Fraction(2 * sum, even ? 3 : 1);
        firstGearRadius.reduce();

        // estimate the radius of every next gear
        for(j = 0, radius = new Fraction(firstGearRadius); j < pegs.length-2; j++){
            int centerDistance = pegs[j + 1] - pegs[j];
            int numerator = centerDistance * radius.denominator - radius.numerator;
            Fraction nextRadius = new Fraction(numerator, radius.denominator);

            // if some radius is not valid then the task is impossible
            if(nextRadius.toInt() < 1 || radius.toInt() < 1)
                return new int[]{-1, -1};
            else
                radius = nextRadius;
        }

        return new int[]{firstGearRadius.numerator, firstGearRadius.denominator};
    }
}