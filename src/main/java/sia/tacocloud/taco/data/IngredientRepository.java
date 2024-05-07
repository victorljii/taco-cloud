package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.taco.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
