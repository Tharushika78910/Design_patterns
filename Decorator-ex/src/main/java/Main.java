
public class Main {

    public static void main(String[] args) {

        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(
                new XMLPrinter(
                        new BasicPrinter()
                )
        );

        printer2.print("Hello World!");

        String encrypted = EncryptedPrinter.encrypt("<message>Hello World!</message>");
        System.out.println("Decrypted example: " + EncryptedPrinter.decrypt(encrypted));
    }
}
