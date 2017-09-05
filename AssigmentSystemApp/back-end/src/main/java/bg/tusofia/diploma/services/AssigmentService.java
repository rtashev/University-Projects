package bg.tusofia.diploma.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.entities.Assigment;
import bg.tusofia.diploma.requestObjects.NewAssigmentRequest;
import bg.tusofia.diploma.responseObjects.AvailableAssigmentResponse;
import bg.tusofia.diploma.responseObjects.MyAssigmentResponse;
import bg.tusofia.diploma.responseObjects.SubmittedAssigmentResponse;

public interface AssigmentService {
	
	ArrayList<AvailableAssigmentResponse> getAvailableAssigments();
	MyAssigmentResponse getMyAssigment(Integer id);
	void saveAssigment(NewAssigmentRequest assigment);
	List<SubmittedAssigmentResponse> getSubmittedAssigments();
	void submitMyAssigment(Integer id, MultipartFile pdfFile);
	void deleteAssigment(Integer id);
	void takeAssigment(Integer assigmentId, Integer userId);
	Assigment getAssigmentById(Integer assigmentId);
}
