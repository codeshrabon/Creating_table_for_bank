package com.BankTable.BankTable.repo;
import com.BankTable.BankTable.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{

}
