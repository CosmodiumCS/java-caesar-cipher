import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // scanner "s" object
        Scanner s = new Scanner (System.in);

        while (true) {
            // user input, text
            System.out.print("Enter text : ");
            String text = s.nextLine();

            // user input, option
            System.out.print("\nChoose an option:\n1) Encrypt\n2) Decrypt\n3) Bruteforce\n4) Exit\n\nOption : ");
            int option = s.nextInt();

            // cipher "c" object
            Cipher c = new Cipher(text, option);

            // encrytion option
            if (option == 1) {
                System.out.println(c.translator());
                break;
            }

            // decryption option
            else if (option == 2) {
                System.out.println(c.translator());
                break;
            }
            
            // brutrforce option
            else if (option == 3) {
                System.out.println(c.bruteforce());
                break;
            }
            
            // exit option
            if (option == 4) {
                System.out.println("Exiting...");
                break;
            }
                    
            // exception
            else {
                System.out.println("Input not recognized, Try Again!");
                break;
            }
        }
    }
}
