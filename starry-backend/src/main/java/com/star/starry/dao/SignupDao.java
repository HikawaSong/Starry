package com.star.starry.dao;

import com.star.starry.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupDao extends JpaRepository<Account,String> {

    boolean existsByName(String name);
}
