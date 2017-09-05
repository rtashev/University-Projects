package bg.tusofia.diploma.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.entities.Assigment;
import bg.tusofia.diploma.entities.User;

public interface AssigmentDao {
	
	List<Assigment> getAvailableAssigments();
	Assigment getMyAssigment(Integer id);
	void saveAssigment(Assigment assigment);
	List<Assigment> getSubmittedAssigments();
	Assigment getAssigmentById(Integer assigmentId);
	void submitMyAssigment(Assigment assigment, MultipartFile file);
	void deleteAssigment(Integer id);
	void takeAssigment(boolean isAssigned, User user, Integer assigmentId);
}
