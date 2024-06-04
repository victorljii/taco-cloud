package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.taco.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
