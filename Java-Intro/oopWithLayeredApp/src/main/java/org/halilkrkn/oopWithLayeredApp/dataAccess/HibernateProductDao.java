package org.halilkrkn.oopWithLayeredApp.dataAccess;

import org.halilkrkn.oopWithLayeredApp.entities.Product;

// Sadece veritabanı işlemleri yapılır
public class HibernateProductDao implements ProductDao{
    public void add(Product product) {
        System.out.println("Hibernate ile veritabanına ürün eklendi");
    }
}
