import java.util.ArrayList;
import java.util.List;
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
public class Fibonacci {
    List<Integer> f;

    public Fibonacci(Scanner in) {
        f = new ArrayList<>();
        System.out.print("Введите верхнюю границу промежутка нахождения чисел Фибоначчи ");
        f.add(1);
        int N;
        try {
            N = in.nextInt();
        } catch (Exception e) {
            N = in.nextInt();
        }
        Recursion(f, N);
    }
    private List<Integer> Recursion(List<Integer> f, int N) {//рекурсивный алгоритм нахождения чисел Фибоначчи
        if (f.get(f.size() - 1) > N) {
            f.remove(f.size() - 1);
            return f;
        } else {
            if (f.size() == 1) {
                f.add(1);
            } else {
                f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
            }
            return Recursion(f, N);
        }
    }
    public void Output(){
        for (int i : f) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
