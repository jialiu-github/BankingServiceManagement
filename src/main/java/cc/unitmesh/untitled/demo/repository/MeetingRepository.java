package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<BlogPost, Long> {

}
