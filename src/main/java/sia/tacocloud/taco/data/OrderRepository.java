package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.taco.model.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
