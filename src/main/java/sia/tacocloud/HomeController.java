package sia.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author victorljli
 * @date 2023/12/27
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";  // 返回视图名
    }
}
