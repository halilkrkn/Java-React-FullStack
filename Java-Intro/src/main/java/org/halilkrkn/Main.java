package org.halilkrkn;

import org.halilkrkn.oop.CorporateCustomer;
import org.halilkrkn.oop.Customer;
import org.halilkrkn.oop.IndividualCustomer;
import org.halilkrkn.oop.Product;

public class Main {
    public static void main(String[] args) {

        //Değişken isimlendirmeleri Java'da camelCase tekniğinde yazılır.
        String midText = "İlginizi çekebilir.";
        String subText = "Vade süresi";

        System.out.println("ortaMetin");
        System.out.println(midText);

        int maturity = 12;

        double dollarYesterday = 27.97;
        double dollarToday = 28.01;

        boolean isDollarFall = false;

        String direction = "";

        if (dollarToday < dollarYesterday) {
            direction = "down.svg";
            System.out.println(direction);
        } else if (dollarToday > dollarYesterday) {
            direction = "up.svg";
            System.out.println(direction);
        } else {
            direction = "equal.svg";
            System.out.println(direction);
        }
        //array
        //gerçek hayatta bu veriler databaseden gelir :))

        String[] credits = {"Hızlı Kredi", "Maaşını HalkBank'tan Alanlar", "Mutlu Emekli"};

        //System.out.println(credits[0]);
        //System.out.println(credits[1]);
        //System.out.println(credits[2]);

        for (int i = 0; i < credits.length; i++) {
            System.out.println(credits[i]);
        }

        // **************************** OOP ******************************

        Product product1 = new Product();
        product1.setName("Delonghi Coffee Machine");
        product1.setUnitPrice(7500.00);
        product1.setDiscount(7.0);
        product1.setUnitsInStock(3);
        product1.setImageUrl("sample1.jpeg");

        Product product2 = new Product();
        product2.setName("Smeg Coffee Machine");
        product2.setUnitPrice(6500.00);
        product2.setDiscount(8.0);
        product2.setUnitsInStock(2);
        product2.setImageUrl("sample2.jpeg");

        Product product3 = new Product();
        product3.setName("Kitchen Aid Machine");
        product3.setUnitPrice(4500.00);
        product3.setDiscount(9.0);
        product3.setUnitsInStock(4);
        product3.setImageUrl("sample3.jpeg");

        Product[] products = {product1, product2, product3};

        System.out.println("<ul>");
        for (Product product : products
        ) {
            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhoneNumber("0543222222");
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setFirstName("Oguz Kagan");
        individualCustomer.setLastName("Bati");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setPhoneNumber("05431234433");
        corporateCustomer.setCustomerNumber("123456");
        corporateCustomer.setCompanyName("Acme");
        corporateCustomer.setTaxNumber("4657883");

        Customer[] customers = {individualCustomer, corporateCustomer};
        for (Customer customer : customers) {
            System.out.println(customer.getPhoneNumber());
        }
    }
}
