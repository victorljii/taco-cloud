package sia.tacocloud.taco;

import lombok.Data;

/**
 * 描述 taco 跟组成该 taco 的每个 ingredient 的联系
 *
 * @date 2024/04/09
 */
@Data
public class IngredientRef {
    private final String ingredient;
}
