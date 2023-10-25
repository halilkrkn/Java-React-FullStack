package org.halilkrkn;

import org.halilkrkn.oopWithLayeredApp.business.ProductManager;
import org.halilkrkn.oopWithLayeredApp.core.log.DatabaseLogger;
import org.halilkrkn.oopWithLayeredApp.core.log.FileLogger;
import org.halilkrkn.oopWithLayeredApp.core.log.Logger;
import org.halilkrkn.oopWithLayeredApp.core.log.MailLogger;
import org.halilkrkn.oopWithLayeredApp.dataAccess.HibernateProductDao;
import org.halilkrkn.oopWithLayeredApp.entities.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Logger> loggers = List.of(new DatabaseLogger(), new FileLogger(), new MailLogger());

        Product product = new Product(1, "Laptop", 30000);
        ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product);
    }
}