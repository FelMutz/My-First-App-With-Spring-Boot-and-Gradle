package currency.application;



import currency.methodsStatics.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;


public class Currency {
    public static void currency() {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);


        System.out.print("What is the price of the currency you want?");
        double dollarPrice = scan.nextDouble();
        System.out.print("How much money will be bought?");
        double dollarWanted = scan.nextDouble();


        System.out.printf(CurrencyConverter.Quotation(dollarPrice,dollarWanted));
        scan.close();
    }
}
