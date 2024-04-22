package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.entity.MemberEntityAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityAccountRepository extends CrudRepository<MemberEntityAccount, Long> {
}
