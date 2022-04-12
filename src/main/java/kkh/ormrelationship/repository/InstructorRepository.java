package kkh.ormrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kkh.ormrelationship.datamodel.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
