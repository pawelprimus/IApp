package pl.prim.iapp.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.prim.iapp.common.BaseEntity;

import java.util.Collection;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@Table(name = "_user")
@Builder
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {


    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    UserDto toDto() {
        return new UserDto(id, username);
    }

    User(NewUserDto source, String encodedPassword) {
        this(
                source.userName(),
                encodedPassword
        );
    }

    void update(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return username;
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

record UserDto(Long id, String username) {
    UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}

record NewUserDto(
        @NotEmpty(message = "Username must not be empty")
        //@Pattern(regexp = "^[a-zA-Z0-9_]{3,15}$", message = "Username must be 3-15 characters long and can only contain letters, numbers, and underscores")
        String userName,
        @NotEmpty(message = "Password must not be empty")
        //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Password must be 8-20 characters long and include at least one lowercase letter, one uppercase letter, and one number")
        String password
) {
    User toUser(String encodedPassword) {
        return new User(this, encodedPassword);
    }
}

record UpdateUserDto(
        //@NotEmpty(message = "Password must not be empty")
        //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Password must be 8-20 characters long and include at least one lowercase letter, one uppercase letter, and one number")
        String password
) {}

