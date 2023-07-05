package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Long> {

}
