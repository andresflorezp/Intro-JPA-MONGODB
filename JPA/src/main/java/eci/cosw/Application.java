package eci.cosw;

import eci.cosw.data.CustomerRepository;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.UserRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        customerRepository.deleteAll();
//
//        customerRepository.save(new Customer("Alice", "Smith"));
//        customerRepository.save(new Customer("Bob", "Marley"));
//        customerRepository.save(new Customer("Jimmy", "Page"));
//        customerRepository.save(new Customer("Freddy", "Mercury"));
//        customerRepository.save(new Customer("Michael", "Jackson"));
//
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Customer customer : customerRepository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
    	
    	userRepository.deleteAll();
    	userRepository.save(new User("Alice", "alice@mail.com"));
    	userRepository.save(new User("Alice2", "alice2@mail.com"));
    	userRepository.save(new User("Alice3", "alice3@mail.com"));
    	userRepository.save(new User("Alice4", "alice4@mail.com"));
    	
    	
    	todoRepository.deleteAll();
    	todoRepository.save(new Todo("Tarea1", 10, "Jan 10 - 1860", "alice@mail.com", "pending"));
    	todoRepository.save(new Todo("Tarea2", 7, "Jan 10 - 2000", "alice2@mail.com", "Inprogress"));
    	todoRepository.save(new Todo("Tarea1", 9, "Jan 10 - 2010", "alice3@mail.com", "pending"));
    	
    	
    	


    }

}