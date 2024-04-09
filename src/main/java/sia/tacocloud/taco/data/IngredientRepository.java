package sia.tacocloud.taco.data;

import java.util.Optional;
import sia.tacocloud.taco.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);

}
