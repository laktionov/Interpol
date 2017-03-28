import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.*;
import java.util.ArrayList;

/**
 * Created by Сергей on 25.03.2017.
 */
public class Test {
    public static void interpolate() {
        Scanner in = new Scanner(System.in);
        DoubleUnaryOperator g = x -> sin(x) - pow(x,2)/2;
        System.out.println("g(x) = sin(x) - x^2 /2\n");
        System.out.println("Число значений в таблице m+1 = 15");
        int m = 15;
        ArrayList<Double> X = new ArrayList<Double>();
        ArrayList<Double> Y = new ArrayList<Double>();
        ArrayList<Double> Z = new ArrayList<Double>();
        System.out.println("i " + "          x_i        " + "           f_i");
        for (int i = 0; i<=m; i++) {
            X.add((double)i/m);
            Y.add(g.applyAsDouble(X.get(i)));
            System.out.printf(i + "          ");
            System.out.printf("%.6f", + X.get(i));
            System.out.print("           ");
            System.out.printf("%.6f%n", + Y.get(i));
        }
        System.out.println();
        System.out.print("Точка, в которой необходимо вычислить значение функции, x = 0.65");
        double x = 0.65;
        System.out.println();
        System.out.print("Степень интерполяционного многочлена, меньшая либо равная m, n = 7");
        int n = 7;
        System.out.println();
        for (int i = 0; i<=m; i++) {
            Z.add(abs(X.get(i) - x));
        }
        System.out.println("Узлы интерполяции и значения функции в них:");
        Quick.sort(Z, 0, m, X, Y);
        System.out.println("i " + "         x_i       " + "           f_i");
        for (int i = 0; i<=n; i++) {
            System.out.printf(i + "          ");
            System.out.printf("%.6f", + X.get(i));
            System.out.print("           ");
            System.out.printf("%.6f%n", + Y.get(i));
        }
        System.out.println();
        Lagrange.poly(X, Y, g, x, n);
        Newton.poly(X,Y,g,x,n);
    }
}
