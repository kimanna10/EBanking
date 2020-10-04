package kz.iitu;

import java.util.Scanner;

public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner in = new Scanner(System.in);

        Item item1 = new Item("1111", 300);
        Item item2 = new Item("2222", 600);
        Item item3 = new Item("3333", 100);
        Item item4 = new Item("4444", 320);
        Item item5 = new Item("5555", 240);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);
        cart.addItem(item5);
        int choice = 1;
        while (choice != 0) {
            System.out.println("Choose the type of payment: ");
            System.out.println("1) PayPal");
            System.out.println("2) Credit");
            System.out.println("0) Exit");
            choice = in.nextInt();
            if (choice == 1) {
                String email, pass;
                System.out.println("Enter email: ");
                email = in.next();
                System.out.println("Enter password: ");
                pass = in.next();
                cart.pay(new PaypalStrategy(email, pass));
            }

            if (choice == 2) {
                String name, num, cvv, expDate;
                System.out.println("Enter name: ");
                name = in.next();
                System.out.println("Enter num: ");
                num = in.next();
                System.out.println("Enter cvv: ");
                cvv = in.next();
                System.out.println("Enter expDate (ex. 10/22): ");
                expDate = in.next();
                cart.pay(new CreditCardStrategy(name, num, cvv, expDate));
            }

        }
    }
}