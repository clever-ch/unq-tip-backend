package root.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import root.model.Publication;
import root.repository.PublicationRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepository;
	
	@GetMapping("/publications")
	public List<Publication> getAllPublications() {
		return publicationRepository.findAll();
	}
}
