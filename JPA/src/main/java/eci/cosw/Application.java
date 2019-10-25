package eci.cosw;

import eci.cosw.configuration.AppConfiguration;
import eci.cosw.data.CustomerRepository;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.UserRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
    	//Generando todos los usuarios
    	userRepository.deleteAll();
    	userRepository.save(new User("Alice", "alice@mail.com"));
    	userRepository.save(new User("Alice2", "alice2@mail.com"));
    	userRepository.save(new User("Alice3", "alice3@mail.com"));
    	userRepository.save(new User("Alice4", "alice4@mail.com"));
    	userRepository.save(new User("Alice5", "alice5@mail.com"));
    	userRepository.save(new User("Alice6", "alice6@mail.com"));
    	userRepository.save(new User("Alice7", "alice7@mail.com"));
    	userRepository.save(new User("Alice8", "alice8@mail.com"));
    	userRepository.save(new User("Alice9", "alice9@mail.com"));
    	userRepository.save(new User("Alice10", "alice10@mail.com"));
    	//Generando los todos
    	todoRepository.deleteAll();
    	todoRepository.save(new Todo("descripciondescripciondescripciondescripciondescripciondescripciondescripciondescripciondescripciondescripcion", 1,new Date(2019, 10, 25) , "Alice","InProgress"));
    	todoRepository.save(new Todo("descripcion", 6,new Date(2018, 11, 21) ,"Alice2","Ready"));
    	todoRepository.save(new Todo("descripcion", 5,new Date(2019,11, 27) , "Alice3","InProgress"));
    	todoRepository.save(new Todo("descripcion", 3,new Date(2019, 10, 25) , "Alice4","InProgress"));
    	todoRepository.save(new Todo("descripcion", 2,new Date(2017, 7, 23) , "Alice3","Ready"));
    	todoRepository.save(new Todo("descripciondescripciondescripciondescripciondescripciondescripciondescripcion", 7,new Date(2019, 10, 25) , "Alice5","InProgress"));
    	todoRepository.save(new Todo("descripcion", 1,new Date(2016, 8, 23) , "Alice7","Done"));
    	todoRepository.save(new Todo("descripcion", 6,new Date(2013, 10, 22) , "Alice8","Ready"));
    	todoRepository.save(new Todo("descripcion", 9,new Date(2012, 11, 27) , "Alice9","InProgress"));
    	todoRepository.save(new Todo("descripcion", 10,new Date(2019, 10, 25) , "Alice10","InProgress"));
    	todoRepository.save(new Todo("descripcion", 4,new Date(2019, 10, 25) , "Alice2","InProgress"));
    	todoRepository.save(new Todo("descripcion", 2,new Date(2012, 10, 23) , "Alice4","Ready"));
    	todoRepository.save(new Todo("descripciondescripciondescripciondescripciondescripciondescripciondescripciondescripcion", 3,new Date(2019, 10, 1) , "Alice5","InProgress"));
    	todoRepository.save(new Todo("descripcion", 6,new Date(2019, 5, 25) , "Alice6","InProgress"));
    	todoRepository.save(new Todo("descripcion", 8,new Date(2019, 6, 25) , "Alice8","Ready"));
    	todoRepository.save(new Todo("descripcion", 9,new Date(2019, 7, 25) , "Alice9","Done"));
    	todoRepository.save(new Todo("descripcion", 7,new Date(2019, 10, 10) , "Alice2","InProgress"));
    	todoRepository.save(new Todo("descripcion", 3,new Date(2019, 3, 15) , "Alice3","Ready"));
    	todoRepository.save(new Todo("descripcion", 4,new Date(2016, 4, 25) , "Alice4","InProgress"));
    	todoRepository.save(new Todo("descripcion", 6,new Date(2019, 7, 20) , "Alice8","Ready"));
    	
    	
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));
        
        Query todosExpire = new Query();
        todosExpire.addCriteria(Criteria.where("dueDate").lt(new Date(2019, 10, 25)));
        List<Todo> todosExpired = mongoOperation.find(todosExpire, Todo.class);
        System.out.println("TODAS LAS TAREAS EXPIRADAS");
        for(Todo t: todosExpired) {
        	System.out.println(t);
        }
        
        
        Query userPriority = new Query();
        userPriority.addCriteria(Criteria.where("responsible").is("Alice2").andOperator(Criteria.where("priority").gt(4)));
        List<Todo> userPriorities = mongoOperation.find(userPriority, Todo.class);
        System.out.println("TODAS LAS TAREAS CON ASIGNACION Y PRIORIDAD MAYOR E IGUAL A 5");
        for(Todo t: userPriorities) {
        	System.out.println(t);
        }
        
        
        
        List<User> users = mongoOperation.findAll(User.class);
        System.out.println("USUARIOS CON MAS DE DOS TAREAS");
        for(User u: users) {
        	Query usercount = new Query();
        	usercount.addCriteria(Criteria.where("responsible").is(u.getName()));
        	if(mongoOperation.find(usercount, Todo.class).size()>2) {
        		System.out.println(u);
        	}
        }
        
        
        
        Query lengthDescription = new Query();
        lengthDescription.addCriteria(Criteria.where("description").regex("^[a-zA-Z]{31,}$"));
        List<Todo> descriptionLength = mongoOperation.find(lengthDescription, Todo.class);
        System.out.println("TODAS LAS TAREAS CON LONGITUD EN LA DESCRIPCION MAYOR A 30");
        for(Todo t: descriptionLength) {
        	System.out.println(t);
        }
        
     
       

    }

}