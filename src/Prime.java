
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
public class Prime {

    List<Integer> prime;

    public Prime(Scanner in) {
        prime = new ArrayList<>();
        System.out.print("Введите верхнюю границу промежутка нахождения простых чисел ");
        int number;
        try {
            number = in.nextInt();
        } catch (Exception e) {
            number = in.nextInt();
        }
        for (int i = 2; i <= number; i++) {
            int amount = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    amount++;
                    break;
                }
            }
            if (amount == 0) {
                prime.add(i);
            }
        }
    }

    public void Output() {
        for (int i : prime) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
