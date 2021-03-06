import java.util.Scanner;

public class Cipher {

    // scanner "s" object
    Scanner s = new Scanner (System.in);

    // instance variables
    private String text;
    private int option;
    private int shift_key;

    // constructor
    public Cipher(String initText, int initOption) {
        this.text = initText;
        this.option = initOption;
    }

    // translating method for encryption and decryption
    public String translator() {

        // user input, shift key
        System.out.print("Enter Shift Key : ");
        this.shift_key = s.nextInt();

        // sets up output
        String output_text = "";

        // ciphering process
        for (char character : this.text.toCharArray()) {
            int original_index; 

            // encryption
            if (this.option == 1) {
                // if "character" is lowercase
                if (character >= 'a' && character <= 'z') {
                    original_index = character - 'a';
                    int shifted_index = (original_index + this.shift_key) % 26;
                    char ciphertext = (char)  ('a' + shifted_index);
                    output_text += ciphertext;
                }
                // if "character is uppercase"
                else if (character >= 'A' && character <= 'Z') {
                    // convert to lowercase for ciphering
                    String letter = String.valueOf(character);
                    String lowercase = letter.toLowerCase();
                    char lowercase_letter = lowercase.charAt(0);

                    // generate to new index
                    original_index = lowercase_letter - 'a';

                    // encrypyion algorithm
                    int shifted_index = (original_index + this.shift_key) % 26;

                    // convert back to uppercase
                    char ciphertext = (char)  ('a' + shifted_index);
                    String ciphertext_upper = String.valueOf(ciphertext);
                    ciphertext_upper = ciphertext_upper.toUpperCase();
                    output_text += ciphertext_upper;
                }
                // exception
                else {
                    output_text += character;
                }
            }
        
            // decryption  
            if (this.option == 2) {
                // if "character" is a space
                if (character == ' ') {
                    output_text += ' ';
                }
                // if "character" is lowercase
                else if (character >= 'a' && character <= 'z') {
                    // generate new index
                    original_index = character - 'a';

                    // decryption algorithm
                    int shifted_index = (original_index - this.shift_key) % 26;
                    char plaintext = (char)  ('a' + shifted_index);
                    output_text += plaintext;
                }
                // if "character is uppercase"
                else if (character >= 'A' && character <= 'Z') {
                    // convert to lowercase for ciphering
                    String letter = String.valueOf(character);
                    String lowercase = letter.toLowerCase();
                    char lowercase_letter = lowercase.charAt(0);

                    // generate new index
                    original_index = lowercase_letter - 'a';

                    // decryption algorithm
                    int shifted_index = (original_index - this.shift_key) % 26;

                    // convert back to uppercase
                    char plaintext = (char)  ('a' + shifted_index);
                    String plaintext_upper = String.valueOf(plaintext);
                    String plaintext_output = plaintext_upper.toUpperCase();
                    output_text += plaintext_output;
                }
                // exception
                else {
                    output_text += character;
                }
            }
        }
        return output_text;
    }

    // bruteforcing method
    public String bruteforce() {

        // sters up output
        String bruteforced_text = "";

        // iterates each key
        for (int shift = 1; shift <= 26; shift++) {
            String output_text = "";

            // decrypt using each key
            for (char character : this.text.toCharArray()) {

                int original_index;

                // if "character" is a space
                if (character == ' ') {
                    output_text += ' ';
                }
                // if "character" is lowercase
                else if (character >= 'a' && character <= 'z') {
                    // generate new index
                    original_index = character - 'a';

                    // decryption algorithm
                    int shifted_index = (original_index - shift) % 26;
                    char plaintext = (char)  ('a' + shifted_index);
                    output_text += plaintext;
                }
                // if "character is uppercase"
                else if (character >= 'A' && character <= 'Z') {
                    // convert to lowercase for ciphering
                    String letter = String.valueOf(character);
                    String lowercase = letter.toLowerCase();
                    char lowercase_letter = lowercase.charAt(0);

                    // generate new index
                    original_index = lowercase_letter - 'a';

                    // decryption algorithm
                    int shifted_index = (original_index - shift) % 26;

                    // convert back to uppercase
                    char plaintext = (char)  ('a' + shifted_index);
                    String plaintext_upper = String.valueOf(plaintext);
                    String plaintext_output = plaintext_upper.toUpperCase();
                    output_text += plaintext_output;
                }
                // exception
                else {
                    output_text += character;
                }
            }
            bruteforced_text += "\nShift of "+shift+":\n"+output_text+"\n";
        }
        return bruteforced_text;
    }

}
