package sia.tacocloud.taco.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户实体类
 *
 * @date 2024/05/28
 */
@Data
@Document(collection = "t_user_detail")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String fullname;
    @NonNull
    private String street;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String zip;
    @NonNull
    private String phoneNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
