package sia.tacocloud.taco.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import sia.tacocloud.taco.data.OrderRepository;

/**
 * 管理员操作订单相关数据的服务
 *
 * @date 2024/06/03
 */
@Service
public class OrderAdminService {

    private OrderRepository orderRepository;

    public OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
