package pl.prim.iapp.model;

import lombok.Builder;
import pl.prim.iapp.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;
}
