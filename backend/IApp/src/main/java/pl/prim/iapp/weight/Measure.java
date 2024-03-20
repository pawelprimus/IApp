package pl.prim.iapp.weight;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
class Measure {

	private double value;

	public Measure(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "WeightValue{" +
				"value=" + value +
				'}';
	}
}
