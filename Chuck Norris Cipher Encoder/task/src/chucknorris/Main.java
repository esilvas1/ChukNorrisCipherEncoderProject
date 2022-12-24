package chucknorris;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String string;
        string = storeString();
        string = convertToBinary(string);
        string = encryptString(string);
        printString(string);
    }

    public static String storeString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        String string = scanner.nextLine();
        return string;
    }

    public static String convertToBinary(String string) {
        StringBuilder sb = new StringBuilder();
        String binary;
        for (int i = 0; i < string.length(); i++){
            sb.append(String.format("%07d",Integer.parseInt(Integer.toBinaryString(Integer.valueOf(string.charAt(i))))));
        }
        binary = String.valueOf(sb);

        return binary;
    }

    public static String encryptString(String string) {
        StringBuilder sb = new StringBuilder();
        String encriptedString = null;
        String bit = null , nextBit;
        int count;
        for (int i = 0; i < string.length(); i++) {
            count = 0;
            for (int j = i; j < string.length(); j ++) {
                bit = String.valueOf(string.charAt(i));
                nextBit = String.valueOf(string.charAt(j));
                if (bit.equals(nextBit)) count ++;
                else break;
            }

            if (bit.equals("1")) {
                sb.append("0");
                sb.append(" ");
                for (int j = 0; j < count; j++) {
                    sb.append("0");
                }
                sb.append(" ");
            }

            if (bit.equals("0")) {
                sb.append("00");
                sb.append(" ");
                for (int j = 0; j < count; j++) {
                    sb.append("0");
                }
                sb.append(" ");
            }

            if (count != 1) i += (count - 1);
        }
        encriptedString = sb.toString();
        return encriptedString;
    }

    public static void printString(String string) {
        System.out.println("The result:");
        System.out.println(string);
    }
}