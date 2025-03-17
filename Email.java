package emailapp;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String alternateEmail;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String email;
    private String companySuffix = "anycompany.com";

    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Email created: " + this.firstname + " " + this.lastname);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + 
                (department.isEmpty() ? "" : department + ".") + companySuffix;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n0 for None\nEnter the department:");
        Scanner in = new Scanner(System.in);

        int depchoice = in.nextInt();

        if (depchoice == 1) {
            return "sales";
        } else if (depchoice == 2) {
            return "development";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%&";
        char[] passwords = new char[length];

        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passSet.length());
            passwords[i] = passSet.charAt(rand);
        }
        return new String(passwords);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAltEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstname + " " + lastname + "\n" +
               "COMPANY EMAIL: " + email + "\n" +
               "MAILBOX CAPACITY: " + mailboxCapacity + " MB\n" +
               "ALTERNATE EMAIL: " + (alternateEmail != null ? alternateEmail : "Not Set");
    }
}
