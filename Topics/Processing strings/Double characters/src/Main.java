import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String str = "";
        for (int i = 0; i < string.length(); i++) {
            str = str + string.charAt(i) + string.charAt(i);
        }
        System.out.println(str);
    }
}
