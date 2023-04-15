package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {

}
