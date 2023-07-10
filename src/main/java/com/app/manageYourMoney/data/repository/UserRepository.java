package com.app.manageYourMoney.data.repository;

import com.app.manageYourMoney.data.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer> {
}
