package org.halilkrkn.oopWithLayeredApp.dataAccess;

import org.halilkrkn.oopWithLayeredApp.entities.Product;

// Sadece veritabanı işlemleri yapılır
public class JdbcProductDao implements ProductDao{
    public void add(Product product) {
        System.out.println("Jdbc ile ürün eklendi");
    }
}
