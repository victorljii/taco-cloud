package sia.tacocloud.taco.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.taco.model.User;

public interface UserRepository extends CrudRepository<User, String> {
    User findFirstByUsername(String username);
}
