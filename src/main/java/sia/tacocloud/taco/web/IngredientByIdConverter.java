package sia.tacocloud.taco.web;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sia.tacocloud.taco.Ingredient;
import sia.tacocloud.taco.data.IngredientRepository;

/**
 * @author victorljli
 * @date 2024/02/20
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(@NotNull String id) {
        return ingredientRepository.findById(id).orElse(null);
    }

}