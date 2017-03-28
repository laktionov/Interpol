import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;

/**
 * Created by Сергей on 24.03.2017.
 */
public class Newton {
    public static void poly(ArrayList<Double> array1, ArrayList<Double> array2, DoubleUnaryOperator f, double x, int n) {
        System.out.println("Интерполяционный многочлен в форме Ньютона:\n");
        System.out.println("Таблица разделенных разностей");
        ArrayList<ArrayList<Double>> D = new ArrayList<>();
        D.add(array1);
        D.add(array2);
        for (int k = 2; k <= n+1; k++){
            Divideddifferences(array1, array2, D, n, k);
        }
        int k = 0;
        for (int i = 0; i <= n; i++) {
            System.out.print(i +" ");
            for (int j = 0; j <= n-k+1; j++){
                System.out.printf("%.12f", + (D.get(j)).get(i));
                System.out.print("    ");
            }
            k++;
            System.out.println();
        }

        double Pn = 0;
        double omega = 1;
        for (int i = 0; i <= n; i++) {
            Pn += ((D.get(i+1)).get(0))*omega;
            omega *= x - (D.get(0)).get(i);

        }
        System.out.println("P_n (x) = "+Pn +" - значение интерполяционного многочлена в искомой точке х");
        System.out.println("ef_n (x) = "+Math.abs(Pn - f.applyAsDouble(x)) +" - фактическая погрешность");
    }

    ArrayList<Double[]> D = new ArrayList<>();
    public static void Divideddifferences(ArrayList<Double> array1, ArrayList<Double> array2, ArrayList<ArrayList<Double>> D, int n, int k) {
        ArrayList<Double> A = new ArrayList<>();
        for (int i = 0; i <= n-k+1; i++) {
            A.add(((D.get(k-1)).get(i+1) - (D.get(k-1)).get(i))/(array1.get(i+k-1) - array1.get(i)));
        }
        D.add(A);
    }
}
