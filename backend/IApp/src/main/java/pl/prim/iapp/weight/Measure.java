package pl.prim.iapp.weight;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
class Measure {

	private long value;

	public Measure(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "WeightValue{" +
				"value=" + value +
				'}';
	}
}
