package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.tacocloud.taco.TacoOrder;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
