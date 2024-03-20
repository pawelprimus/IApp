package pl.prim.iapp.weight;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prim.iapp.common.BaseEntity;
import pl.prim.iapp.user.User;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Weight extends BaseEntity {

	@Column(nullable = false)
	private Measure measure;

	@Column(nullable = false)
	private LocalDate localDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
}