package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // JPQL ile isme göre filtreleme
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse(c.customerId, c.firstName, c.email) FROM Customer c WHERE c.firstName = :customerFirstName")
    List<GetListCustomerResponse> findByCustomerFirstName(String customerFirstName);

    // JPQL ile Email'e göre filtreleme
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse(c.customerId, c.firstName, c.email) FROM Customer c WHERE c.email = :customerEmail")
    List<GetListCustomerResponse> findByCustomerEmail(String customerEmail);

    // Derived Query ile isme göre filtreleme
    List<Customer> findCustomerDTOByFirstName(String firstName);

    // Derived Query ile Email'e göre filtreleme
    List<Customer> findCustomerDTOByEmail(String email);

    // Business Rule and Validation
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByCustomerId(Integer customerId);
}

