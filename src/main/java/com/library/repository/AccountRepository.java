package com.library.repository;

import com.library.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account,String> {


    @Query("""
            SELECT COUNT(acc.username)
            FROM Account as acc
            WHERE acc.username = :username
            """)
    public Long count(@Param("username") String username);

}
