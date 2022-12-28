package chucknorris;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String string;
        string = storeString();
        //string = convertToBinary(string);
        //string = encryptString(string);
        string = decryptString(string);
        string = convertToString(string);
        printString(string);
    }

    public static String storeString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
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

    public static String convertToString(String string) {
        String[] sevenBitParts = string.split(" ");//create an array of strings of seven each bits
        char[] letters = new char[sevenBitParts.length];//Begin the array with the letter group number.
        for(int i = 0; i < sevenBitParts.length; i ++) {
            letters[i] = (char) (Integer.parseInt(sevenBitParts[i],2));
        }
        string = new String(letters);
        return string;
    }

    public static String decryptString(String string) {
        StringBuilder binaryString = new StringBuilder();
        String decryptArray[];
        String space = " ";
        int count = 0;
        decryptArray = string.split(" ");
        for (int i = 0; i < decryptArray.length - 1; i++) {
            if (decryptArray[i].equals("0")) {
                for(int j = 0; j < decryptArray[i + 1].length(); j ++){
                    binaryString.append("1");
                    count ++;
                    if (count > 6) {
                        binaryString.append(space);
                        count = 0;
                    }
                }
            } else if (decryptArray[i].equals("00")) {
                for(int j = 0; j < decryptArray[i + 1].length(); j ++){
                    binaryString.append("0");
                    count ++;
                    if (count > 6) {
                        binaryString.append(space);
                        count = 0;
                    }
                }
            }
            i++;
        }
        string = binaryString.toString();
        return string;
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

            if (count != 1)
                i += (count - 1);
        }
        encriptedString = sb.toString();
        return encriptedString;
    }

    public static void printString(String string) {
        System.out.println("The result:");
        System.out.println(string);
    }
}