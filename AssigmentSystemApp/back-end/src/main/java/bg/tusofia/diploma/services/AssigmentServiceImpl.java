package bg.tusofia.diploma.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.dao.AssigmentDao;
import bg.tusofia.diploma.dao.UserDao;
import bg.tusofia.diploma.entities.Assigment;
import bg.tusofia.diploma.entities.User;
import bg.tusofia.diploma.requestObjects.NewAssigmentRequest;
import bg.tusofia.diploma.responseObjects.AvailableAssigmentResponse;
import bg.tusofia.diploma.responseObjects.MyAssigmentResponse;
import bg.tusofia.diploma.responseObjects.SubmittedAssigmentResponse;

@Service
public class AssigmentServiceImpl implements AssigmentService{
	
	@Autowired
	private AssigmentDao assigmentDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public ArrayList<AvailableAssigmentResponse> getAvailableAssigments() {
		
		ArrayList<Assigment> availableAssigmentsResult = (ArrayList<Assigment>) assigmentDao.getAvailableAssigments();
		ArrayList<AvailableAssigmentResponse> response = new ArrayList<>();
		
		for (Assigment assigment : availableAssigmentsResult) {
			AvailableAssigmentResponse temp = new AvailableAssigmentResponse();
			temp.setId(assigment.getAssigmentId());
			temp.setName(assigment.getName());
			temp.setCategory(assigment.getCategory());
			temp.setDescription(assigment.getDescription());
			System.out.println(temp.toString());
			response.add(temp);
		}
		
		return response;
	}

	@Override
	public MyAssigmentResponse getMyAssigment(Integer userId) {
		
		Assigment myAssigmentResult = assigmentDao.getMyAssigment(userId);
		MyAssigmentResponse myAssigmentResponse = new MyAssigmentResponse(myAssigmentResult.getAssigmentId(), myAssigmentResult.getName(),
																	myAssigmentResult.getDescription(), myAssigmentResult.getCategory(),
																	myAssigmentResult.getIsSubmitted());
		
		
		return myAssigmentResponse;
	}

	@Override
	public void saveAssigment(NewAssigmentRequest assigment) {
		Assigment assigmentSave = new Assigment();
		assigmentSave.setName(assigment.getAssigmentTitle());
		assigmentSave.setCategory(assigment.getAssigmentTopic());
		assigmentSave.setDescription(assigment.getAssigmentDescr());
		assigmentSave.setIsAssigned(false);
		assigmentSave.setIsSubmitted(false);
		assigmentDao.saveAssigment(assigmentSave);
		
	}

	@Override
	public List<SubmittedAssigmentResponse> getSubmittedAssigments() {
		List<Assigment> result = assigmentDao.getSubmittedAssigments();
		List<SubmittedAssigmentResponse> response = new ArrayList<>(); 
		for (Assigment assigment : result) {
			SubmittedAssigmentResponse tmp = new SubmittedAssigmentResponse();
			tmp.setStudent_first_name(assigment.getUser().getFirstName());
			tmp.setStudent_last_name(assigment.getUser().getLastName());
			tmp.setCategory(assigment.getCategory());
			tmp.setId(assigment.getAssigmentId());
			tmp.setName(assigment.getName());
			tmp.setDate_submitted(assigment.getDateSubmitted().toString());
			response.add(tmp);
		}
		return response;
	}

	@Override
	public void submitMyAssigment(Integer id, MultipartFile pdfFile) {
		
		Assigment assigmentFromDb = assigmentDao.getAssigmentById(id);
		assigmentFromDb.setDateSubmitted(new Date());
		
		assigmentDao.submitMyAssigment(assigmentFromDb, pdfFile);
	}

	@Override
	public void deleteAssigment(Integer id) {
		assigmentDao.deleteAssigment(id);
		
	}

	@Override
	public void takeAssigment(Integer assigmentId, Integer userId) {
		
		User user = userDao.getUserById(userId);
		Assigment assigment = assigmentDao.getAssigmentById(assigmentId);
		
		user.setHasAssigment(true);
		userDao.updateUser(user);
		
		assigment.setIsAssigned(true);
		assigment.setUser(user);
		assigmentDao.takeAssigment(assigment.getIsAssigned(), assigment.getUser(), assigmentId);
		
	}

	@Override
	public Assigment getAssigmentById(Integer assigmentId) {
		
		return assigmentDao.getAssigmentById(assigmentId);
	}

}
