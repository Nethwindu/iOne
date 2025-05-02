package com.neth.ione.Service;

import com.neth.ione.Model.CheckoutHistory;
import com.neth.ione.Model.Customers;
import com.neth.ione.Repository.CheckoutHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class CheckoutHistoryService {
    @Autowired
    private CheckoutHistoryRepo historyRepo;

    public void saveCheckout(double grandTotal, double amountPaid, double balance, Customers customer, LocalDateTime time) {
        CheckoutHistory h = new CheckoutHistory();
        h.setGrandTotal(grandTotal);
        h.setAmountPaid(amountPaid);
        h.setBalance(balance);
        h.setCustomer(customer);
        h.setCheckoutTime(time);
        historyRepo.save(h);
    }

}
