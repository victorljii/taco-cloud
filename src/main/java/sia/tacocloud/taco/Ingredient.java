package sia.tacocloud.taco;

import lombok.Data;

/**
 * @author victorljli
 * @date 2024/02/18
 */
@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
