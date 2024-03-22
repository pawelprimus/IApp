package pl.prim.iapp.weight;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.prim.iapp.user.User;

@Service
class WeightService {

	private final WeightRepository weightRepository;

	WeightService(WeightRepository weightRepository) {
		this.weightRepository = weightRepository;
	}

	Weight save(Weight weight) {
		return weightRepository.save(weight);
	}


	Weight addWeight(WeightDto weight, User user) {
		Weight savedWeight = weightRepository.save(weight.toWeight(user));
		return savedWeight;
	}
}
