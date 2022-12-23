package chucknorris;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String string = storeString();
        convertToBinary(string);
    }

    public static String storeString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        String string = scanner.nextLine();
        return string;
    }

    public static void convertToBinary(String string) {
        System.out.println("The result:");
        for (int i = 0; i < string.length(); i++){
            String binary = String.format("%07d",Integer.parseInt(Integer.toBinaryString(Integer.valueOf(string.charAt(i)))));
            System.out.println(string.charAt(i) +" = " + binary);
        }
    }
}