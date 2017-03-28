import java.util.Scanner;

/**
 * Created by Сергей on 23.03.2017.
 */

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Задача алгебраического интерполирования.\n" +
                "Интерполяционный многочлен в форме Ньютона и в форме Лагранжа\n");
        System.out.print("Введите номер задачи: ");
        int i = in.nextInt();
        if (i == 1) {
            Student.interpolate();
        }
        if (i == 2) {
            Test.interpolate();
        }
    }
}
