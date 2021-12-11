package Home_work4;

public class FunctionTriangle {
    public static double sTriangle(int a, int b, int c) {
        double p = ((double) a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
