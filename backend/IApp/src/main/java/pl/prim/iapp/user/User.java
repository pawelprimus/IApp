package pl.prim.iapp.user;

import pl.prim.iapp.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class User extends BaseEntity {


    @Column(nullable = false, unique = true)
    private final String userName;

    @Column(nullable = false)
    private final String password;

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    User(NewUser source) {
        this(
                source.userName(),
                source.password()
        );
    }



}


record NewUser(
        @NotEmpty(message = "Username must not be empty")
        @Pattern(regexp = "")
        String userName,
        @NotEmpty(message = "Password must not be empty")
        @Pattern(regexp = "")
        String password
) {
    User toUser() {
        return new User(this);
    }
}
