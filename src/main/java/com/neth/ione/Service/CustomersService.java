package com.neth.ione.Service;

import com.neth.ione.Model.Customers;
import com.neth.ione.Repository.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepo customersRepo;

    // save or update
    public Customers saveCustomers(Customers customers) {
        return customersRepo.save(customers);
    }

    public List<Customers> getAllCustomers(){
        return customersRepo.findAll();
    }

    public Customers getCustomerById(int id) {
        return customersRepo.findById(id).orElse(null);
    }


    //delete by id
    public void deleteCustomer(int id){
        customersRepo.deleteById(id);
    }
}
