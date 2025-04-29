package com.neth.ione.Repository;

import com.neth.ione.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {
}
