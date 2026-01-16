import java.util.Scanner;
import java.io.PrintWriter;

public class ScannerPrinterWriter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.println();

        System.out.println("Enter age: ");
        int age = scan.nextInt();
        System.out.println();

        System.out.println(
            String.format("Your name is %s and your age is %d.", name, age)
        );

        System.out.println();

        scan.close();

        PrintWriter pWriter = new PrintWriter(System.out);

        pWriter.printf("Your name is %s.", name);
        pWriter.println();
        pWriter.printf("Your age is %d.", age);

        pWriter.flush();

        pWriter.close();
    }
}
