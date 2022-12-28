import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String stringAsc = scanner.nextLine();
        String stringDesc = "";
        for (int i = stringAsc.length() - 1 ; i >= 0 ; i--) {
            stringDesc = stringDesc + stringAsc.charAt(i);
        }

        if (stringAsc.equals(stringDesc)) System.out.println("yes");
        else System.out.println("no");

    }
}