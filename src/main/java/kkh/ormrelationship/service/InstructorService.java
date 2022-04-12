package kkh.ormrelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.ormrelationship.datamodel.Instructor;
import kkh.ormrelationship.repository.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	
	public void save(Instructor entity) {
		instructorRepository.save(entity);
	}

	public List<Instructor> findAll() {
		return instructorRepository.findAll();
	}
	
	public void deleteById(int id) {
		instructorRepository.deleteById(id);
	}
}
