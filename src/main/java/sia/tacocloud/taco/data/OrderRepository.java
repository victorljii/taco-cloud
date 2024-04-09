package sia.tacocloud.taco.data;

import sia.tacocloud.taco.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);

}
