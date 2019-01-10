package ojek.jpa_project.repository;

import ojek.jpa_project.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    Member findByName(String name);

    void deleteById(String id);
}
