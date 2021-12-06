
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
public class Palindrome {

    String answer;
    String word;

    public Palindrome(Scanner in) {
        System.out.print("Введите слово, которое необходимо проверить ");
        try {
            word = in.next().toLowerCase();

            if (word.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            word = in.next().toLowerCase();
        }
        boolean label = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                label = false;
                break;
            }
        }
        if (label) {
            answer = " - палиндром";
        } else {
            answer = " - не палиндром";
        }
    }

    public void Output() {
        System.out.println(word + answer);
    }
}
