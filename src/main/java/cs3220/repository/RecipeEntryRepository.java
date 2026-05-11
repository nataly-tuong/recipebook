package cs3220.repository;

import org.springframework.data.repository.CrudRepository;

import cs3220.model.RecipeEntry;

public interface RecipeEntryRepository extends CrudRepository<RecipeEntry, Integer>{
	
}
