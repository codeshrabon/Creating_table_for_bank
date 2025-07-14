package com.BankTable.BankTable.controller;

import com.BankTable.BankTable.model.User;
import com.BankTable.BankTable.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }


    @GetMapping("findById/{id}")
    public ResponseEntity<User> gerUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return  userRepository.save(user);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User updateUser){

        return  userRepository.findById(id).map(user -> {
            user.setAccount_name(updateUser.getAccount_name());
            user.setLoan_account_number(updateUser.getLoan_account_number());
            user.setDisbursment_date(updateUser.getDisbursment_date());
            user.setAmount(updateUser.getAmount());
            user.setRate_of_interest(updateUser.getRate_of_interest());
            user.setTenure(updateUser.getTenure());
            user.setType_of_loan(updateUser.getType_of_loan());
            user.setEligible_security_value(updateUser.getEligible_security_value());
            user.setSecurity_coverage(updateUser.getSecurity_coverage());
            user.setSecurity_details_as_per_sanction(updateUser.getSecurity_details_as_per_sanction());
            user.setClient_identification_done_with_varification(updateUser.isClient_identification_done_with_varification());
            user.setGuarantor_identification_done_with_varification(updateUser.isGuarantor_identification_done_with_varification());
            user.setFund_utilization_ensured(updateUser.isFund_utilization_ensured());
            user.setSingle_borrower_exposure_limit(updateUser.getSingle_borrower_exposure_limit());
            user.setCompliance_with_credit_policy(updateUser.isCompliance_with_credit_policy());
            user.setComments(updateUser.getComments());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        if (!userRepository.existsById(id)) return ResponseEntity.notFound().build();
        userRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}
