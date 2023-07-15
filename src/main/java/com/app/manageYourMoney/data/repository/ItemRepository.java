package com.app.manageYourMoney.data.repository;

import com.app.manageYourMoney.data.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDetails,Integer> {
}
