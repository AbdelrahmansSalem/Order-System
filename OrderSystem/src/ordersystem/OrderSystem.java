/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystem;

import java.util.Scanner;

/**
 *
 * @author abdel
 */
public class OrderSystem {

    static int counter = 0; // a variable it counts orders every time you make a order increase one to can store orders in arrays
    static int TypeOfOrder; //a data type store number of list you want to order from 
    static String[] PizzaMenu = {
        "KFC CHICKEN PIZZA", "MARGHERITA", "SUPER SUPREME", "CLASSIC PEPPERONI",
        "CHEESE LOVERS", "CHICKEN SUPREME", "VEGETARIAN", "SPICY CHICKEN RANCH",
        "SEA FOOD LOVERS", "HOT N SPICYHOT N SPICY", "PRAWN"
    };
    static double[] PizzaPricese = {
        102, 64.50, 92.50, 78.50, 107, 92.50, 78.50, 99, 114.50, 78.50, 107
    };
    static String[] DrinksMenu = {
        "PEPSI", "7 UP", "DIET PEPSI", "MIRINDA", "MINERAL WATER"
    };

    static double[] DrinksPricese = {
        /*price of pepsi */13,
        /*price of 7 up */ 13,
        /*price of diet pepsi */ 13,
        /*price of mirinda */ 13,
        /*price of mineral water */ 8
    };

    static String[] DessertsMenu = {
        "CINNAPARTS", "CHOCO PARTS"
    };

    static double[] DessertsPricese = {
        27, 30.50
    };

    static String[] StartersMenu = {
        "KRISS CUT FRIES", "POTATO WEDGES", "CHICKEN BBQ SPIN ROLLS", "TRIO"
    };

    static double[] StartersPricese = {
        30, 27, 34.50, 75
    };

    static String[] SaladsMenue = {
        "SALAD BAR"
    };

    static double[] SaladsPricese = {
        43.50
    };

    static String[] PastaMenu = {
        "LASAGNA"
    };

    static double[] PastaPricese = {
        47
    };

/*to store type of the order*/    static String[] Order = new String[100];
/*to Store price of last order add */   static double[] Order_Price = new double[100];
/*to store number of order */    static int[] Order_Num = new int[100];

