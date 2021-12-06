/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in, "Cp1251");
        try {
            DeleteNumber d = new DeleteNumber(in);
            d.Output();
        }
        catch (ArithmeticException | NumberFormatException|StackOverflowError e) {
            System.out.println(e.getMessage());
        } catch (OutOfMemoryError | Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
