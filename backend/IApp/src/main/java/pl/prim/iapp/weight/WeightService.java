package pl.prim.iapp.weight;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.prim.iapp.user.User;

import java.util.Comparator;
import java.util.List;

@Service
class WeightService {

	private final WeightRepository weightRepository;

	WeightService(WeightRepository weightRepository) {
		this.weightRepository = weightRepository;
	}

	Weight save(Weight weight) {
		return weightRepository.save(weight);
	}


	boolean addWeight(WeightDto weight, User user) {
		weightRepository.save(weight.toWeight(user));
		return true;
	}

	List<WeightDto> getWeights(User user) {
		return weightRepository.findAllByUser(user).stream().sorted(Comparator.comparing(Weight::getLocalDate)).map(Weight::toDto).toList();
	}

}