    public static void Choissese() {
        System.out.println("ENTER 1 TO PIZZA LIST\n");
        System.out.println("ENTER 2 TO DESSERTS LIST\n");
        System.out.println("ENTER 3 TO STATRTERS LIST\n");
        System.out.println("ENTER 4 TO SALAD LIST\n");
        System.out.println("ENTER 5 TO PASTA LIST\n");
        System.out.println("ENTER 6 TO DRINKS LIST\n");
    }
//method display the menu whatever it's pizza or dessert or any thing  
    public static void Displaymenu() {

        Scanner s = new Scanner(System.in);

        System.out.print("LIST NUMBER:");
        if (s.hasNextInt()) {
            int input = s.nextInt();
            //evert time you what to display lis it store in typeoforder to use in later
            TypeOfOrder = input;
            if (input == 1) {
                for (int i = 0; i < PizzaMenu.length; i++) {
                    System.out.printf("%d.%s\n    MEDIUM %.2f EGP \n", (i + 1), PizzaMenu[i], PizzaPricese[i]);

                }
            } else if (input == 2) {
                for (int i = 0; i < DessertsMenu.length; i++) {
                    System.out.printf("%d. %s\n    %.2f EGP \n", (i + 1), DessertsMenu[i], DessertsPricese[i]);
                }
            } else if (input == 3) {
                for (int i = 0; i < StartersMenu.length; i++) {
                    System.out.printf("%d. %s\n    %.2f EGP \n", (i + 1), StartersMenu[i], StartersPricese[i]);
                }

            } else if (input == 4) {
                for (int i = 0; i < SaladsMenue.length; i++) {
                    System.out.printf("%d. %s\n    %.2f EGP \n", (i + 1), SaladsMenue[i], SaladsPricese[i]);

                }

            } else if (input == 5) {
                for (int i = 0; i < PastaMenu.length; i++) {
                    System.out.printf("%d. %s\n    %.2f EGP \n", (i + 1), PastaMenu[i], PastaPricese[i]);
                }

            } else if (input == 6) {
                for (int i = 0; i < DrinksMenu.length; i++) {
                    System.out.printf("%d. %s\n    %.2f EGP \n", (i + 1), DrinksMenu[i], DrinksPricese[i]);

                }

            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                Displaymenu();

            }
        } else {
            System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
            Displaymenu();
        }
    }
//method make you order from pizza list only 
    public static void PizzaOrder() {

        Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER A NUMBER BETWEEN 1 TO 11");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 12) {
                    Order[counter] = PizzaMenu[order - 1];
                    Order_Price[counter] = PizzaPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        PizzaOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                PizzaOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }
//method make you order from Dessert list only 
    public static void DessertOrder() {

         Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER A NUMBER BETWEEN 1 TO 2");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 3) {
                    Order[counter] = DessertsMenu[order - 1];
                    Order_Price[counter] = DessertsPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number 
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        DessertOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                DessertOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }
//method make you order from starter list only 
    public static void StarterOrder() {

         Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER A NUMBER BETWEEN 1 TO 4");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 5) {
                    Order[counter] = StartersMenu[order - 1];
                    Order_Price[counter] = StartersPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        StarterOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                StarterOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }
//method make you order from salad list only 
    public static void SaladOrder() {

        Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER NUMBER 1");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 2) {
                    Order[counter] = SaladsMenue[order - 1];
                    Order_Price[counter] = SaladsPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        SaladOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                SaladOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }
//method make you order from pasta list only 
    public static void PastaOrder() {

         Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER NUMBER 1");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 2) {
                    Order[counter] = PastaMenu[order - 1];
                    Order_Price[counter] = PastaPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        PastaOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                PastaOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }
//method make you order from Drinks list only 
    public static void DrinksOrder() {

         Scanner s = new Scanner(System.in);

        int Continue = 1;

        y:while (Continue == 1) {

            System.out.println("ENTER A NUMBER BETWEEN 1 TO 5");
            System.out.print("YOUR ORDER:");
            if (s.hasNextInt()) {
                int order = s.nextInt();
                if (order > 0 && order < 6) {
                    Order[counter] = DrinksMenu[order - 1];
                    Order_Price[counter] = DrinksPricese[order - 1];

                } else {
                    System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                    continue y;
                }

                x:
                while (Continue == 1) {

                    System.out.print("NUMER OF ORDER:");
                    if (s.hasNextInt()) {
                        int num = s.nextInt();
                        if (num > 10 || num < 1) {
                            System.out.println("YOU CAN'T ORDER THIS NUMBER YOUR MAX IS 10 AT ONCE");
                            continue x;
                        } else {
                            Order_Num[counter] = num;
                            Continue = 0;
                            System.out.print("TO ORDER SOMETHING ELSE ENTER 1 TO QUIT ENTER ANYTHING: ");
                        }
                    } else {
                        //if you enter a Sring value it will make you enter values from order not just enter the number
                        System.out.println("YOU ENTERED A WRONG VALUE,PLEASE TRY AGAIN FROM THE BEGINNING");
                        DrinksOrder();
                    }
                    Continue = 0;
                }
            } else {
                System.out.println("YOU ENTERED A WRONG VALUE,PLEASE ENTER CORRECT CHOISSE");
                DrinksOrder();
            }

            if (s.hasNextInt()) {
                Continue = s.nextInt();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                }
            } else {
                break;
            }

        }
    }

    public static void MakeOrder() {
        Scanner s = new Scanner(System.in);
        Choissese();
        int Continue = 1;
        y:
        while (Continue == 1) {
            Displaymenu();
            if (TypeOfOrder == 1) {
                PizzaOrder();
            } else if (TypeOfOrder == 2) {
                DessertOrder();
            } else if (TypeOfOrder == 3) {
                StarterOrder();
            } else if (TypeOfOrder == 4) {
                SaladOrder();
            } else if (TypeOfOrder == 5) {
                PastaOrder();
            } else if (TypeOfOrder == 6) {
                DrinksOrder();
            }
            System.out.println();
            System.out.print("DO YOU WANT ORDER SOOMETHING ELSE FOR YES ENTER 1 FOR NO ENTER ANYTHING: ");
            
            if (s.hasNextInt()) {
                Continue = s.nextInt();
                System.out.println();
                if (Continue != 1) {
                    break;
                } else {
                    counter++;
                    Choissese();
                }
            } else {
                break;
            }
        }
    }

    public static void PrintReceipt() {
        double TotalPrice = 0;
        for (int i = 0; i < Order.length; i++) {
            //if condition because i make size of array 100 and if you didn't order 100 order it just print what you order not a null value
            if (Order[i] != null) {
                System.out.printf("\nYOU ORDERED %d %s   %.2f EGP \n", Order_Num[i], Order[i], (Order_Price[i] * Order_Num[i]));
                //ever time you print price of order it's get sum with each  oreder to display the final price
                TotalPrice += (Order_Price[i] * Order_Num[i]);
            } else {
                break;
            }
        }
        System.out.println("TOTAL PRICE IS " + TotalPrice);

    }

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tWELCOME TO PIZZAHUT");
        MakeOrder();
        PrintReceipt();
//when you check the output check cerfully because you may be don't see some thing then you thought there is some thing wrong

    }
}




//        /*price of KFC CHICKEN PIZZ*/66, 102, 137,
//        /*price of MARGHERITA */ 34.50, 64.50, 90,
//        /*price of SUPER SUPREME */ 60.99, 92.50, 122.00,
//        /*price of CLASSIC PEPPERONI */ 49, 78.50, 107.00,
//        /*price of CHEESE LOVERS */ 74.50, 107, 138,
//        /*price of CHICKEN SUPREME */ 60.99, 92.50, 122,
//        /*price of VEGETARIAN */ 49, 78.50, 107,
//        /*price of SPICY CHICKEN RANCH */ 64, 99.50, 113.16,
//        /*price of SEA FOOD LOVERS */ 78.50, 114.50, 125.88,
//        /*price of HOT N SPICYHOT N SPICY */ 49, 78.50, 107,
//        /*price of PRAWN */ 74.50, 107, 138
