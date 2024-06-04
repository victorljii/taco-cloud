package sia.tacocloud.taco.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sia.tacocloud.taco.model.Ingredient;
import sia.tacocloud.taco.model.Ingredient.Type;
import sia.tacocloud.taco.model.Taco;
import sia.tacocloud.taco.model.TacoOrder;
import sia.tacocloud.taco.data.IngredientRepository;

/**
 * @author victorljli
 * @date 2024/02/18
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")     // 表明这个类中放到模型里面的 TacoOrder 对象应该在会话中一直保持, 这样能够使其跨多个请求.
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute     // 该方法会在处理请求的时候被调用, 构建一个包含 Ingredient 的 List 并将其放到模型中.
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(it -> ingredients.add(it));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            // 放到 Model 属性中的数据将会复制到 Servlet 请求的属性中，这样视图就能找到数据，并使用它们在用户的浏览器中渲染页面。
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("process taco: {}", taco);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(it -> it.getType().equals(type)).collect(Collectors.toList());
    }
}
