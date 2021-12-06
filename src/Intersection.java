
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
public class Intersection {

    String answer;

    public Intersection(Scanner in) {
        Point[] PN = new Point[2];
        Point[] PK = new Point[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Введите координаты точки начала " + (i + 1) + " -го отрезка");
            String[] data;
            String s;
            try {
                s=in.nextLine();
                
                if(s.isEmpty())
                    throw new Exception();
            } catch (Exception e) {
                s=in.nextLine();
            }
            data = s.split(" ");
            PN[i] = new Point(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
            System.out.println("Введите координаты точки конца " + (i + 1) + " -го отрезка");
            try {
                s=in.nextLine();
                
                if(s.isEmpty())
                    throw new Exception();
            } catch (Exception e) {
                s=in.nextLine();
            }
            data = s.split(" ");
            PK[i] = new Point(Double.parseDouble(data[0]), Double.parseDouble(data[1]));
        }
        double[][] equation = new double[2][3];
        for (int i = 0; i < 2; i++) {
            equation[i][0] = PK[i].Y() - PN[i].Y();
            equation[i][1] = PK[i].X() - PN[i].X();
            equation[i][2] = -PN[i].X() * PK[i].Y() + PN[i].Y() * PK[i].X();
        }
        double determinant = Determinant(equation);
        if (determinant != 0) {
            Point M = new Point(-Determinant(Transformation(equation, 0)) / determinant, Determinant(Transformation(equation, 1)) / determinant);
            if (Affiliation(M, PN[0], PK[0]) && Affiliation(M, PN[1], PK[1])) {
                answer = "Отрезки пересекаются";
            } else {
                answer = "Отрезки не пересекаются";
            }
        }
    }

    private double Determinant(double[][] Massiv) {//Определитель матрицы размерности 2
        return Massiv[0][0] * Massiv[1][1] - Massiv[0][1] * Massiv[1][0];
    }

    private double[][] Transformation(double[][] Massiv, int i) {//Преобразования для нахождения нужного определителя
        double[][] temp = new double[2][2];
        for (int j = 0; j < 2; j++) {
            temp[j][0] = Massiv[j][0];
            temp[j][1] = Massiv[j][1];
        }
        temp[0][i] = Massiv[0][2];
        temp[1][i] = Massiv[1][2];
        return temp;
    }

    private boolean Affiliation(Point P1, Point P2, Point P3) {//проверка принадлежности точки пересечения отрезку
        if ((P1.X() - P2.X()) * (P1.X() - P3.X()) + (P1.Y() - P2.Y()) * (P1.Y() - P3.Y()) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void Output() {
        System.out.println(answer);
    }
}
