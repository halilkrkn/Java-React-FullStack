package org.halilkrkn.oopWithLayeredApp.business;

import org.halilkrkn.oopWithLayeredApp.core.log.Logger;
import org.halilkrkn.oopWithLayeredApp.dataAccess.JdbcProductDao;
import org.halilkrkn.oopWithLayeredApp.dataAccess.ProductDao;
import org.halilkrkn.oopWithLayeredApp.entities.Product;

import java.util.List;

// İş Kuralları
public class ProductManager {
    private ProductDao productDao;
    private List<Logger> loggers;

    public ProductManager() {}

    public ProductManager(ProductDao productDao, List<Logger> loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        if (product.getUnitPrice() < 10) {
            throw new Exception("Ürün fiyatı 10'dan küçük olamaz");
        }
//        ProductDao productDao = new JdbcProductDao();
        productDao.add(product);
        for (Logger logger : loggers) {
            logger.log(product.getName());
        }
    }
}
