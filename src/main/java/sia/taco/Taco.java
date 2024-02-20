package sia.taco;

import java.util.List;
import lombok.Data;

/**
 * @author victorljli
 * @date 2024/02/18
 */
@Data
public class Taco {

    private String name;
    private List<Ingredient> ingredients;
}
