package pl.prim.iapp.weight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.prim.iapp.user.User;

@RestController
@RequestMapping("/weights")
class WeightController {

	@Autowired
	WeightService weightService;

	@PostMapping
	public ResponseEntity<?> addWeight(@RequestBody WeightDto weight, @AuthenticationPrincipal User user) {
		boolean status = weightService.addWeight(weight, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}

	@GetMapping
	public ResponseEntity<?> getAllWeights(@AuthenticationPrincipal User user) {
		return ResponseEntity.ok(weightService.getWeights(user));
	}
}
