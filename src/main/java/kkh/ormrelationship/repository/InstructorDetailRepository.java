package kkh.ormrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkh.ormrelationship.datamodel.InstructorDetail;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

}
