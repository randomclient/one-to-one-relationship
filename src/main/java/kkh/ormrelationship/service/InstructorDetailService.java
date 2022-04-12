package kkh.ormrelationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkh.ormrelationship.datamodel.InstructorDetail;
import kkh.ormrelationship.repository.InstructorDetailRepository;

@Service
public class InstructorDetailService {
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	
	public void save(InstructorDetail entity) {
		instructorDetailRepository.save(entity);
	}

	public List<InstructorDetail> findAll() {
		return instructorDetailRepository.findAll();
	}
	
	public void deleteById(int id) {
		instructorDetailRepository.deleteById(id);
	}
}
