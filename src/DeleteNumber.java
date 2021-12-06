
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
public class DeleteNumber {
    String stroka;
    public DeleteNumber(Scanner in) {
        System.out.print("Введите строку, из которой необходимо удалить цифры ");
            try {
                stroka=in.nextLine();
                
                if(stroka.isEmpty())
                    throw new Exception();
            } catch (Exception e) {
                stroka=in.nextLine();
            }
        for (int i = 0; i < stroka.length(); i++) {
            if (Character.isDigit(stroka.charAt(i))) {
                stroka = stroka.substring(0, i) + stroka.substring(i + 1);
                i--;
            }
        }
    }
    public void Output(){
        System.out.println(stroka);
    }
}
