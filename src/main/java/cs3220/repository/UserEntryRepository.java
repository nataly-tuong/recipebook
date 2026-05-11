package cs3220.repository;

import org.springframework.data.repository.CrudRepository;

import cs3220.model.UserEntry;

public interface UserEntryRepository extends CrudRepository<UserEntry, Integer>{
	UserEntry findByEmail(String email);
}
