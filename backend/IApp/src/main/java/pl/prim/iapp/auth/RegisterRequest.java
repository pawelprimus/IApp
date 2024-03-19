package pl.prim.iapp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prim.iapp.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    //private String firstname;
    //private String lastname;
    private String username;
    private String password;
    private Role role;
}
