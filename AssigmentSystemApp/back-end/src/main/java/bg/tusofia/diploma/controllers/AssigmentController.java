package bg.tusofia.diploma.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.entities.Assigment;
import bg.tusofia.diploma.requestObjects.NewAssigmentRequest;
import bg.tusofia.diploma.responseObjects.AvailableAssigmentResponse;
import bg.tusofia.diploma.responseObjects.MyAssigmentResponse;
import bg.tusofia.diploma.responseObjects.SubmittedAssigmentResponse;
import bg.tusofia.diploma.services.AssigmentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AssigmentController {
	
	@Autowired
	private AssigmentService assigmentService;
	
	@RequestMapping(value = "/availableAssigments", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<AvailableAssigmentResponse> getAvailableAssigments(){
		
		return assigmentService.getAvailableAssigments();
	}
	
	@RequestMapping(value = "/assigments", method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<SubmittedAssigmentResponse> getSubmittedAssigments(){

		List<SubmittedAssigmentResponse> response = assigmentService.getSubmittedAssigments();
		
		return response;
	}
	
	@RequestMapping(value = "/submitAssigment", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void submitNewAssigment(@RequestBody NewAssigmentRequest request){
		
		assigmentService.saveAssigment(request);
		
		System.err.println("request : " + request.getAssigmentTitle() + " " + request.getAssigmentTopic() + " " + request.getAssigmentDescr());
	}
	
	@RequestMapping(value = "/myAssigment/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public MyAssigmentResponse getMyAssigment(@PathVariable("userId") Integer userId){
		
		return assigmentService.getMyAssigment(userId);
	}
	
	@RequestMapping(value = "/submitMyAssigment/{id}", method = RequestMethod.POST, consumes= {"multipart/form-data"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void submitMyAssigment(@PathVariable("id") Integer id, @RequestBody MultipartFile file){
		System.out.println("File:" + file.getName());
		System.out.println("ContentType:" + file.getContentType());
		System.err.println(file);
		
		assigmentService.submitMyAssigment(id, file);
		
	}
	
	@RequestMapping(value = "/deleteAssigment/{id}", method = RequestMethod.POST)
	public void deleteAssigment(@PathVariable("id") Integer assigmentId){
		assigmentService.deleteAssigment(assigmentId);
	}
	
	@RequestMapping(value = "/takeAssigment/{assigmentId}/{userId}", method = RequestMethod.POST)
	public void takeAssigment(@PathVariable("assigmentId") Integer assigmentId, @PathVariable("userId") Integer userId){
		assigmentService.takeAssigment(assigmentId, userId);
	}
	
	@RequestMapping(value = "/downloadAssigment/{assigmentId}", method = RequestMethod.GET)
	public String downloadAssigment(@PathVariable("assigmentId") Integer assigmentId, HttpServletResponse response) throws IOException {
		
		Assigment assigmentToReturn = assigmentService.getAssigmentById(assigmentId);
		
		try {
			response.setHeader("Content-Disposition", "attachment; filename=\"" +assigmentToReturn.getName()+".pdf"+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			IOUtils.copy(assigmentToReturn.getPdf().getBinaryStream(), out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
