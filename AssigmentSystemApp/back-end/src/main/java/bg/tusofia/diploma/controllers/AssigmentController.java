package bg.tusofia.diploma.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.requestObjects.NewAssigmentRequest;
import bg.tusofia.diploma.responseObjects.AvailableAssigmentResponse;
import bg.tusofia.diploma.responseObjects.MyAssigmentResponse;
import bg.tusofia.diploma.responseObjects.SubmittedAssigmentResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AssigmentController {
	
	@RequestMapping(value = "/availableAssigments", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AvailableAssigmentResponse> getAvailableAssigments(){
		
		// TODO : call service -> retrieve data from database
		
		return new ArrayList<>(Arrays.asList(new AvailableAssigmentResponse(1, "someAssigment", "descr", "VR"),
											 new AvailableAssigmentResponse(2, "someAssigment2", "desc2r", "AI"),
											 new AvailableAssigmentResponse(3, "someAss3", "despacisto" , "CG")));
	}
	
	@RequestMapping(value = "/assigments", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<SubmittedAssigmentResponse> getSubmittedAssigments(){
		
		List<SubmittedAssigmentResponse> response = new ArrayList<>();
		response.add(new SubmittedAssigmentResponse(1, "assigment", "VR", "petko", "petko", "22.01.2017"));
		response.add(new SubmittedAssigmentResponse(2, "assigment2", "AI", "ivan", "ivan", "21.11.2090"));
		response.add(new SubmittedAssigmentResponse(3, "assigment24", "CG", "petko", "ivan", "01.12.1999"));
		
		return response;
	}
	
	@RequestMapping(value = "/submitAssigment", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void submitNewAssigment(@RequestBody NewAssigmentRequest request){
		
		// TODO : save in DB
		
		System.err.println("request : " + request.getAssigmentTitle() + " " + request.getAssigmentTopic() + " " + request.getAssigmentDescr());
	}
	
	@RequestMapping(value = "/myAssigment/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public MyAssigmentResponse getMyAssigment(@PathVariable("id") Integer id){
		System.err.println("id" + id);
		// TODO : query db with id and return result
		
		return new MyAssigmentResponse(1, "name", "Decrtiption", "VR");
	}
	
	@RequestMapping(value = "/submitMyAssigment/{id}", method = RequestMethod.POST, consumes= {"multipart/form-data"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void submitMyAssigment(@PathVariable("id") Integer id, @RequestBody MultipartFile file){
		System.out.println("File:" + file.getName());
		System.out.println("ContentType:" + file.getContentType());
		System.err.println(file);
		
		// works !!!
		// TODO -> handle MultipartFile - http://viralpatel.net/blogs/tutorial-save-get-blob-object-spring-3-mvc-hibernate/
		
	}
}
