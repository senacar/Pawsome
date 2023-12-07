package com.sabanciuniv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.Comments;
import com.sabanciuniv.model.Pet;
import com.sabanciuniv.repo.CommentRepository;
import com.sabanciuniv.repo.PetRepository;

@RestController
@RequestMapping("/pets")
public class PawsomeController {
	@Autowired private PetRepository petRepository;
	@Autowired private CommentRepository comRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(PawsomeController.class);
	List<Pet> pets;
	List<Comments> comments;
	@PostConstruct
	public void init() {
		if (petRepository.count() == 0) {
			logger.info("Database is empty, initializing...");
			
			Pet p1 = new Pet("1", "Cat", "Siamese" ,"Striking blue eyes and sleek, elegant bodies with long legs and a fine, glossy coat.", "https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/fca42f04-2474-4302-a238-990c8aebfe8c/Siamese_cat_1110x740.jpg?w=3840&q=75&auto=format");
			Pet p2 = new Pet("2","Cat","Scottish Shorthair","The British Shorthair is a medium to large sized, compact, chunky cat, known for their attractive features and thick, plush fur.", "https://cdn.britannica.com/44/186844-050-091E4372/Scottish-fold-cat.jpg");
			Pet p3 = new Pet("3","Dog", "Golden Retriever","The Golden Retriever is a Scottish breed of retriever dog of medium size. It is characterised by a gentle and affectionate nature and a striking golden coat.", "https://www.markamama.com.tr/golden-retriever-ozellikleri-16-blog.jpg");
			Pet p4 = new Pet("4","Dog", "Siberian Husky","The Siberian Husky is a medium-sized working sled dog breed. The breed belongs to the Spitz genetic family. It is recognizable by its thickly furred double coat, erect triangular ears, and distinctive markings.", "https://www.dailypaws.com/thmb/KMJM_zupItmjx1g-tAAZ-7L-hbE=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/siberian-husky-100800827-2000-9449ca147e0e4b819bce5189c2411188.jpg");
			Pet p5 = new Pet("5","Dog","German Shepherd","Large and muscular with a signature square muzzle, bushy tail, and usually black mask.", "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg");
			Pet p6 = new Pet("6","Dog","Beagle","The beagle is a breed of small scent hound, similar in appearance to the much larger foxhound. The beagle was developed primarily for hunting hare, known as beagling.", "https://cdn.britannica.com/16/234216-050-C66F8665/beagle-hound-dog.jpg");
			Pet p7 = new Pet("7","Cat","Persian Cat","The Persian cat, also known as the Persian longhair, is a long-haired breed of cat characterised by a round face and short muzzle.", "https://www.lovemycatz.com/wp-content/uploads/2022/02/gettyimages-174776419.jpg");
			Pet p8 = new Pet("8","Cat", "Maine Coon","Their large, round paws have tufts of hair sticking up from the toes. The head is slightly longer in length than width, with high cheekbones, a distinctive square muzzle, and large, well-tufted ears.", "https://petkoleji.com/wp-content/uploads/2022/02/Maine-Coon-Trasi-ve-Bakimi.jpg.webp");		
			
			petRepository.save(p1);
			petRepository.save(p2);
			petRepository.save(p3);
			petRepository.save(p4);
			petRepository.save(p5);
			petRepository.save(p6);
			petRepository.save(p7);
			petRepository.save(p8);
			
			//comments
			Comments com1 = new Comments("1", "What a cute cat!", "Duck");
			Comments com2 = new Comments("2", "My guy is also a Scottish Shorthair!", "Lyle");
			Comments com3 = new Comments("3", "Golden energy!", "Chuck");
			Comments com4 = new Comments("4", "Cool eyes!", "Ghost");
			Comments com5 = new Comments("5", "Oh big boy", "Officer");
			Comments com6 = new Comments("6", "Awwwww", "navySeal35");
			Comments com7 = new Comments("7", "<3", "Officer");
			Comments com8 = new Comments("8", "Oh it's like a tiger!", "navySeal35");
			
			comRepo.save(com1);
			comRepo.save(com2);
			comRepo.save(com3);
			comRepo.save(com4);
			comRepo.save(com5);
			comRepo.save(com6);
			comRepo.save(com7);
			comRepo.save(com8);
			
			pets = petRepository.findAll();
			comments= comRepo.findAll();
			
			logger.info("All sample data saved!");
		}
	}
	
	@GetMapping("/pets")
	public List<Pet> pets() {
		return pets;
	}
	
	@PostMapping("/pets/save")
	public Pet savePet(@RequestBody Pet pet) {
		Pet petSaved = petRepository.save(pet);
		return petSaved;
	}
	
	@GetMapping("/getcommentsbypetsid/{petsId}")
	public List<Comments> commentsByPetId(@PathVariable("petsId") String petsId) {
	    List<Comments> commentsByPetId = new ArrayList<>();
	    for (Comments comment : comments) {
	        if (comment.getPetId().equals(petsId)) {
	            commentsByPetId.add(comment);
	        }
	    }
	    return commentsByPetId;
	}
	
	@PostMapping("/savecomment")
	public Comments saveComment(@RequestBody Comments comment) {
		Comments commentSaved= comRepo.save(comment);
		return commentSaved;
	}
}
