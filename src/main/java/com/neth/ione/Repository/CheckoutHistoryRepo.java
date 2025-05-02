package com.neth.ione.Repository;

import com.neth.ione.Model.CheckoutHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutHistoryRepo extends JpaRepository<CheckoutHistory, Long> {
}
