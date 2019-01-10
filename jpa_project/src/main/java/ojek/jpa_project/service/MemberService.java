package ojek.jpa_project.service;

import ojek.jpa_project.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAll();

    Member getById(String id);

    Member create(Member member);

    Member update(String id, Member member);

    boolean delete(String id);
}
