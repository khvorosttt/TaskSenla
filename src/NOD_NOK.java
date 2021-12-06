
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class NOD_NOK {

    double number1, number2;

    public NOD_NOK(Scanner in) {
        System.out.println("Введите через пробел два числа");
        String[] data;
        String s;
        try {
            s = in.nextLine();

            if (s.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            s = in.nextLine();
        }
        data = s.split(" ");
        number1 = Integer.parseInt(data[0]);
        number2 = Integer.parseInt(data[1]);
    }

    private double NOD(double number1, double number2) {//нахождение НОД двух чисел
        if (number1 > number2) {
            double temp = number2;
            try {
                number2 = number1 % number2;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            number1 = temp;
            if (number2 != 0) {
                return NOD(number1, number2);
            } else {
                return number1;
            }
        } else {
            double temp = number1;
            try {
                number1 = number2 % number1;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            number2 = temp;
            if (number1 != 0) {
                return NOD(number1, number2);
            } else {
                return number2;
            }
        }
    }

    private double NOK(double number1, double number2) {//Нахождение НОК двух чисел
        return number1 * number2 / NOD(number1, number2);
    }

    public void Output() {
        System.out.println("Наибольший общий делитель чисел " + number1 + " и " + number2 + " равен " + NOD(number1, number2));
        System.out.println("Наименьшее общее кратное чисел " + number1 + " и " + number2 + " равно " + NOK(number1, number2));
    }
}
