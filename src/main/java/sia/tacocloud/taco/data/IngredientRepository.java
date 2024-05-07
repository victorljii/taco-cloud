package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.taco.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
