package com.BankTable.BankTable.repo;
import com.BankTable.BankTable.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository <User,Long>{

    //List<User> findAllById(long );
}
