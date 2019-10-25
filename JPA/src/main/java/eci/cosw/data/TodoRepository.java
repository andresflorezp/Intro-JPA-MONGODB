package eci.cosw.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import eci.cosw.data.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String>{
	List<Todo> findByResponsible(String user);
}
