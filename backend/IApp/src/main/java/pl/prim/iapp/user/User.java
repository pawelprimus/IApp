package pl.prim.iapp.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prim.iapp.common.BaseEntity;

import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
class User extends BaseEntity {


    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    UserDto toDto() {
        return new UserDto(id, userName);
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

}

record UserDto(Long id, String userName) {
    UserDto(Long id, String userName) {
        this.id = id;
        this.userName = userName;
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
        @NotEmpty(message = "Password must not be empty")
        //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Password must be 8-20 characters long and include at least one lowercase letter, one uppercase letter, and one number")
        String password
) {}

