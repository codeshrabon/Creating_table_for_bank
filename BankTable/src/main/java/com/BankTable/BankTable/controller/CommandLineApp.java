package com.BankTable.BankTable.controller;

import com.BankTable.BankTable.model.User;
import com.BankTable.BankTable.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLineApp implements CommandLineRunner {


    @Autowired
    private final UserRepository userRepo;
    //private final User user;

    public CommandLineApp(UserRepository userRepo) {
        this.userRepo = userRepo;
        //this.user = user;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Faysal Ahmed");

        System.out.println("Welcome To Bank Table ");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n=== Bank Data Table Menu ===");
            System.out.println("1. Add new user");
            System.out.println("2. Find user");

            System.out.println("3. Show all users");
            System.out.println("4. Update user");
            System.out.println("5. Delete user");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // to have a clear buffer
            switch (choice){
                case 1 -> addUser(scanner);
                case 2 -> findUser(scanner);
                case 3 -> showAllUsers();
                case 4 -> updateUsers(scanner);
                case 5 -> deleteUser(scanner);
                case 6 -> {
                    System.out.println("You have Existing... pop");
                    return;
                }
                default -> System.out.println("Choose the right one dummy!");

            }
        }




    }

    private void findUser(Scanner scanner) {
        //User user = new User();
        System.out.print("Choose the id to find: ");
        long id = scanner.nextInt();
        scanner.nextLine();

        userRepo.findById(id).ifPresentOrElse(
                user -> System.out.println("User fond: " + user),
                () -> System.out.println("User not found with ID: " + id)
        );



    }

    private void deleteUser(Scanner scanner) {
        User user = new User();
        System.out.print("Choose the serial number to delete: ");
        long id = scanner.nextInt();
        scanner.nextLine();

        if (!userRepo.existsById(id)){
            System.out.println("User not exist ..oOR  Not found");
            return;
        }
        userRepo.deleteById(id);
        System.out.println("User deleted");
    }

    // to update the specific user
    private void updateUsers(Scanner scanner) {
       //User user = new User();

        System.out.print("Choose client id you like to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("You choose " + id + " ID to update");
//        Optional<User> user = userRepo.findById(id);
//        System.out.println(userRepo.findById(id));

//        userRepo.findById(id).ifPresentOrElse(
//
//                user -> System.out.println("User fond: " + user),
//
//                () -> System.out.println("User not found with ID: " + id)
//
//        );
//        System.out.println("Update your model " + id);
//        System.out.println("Enter account name :");
//
//        userRepo.getReferenceById(id).setAccount_name(scanner.nextLine());
//
//        System.out.println("Enter Loan account number :");
//        userRepo.getReferenceById(id).setLoan_account_number(scanner.nextLine());

        userRepo.findById(id).ifPresentOrElse(user ->{
            System.out.println("Update user with ID: "+ id);

            System.out.print("Enter account name: ");
            user.setAccount_name(scanner.nextLine());

            System.out.print("Enter loan account number: ");
            user.setLoan_account_number(scanner.nextLine());

            System.out.print("Enter An amount: ");
            user.setAmount(scanner.nextDouble());


            System.out.print("Enter rate of interest: ");
            user.setRate_of_interest(scanner.nextDouble());


            System.out.print("Enter tenure: ");
            user.setTenure(scanner.nextLine());


            System.out.print("Enter type of loan: ");
            user.setType_of_loan(scanner.nextLine());

            System.out.print("Enter eligible security value: ");
            user.setEligible_security_value(scanner.nextDouble());


            System.out.print("Enter security coverage: ");
            user.setSecurity_coverage(scanner.nextInt());

            System.out.print("Enter security details as per sanction: ");
            user.setSecurity_details_as_per_sanction(scanner.nextLine());

            System.out.print("Enter client identification done with varification true/false: ");
            user.setClient_identification_done_with_varification(scanner.hasNextBoolean());

            System.out.print("Enter guarantor identification done with varification true/false: ");
            user.setGuarantor_identification_done_with_varification(scanner.hasNextBoolean());

            System.out.print("Enter fund utilization ensured true/false: ");
            user.setFund_utilization_ensured(scanner.hasNextBoolean());

            System.out.print("Enter single borrower exposure limit: ");
            user.setSingle_borrower_exposure_limit(scanner.nextInt());

            System.out.print("Enter compile with credit policy true/false: ");
            user.setCompliance_with_credit_policy(scanner.hasNextBoolean());

            System.out.print("Enter comment if any: ");
            user.setComments(scanner.nextLine());

            userRepo.save(user);

        }, () -> {
            System.out.println("User not found with ID: " + id);
        });
    }

    //it will show all the users in the database
    private void showAllUsers() {
        List<User> users = userRepo.findAll();

        if (users.isEmpty()){
            System.out.println("No user found");
        }else{
            System.out.println("Here ia all the data: ");
            users.forEach(System.out::println);
        }

    }

    // here you add the user using data
    private void addUser(Scanner scanner) {

        User user = new User();
        System.out.println("Enter user details: ");

        System.out.print("Enter account name: ");
        user.setAccount_name(scanner.nextLine());

        System.out.print("Enter loan account number: ");
        user.setLoan_account_number(scanner.nextLine());

        System.out.print("Enter An amount: ");
        user.setAmount(scanner.nextDouble());


        System.out.print("Enter rate of interest: ");
        user.setRate_of_interest(scanner.nextDouble());


        System.out.print("Enter tenure: ");
        user.setTenure(scanner.nextLine());


        System.out.print("Enter type of loan: ");
        user.setType_of_loan(scanner.nextLine());

        System.out.print("Enter eligible security value: ");
        user.setEligible_security_value(scanner.nextDouble());


        System.out.print("Enter security coverage: ");
        user.setSecurity_coverage(scanner.nextInt());

        System.out.print("Enter security details as per sanction: ");
        user.setSecurity_details_as_per_sanction(scanner.nextLine());

        System.out.print("Enter client identification done with varification true/false: ");
        user.setClient_identification_done_with_varification(scanner.hasNextBoolean());

        System.out.print("Enter guarantor identification done with varification true/false: ");
        user.setGuarantor_identification_done_with_varification(scanner.hasNextBoolean());

        System.out.print("Enter fund utilization ensured true/false: ");
        user.setFund_utilization_ensured(scanner.hasNextBoolean());

        System.out.print("Enter single borrower exposure limit: ");
        user.setSingle_borrower_exposure_limit(scanner.nextInt());

        System.out.print("Enter compile with credit policy true/false: ");
        user.setCompliance_with_credit_policy(scanner.hasNextBoolean());

        System.out.print("Enter comment if any: ");
        user.setComments(scanner.nextLine());

        System.out.println("Model has added successfully");
        userRepo.save(user);


    }
}
