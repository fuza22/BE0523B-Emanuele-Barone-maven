package org.example.m1.d4;

import jdk.jfr.Category;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Shop {

    public static <Stream> void main(String[] args) {

        Product p1 = new Product(01L, "Libro1", "Books", 110.99);
        Product p2 = new Product(02L, "Libro2", "Books", 112.99);
        Product p3 = new Product(03L, "Libro3", "Books", 99.99);
        Product p4 = new Product(04L, "Pannolini", "Baby", 10.99);
        Product p5 = new Product(05L, "Ciuccio", "Baby", 9.99);
        Product p6 = new Product(06L, "Call of duty", "Boys", 49.99);
        Product p7 = new Product(07L, "Fifa", "Boys", 59.99);


        Customer c1 = new Customer(01L, "Emanuele", 1);
        Customer c2 = new Customer(02L, "Mauro", 2);
        Customer c3 = new Customer(03L, "Emilio", 2);

        LocalDate ld1 = LocalDate.parse(LocalDate.now().toString());


        List<Product> prodotti = List.of(p1, p2, p3, p4, p5, p6, p7);

        List<Product> prodottiFiltrati = prodotti.stream()
                .filter(c -> "Books"
                        .equals(c.getCategory()) && c.getPrice() > 100)
                .collect(Collectors.toList());


        List<Product> prodottiBaby = prodotti.stream()
                .filter(b -> "Baby"
                .equals(b.getCategory()))
                .collect(Collectors.toList());


        Order o1 = new Order(01L, "Open", ld1, ld1, prodottiBaby, c1);

        List<Product> prodottiBoys = prodotti.stream()
                .filter(b -> {
                    if(b.getCategory().equals("Boys")) {
                        b.setPrice((b.getPrice() * 0.9));
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());



        LocalDate feb = LocalDate.of(2021, Month.FEBRUARY, 01);
        LocalDate mar = LocalDate.of(2021, Month.MARCH, 01);
        LocalDate apr = LocalDate.of(2021, Month.APRIL, 01);

        Order o2 = new Order(02L, "Closed", feb, feb, prodottiBoys, c2);
        Order o3 = new Order(03L, "Closed", mar, mar, prodottiBaby, c3);
        Order o4 = new Order(03L, "Closed", apr, apr, prodottiBaby, c1);

        List<Order> listaOrdini = List.of(o1, o2, o3, o4);

        List<Order> ordiniFebApr = listaOrdini.stream()
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021,01,31))
                && o.getOrderDate().isBefore(LocalDate.of(2021, 04,02)) && o.getCustomer().getTier().equals(2))
                .collect(Collectors.toList());


        // MAVEN


        Map<Customer, List<Order>> ordiniPerCliente = listaOrdini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("Ordini per cliente:");
        ordiniPerCliente.forEach((customer, orders) -> {

            System.out.println("Cliente: " + customer.getName());
            orders.forEach(order -> System.out.println("" + order));

        });


        Map<Customer, Double> totalePerCliente = listaOrdini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(order -> order.getProducts()
                                .stream().mapToDouble(Product::getPrice).sum())));

        totalePerCliente.forEach((customer, valore) -> System.out.println("Cliente: " + customer.getName() + " ha speso: " + valore));


        List<Product> prodottiCostosi = prodotti.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Tre prodotti più costosi: ");
        prodottiCostosi.forEach(System.out::println);


        Map<Customer, Double> mediaProdotti = listaOrdini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.averagingDouble(order -> order.getProducts()
                                .stream().mapToDouble(Product::getPrice).sum())));

        mediaProdotti.forEach((customer, valore) -> System.out.println("Cliente: " + customer.getName() + " ha speso in media: " + valore));


        Map<String, Double> totPerCategoria = prodotti.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        totPerCategoria.forEach((categoria, valore) -> System.out.println("Categoria: " + categoria + " valore totale " + valore));
    }



}
