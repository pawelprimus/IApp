package pl.prim.iapp.weight;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.prim.iapp.common.BaseEntity;
import pl.prim.iapp.user.Role;
import pl.prim.iapp.user.User;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weight extends BaseEntity {

	@Column(nullable = false)
	private Measure measure;

	@Column(nullable = false)
	private LocalDate localDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	Weight(long measure, LocalDate localDate, User user) {
		this.measure = new Measure(measure);
		this.localDate = localDate;
		this.user = user;
	}
}

record WeightDto(
		long measure,
		LocalDate localDate
) {
	Weight toWeight(User user) {
		return new Weight(measure, localDate, user);
	}
}
