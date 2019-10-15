package eci.cosw.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import eci.cosw.data.TodoRepository;
import eci.cosw.data.model.Todo;

public class TodoImpl implements TodoRepository{
	@Autowired
	TodoRepository todor;

	
	public <S extends Todo> List<S> saveAll(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Todo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Todo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	public <S extends Todo> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Todo> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Todo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}


	public <S extends Todo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	public Page<Todo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Todo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<Todo> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterable<Todo> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Todo entity) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteAll(Iterable<? extends Todo> entities) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
	public <S extends Todo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Todo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Todo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public <S extends Todo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Todo findByResponsible(String user) {
		// TODO Auto-generated method stub
		List<Todo> todos=todor.findAll();
		for(Todo t: todos) {
			if(user.equals(t.getResponsible())) {
				return t;
			}
		}
		return null;
	}
	
}
