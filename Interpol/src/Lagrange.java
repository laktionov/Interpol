import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;

/**
 * Created by Сергей on 24.03.2017.
 */
public class Lagrange {
    public static void poly(ArrayList<Double> array1, ArrayList<Double> array2, DoubleUnaryOperator f, double x, int n) {
        System.out.println("Интерполяционный многочлен в форме Лагранжа:\n");
        double Pn = 0;
        for (int k = 0; k <= n; k++) {
            Pn += dzeta(x, array1, k, n)/dzeta(array1.get(k), array1, k, n) * array2.get(k);
        }
        System.out.println("P_n (x) = "+Pn +" - значение интерполяционного многочлена в искомой точке х");
        System.out.println("ef_n (x) = "+Math.abs(f.applyAsDouble(x) - Pn) +" - фактическая погрешность \n\n");
    }

    public static double dzeta(double x, ArrayList<Double> array, int k, int n) {
        double dzeta = 1;
        for (int i = 0; i <=n; i++) {
            if ((i == k) && (k != n)) {
                i++;
            } else
                if ((i == k) && (k == n)) {
                    break;
                }

            dzeta *= x - array.get(i);
        }
        return dzeta;
    }
}
