package cc.unitmesh.untitled.demo.repository;

import cc.unitmesh.untitled.demo.entity.MemberAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAccountRepository extends CrudRepository<MemberAccount, Long> {
}
