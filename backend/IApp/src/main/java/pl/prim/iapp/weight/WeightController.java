package pl.prim.iapp.weight;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.prim.iapp.user.User;

@RestController
@RequestMapping("/weights")
class WeightController {

	WeightService weightService;

	@PostMapping
	public ResponseEntity<Weight> addWeight(@RequestBody WeightDto weight, @AuthenticationPrincipal User user) {
		Weight savedWeight = weightService.addWeight(weight, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedWeight);
	}
}
