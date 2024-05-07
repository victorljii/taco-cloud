package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.taco.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
