package currency.methodsStatics;


public class CurrencyConverter {

    private static final double TAX = 0.06;

    public static String Quotation(double dollarPrice, double dollarWanted){

        double valueTax = (dollarPrice * dollarWanted)*TAX;
        double cost =(dollarPrice * dollarWanted)+ valueTax;
        return "Cost: R$"
                +String.format("%.2f",cost)
                +", tax amount of "
                +String.format("%.2f",valueTax);
    }
}
