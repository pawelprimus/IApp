package pl.prim.iapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.prim.iapp.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

}
