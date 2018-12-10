package orderOfService.application;

import orderOfService.entities.Client;
import orderOfService.entities.Order;
import orderOfService.entities.OrderItem;
import orderOfService.entities.Product;
import orderOfService.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.stream.IntStream;

public class OrderOfService {

    private static Scanner scan = new Scanner(System.in);
    private static Order order;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void orderOfService() {


        System.out.println("Enter cliente data:");

        System.out.print("Name: ");
        Client client = new Client();
        client.setName(scan.nextLine());

        System.out.print("Email:");
        client.setEmail(scan.nextLine());

        System.out.print("Birth date (DD/MM/YYYY): ");

        client.setBirthDate(LocalDate.parse(scan.nextLine(), formatter));

        System.out.println("Enter order data:");

        System.out.print("STATUS: ");
        OrderStatus status = OrderStatus.valueOf(scan.nextLine());

        order = new Order(LocalDate.now(),status,client);


        System.out.println("How many items to this order? ");
        int itens = scan.nextInt();
        IntStream.range(0, itens).forEach(x -> order.addItem(addItem()));

        System.out.println("ORDER SUMMARY:");

        System.out.printf(order.toString());


        scan.close();
    }



    public static OrderItem addItem() {
        Product product = new Product();
        System.out.printf("Enter #%d item data:", order.getOrderItem().size() + 1);
        System.out.println();

        System.out.print("Product name: ");
        product.setName(scan.next());

        System.out.print("Product price: ");
        product.setPrice(scan.nextDouble());
        System.out.print("Quantity:");
        int quantidade = scan.nextInt();

        return new OrderItem(quantidade,product.getPrice(),product);
    }
}
