package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.entity.StepNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepNumberRepository extends CrudRepository<StepNumber, Long> {
}
