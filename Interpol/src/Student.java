import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.*;
import java.util.ArrayList;
/**
 * Created by Сергей on 25.03.2017.
 */

public class Student {
    public static void interpolate() {
        Scanner in = new Scanner(System.in);
        DoubleUnaryOperator f = x -> log(x+4) + x + atan(pow(x,3)) + exp(-x)/100;
        System.out.println("f(x) = ln(x+4) + x + arctg(x^3) + (e^(-x))/100\n");
        System.out.print("Число значений в таблице m+1 = ");
        int s = in.nextInt();
        int m = s-1;
        ArrayList<Double> X = new ArrayList<Double>();
        ArrayList<Double> Y = new ArrayList<Double>();
        ArrayList<Double> Z = new ArrayList<Double>();
        System.out.println("i " + "         x_i       " + "           f_i");
        for (int i = 0; i<=m; i++) {
            X.add(random() * 50);
            Y.add(f.applyAsDouble(X.get(i)));
            System.out.printf(i + "          ");
            System.out.printf("%.6f", + X.get(i));
            System.out.print("           ");
            System.out.printf("%.6f%n", + Y.get(i));
        }
        System.out.println();
        System.out.print("Точка, в которой необходимо вычислить значение функции, x = ");
        double x = in.nextDouble();
        System.out.println();
        System.out.print("Степень интерполяционного многочлена, меньшая либо равная "+ m  +", n = ");
        int n = in.nextInt();
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
        Lagrange.poly(X, Y, f, x, n);
        Newton.poly(X,Y,f,x,n);
    }
}
