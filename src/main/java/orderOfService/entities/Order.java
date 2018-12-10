package orderOfService.entities;

import orderOfService.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private LocalDate moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItem = new ArrayList<OrderItem>();


    public Order(LocalDate moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }


    public List<OrderItem> getOrderItem(){
        return orderItem;
    }


    public void addItem(OrderItem item){

        orderItem.add(item);

    }

    public void removeItem (OrderItem item){
        orderItem.remove(item);
    }

    public Double total(){

        Double total = 0.0;

        total = orderItem.stream().mapToDouble(x -> x.subTotal()).sum();

        return total;

    }

    public String toString(){
        StringBuilder st = new StringBuilder();

        st.append("Order moment: ");
        st.append(moment);
        st.append(String.format("%n"));
        st.append("Order Status: ");
        st.append(status);
        st.append(String.format("%n"));
        st.append("Client: ");
        st.append(client.getName());
        st.append("("+ client.getBirthDate() + ")");
        st.append(" - " + client.getEmail());
        st.append(String.format("%n"));
        st.append(String.format("Ordern Items:%n"));
        orderItem.forEach(x -> st.append(String.format(x.toString() + "%n")));
        st.append("Total price: $"+total());

        return st.toString();

    }

}
