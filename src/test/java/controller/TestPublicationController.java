package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import factories.PublicationFactory;
import modelDTO.PublicationDTOFactory;
import root.DTO.PublicationDTO;
import root.constants.PublicationType;
import root.controller.PublicationController;
import root.model.Publication;
import root.repository.PublicationRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestPublicationController {

	@InjectMocks
	PublicationController publicationController;
	
	@Mock
	PublicationRepository publicationRepository;
	
	@Test
	public void testGetPublicationsLost_ReturnTrue() {		
		Publication publication = PublicationFactory.createFullPublicationWithType(PublicationType.Perdido);
		List<Publication> publications = new ArrayList<Publication>();
		publications.add(publication);
		
		when(publicationRepository.findAllPublicationsLost()).thenReturn(publications);
		
		PublicationDTO publicationDTO = PublicationDTOFactory.createFullPublicationDTOWithType(PublicationType.Perdido);
		List<PublicationDTO> resultPublicationsDTO = new ArrayList<PublicationDTO>();
		resultPublicationsDTO.add(publicationDTO);
		
		List<PublicationDTO> result = publicationController.getAllPublicationsLost();

		assertTrue(result.size() != 0);
		assertEquals(result.get(0).PublicationType, PublicationType.Perdido);
	}
}
