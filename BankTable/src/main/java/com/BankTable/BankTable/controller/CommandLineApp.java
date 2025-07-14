package com.BankTable.BankTable.controller;

import com.BankTable.BankTable.model.User;
import com.BankTable.BankTable.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineApp implements CommandLineRunner {


    private final UserRepository userRepo;

    public CommandLineApp(UserRepository userRepo) {
        this.userRepo = userRepo;
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
                case 1 -> addUser();
                case 2 -> findUser(scanner);
                case 3 -> showAllUsers();
                case 4 -> updateUsers();
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

    private void updateUsers() {
    }

    private void showAllUsers() {
        List<User> users = userRepo.findAll();

        if (users.isEmpty()){
            System.out.println("No user found");
        }else{
            System.out.println("HEre ia all the data: ");
            users.forEach(System.out::println);
        }

    }

    private void addUser() {
    }
}
