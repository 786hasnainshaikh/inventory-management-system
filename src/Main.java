import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){ // created menu
        System.out.println("1.ADD PRODUCT");
        System.out.println("2.SHOW PRODUCT");
        System.out.println("3.ADD CUSTOMER DETAILS");
        System.out.println("4.SHOW CUSTOMER DETAILS");
        System.out.println("5.DELETE PRODUCT");
        System.out.println("6.DELETE CUSTOMER");
        System.out.println("7.EXIT");

    }

    public static void show_product(ArrayList<shop> arr){
        for (shop items: arr) {
            System.out.println("-----------------------------------");
            System.out.println(
                    "product name :" + items.p_name +
                    ", product number: " + items.p_number+
                    ", product price: " + items.p_price
            );
        }
        System.out.println("-----------------------------------");
    } // created show product function which takes array as parameter

    public static void show_cus_details(ArrayList<customer> arr) {
        int index=1;
        for (customer customer: arr) {
            System.out.println("-----------------------------------");
            System.out.println(
                    index + "."+ "customer name: "+ customer.cus_name +
                            ", customer Id: "+ customer.cus_id);
            System.out.println("-----------------------------------");

        }
        index++;
    }  // created show  customers details function which takes an array as parameter

    public static void delete_product(ArrayList<shop> arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the id to delete the product");
        int ID= sc.nextInt();
        try {

            for (shop items: arr) {
                if (ID==items.p_number){
                    arr.remove(items);
                    System.out.println("product has been deleted!!");
                }
            }
        }catch (Exception e){
            System.out.println("deletion successful!!");
        }
    }  // created delete product function which delete product from array takes an array as parameter

    public static void delete_customer(ArrayList<customer> arr){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the customer id to remove ");
        int ID= sc.nextInt();

        try{
            for (customer items: arr) {
                if (ID== items.cus_id){
                    arr.remove(items);
                    System.out.println("customer details deleted!!");
                }
            }
        }catch (Exception e){
            System.out.println("deletion successful");
        }
    } // created delete customer function which delete customer details from array takes an array as parameter




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList <shop> shop = new ArrayList<>();  // created shop array to add shop class details
        ArrayList <customer> customers= new ArrayList<>(); // created customers array to add customers class details

        // shop class variables
        String p_name;
        int p_number;
        int p_price;
        int option;
        // customers variables
        int cus_id;
        String cus_name;

        do {
            menu();
            System.out.println("enter the option");
            option= sc.nextInt();

            switch (option){
                case (1):
                    System.out.println("enter the product name");
                    p_name= sc.next();
                    System.out.println("product name has been added");

                    System.out.println("enter the product id");
                    p_number= sc.nextInt();
                    System.out.println("product number has been added");

                    System.out.println("enter the product price");
                    p_price= sc.nextInt();
                    System.out.println("product price has been added");

                    shop.add(new shop(p_name, p_number, p_price));
                    break;

                case (2):
                    show_product(shop);
                    break;

                case(3):
                    System.out.println("enter the customer Id ");
                    cus_id= sc.nextInt();
                    System.out.println("customer id has been added");

                    System.out.println("enter the customer name ");
                    cus_name= sc.next();
                    System.out.println("customer name has been added");

                    customers.add(new customer(cus_id, cus_name));
                    break;

                case(4):
                    show_cus_details(customers);
                    break;

                case(5):
                    delete_product(shop);
                    break;
                case(6):
                    delete_customer(customers);
                    break;


                case (7):
                    System.exit(0);



            }

        } while (option!=0);


    }
}