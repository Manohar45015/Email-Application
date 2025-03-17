package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your first and last name:");
        Email em1 = new Email(sc.next(), sc.next());

        System.out.println("\nSelect one option:");
        System.out.println("1. Set alternate email");
        System.out.println("2. Check password");
        System.out.println("3. Get mailbox capacity");
        System.out.println("4. Get your information");

        int op = sc.nextInt();

        if (op == 1) {
            System.out.println("Enter your alternate email:");
            String em2 = sc.next();
            em1.setAltEmail(em2);
            System.out.println("Alternate email set to: " + em1.getAltEmail());

        } else if (op == 2) {
            System.out.println("Your password is: " + em1.getPassword());

        } else if (op == 3) {
            System.out.println("Mailbox capacity: " + em1.getMailboxCapacity() + " MB");

        } else if (op == 4) {
            System.out.println("Your information:\n" + em1.showInfo());

        } else {
            System.out.println("Invalid option. Please try again.");
        }

        sc.close();
    }
}
