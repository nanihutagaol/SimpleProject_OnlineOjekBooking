package ojek.jpa_project.service.impl;

import ojek.jpa_project.exception.ResourceNotFoundException;
import ojek.jpa_project.model.Member;
import ojek.jpa_project.repository.MemberRepository;
import ojek.jpa_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAll(){
        List<Member> members = memberRepository.findAll();

        if (members.isEmpty()){
            throw new ResourceNotFoundException("Data is empty");
        }

        return members;
    }

    public Member getById(String id){
        Member member = memberRepository.findOne(id);

        if (member == null){
            throw new ResourceNotFoundException("Data not found");
        }

        return member;
    }

    public Member create(Member newMember){
        Member member = memberRepository.findByName(newMember.getName());

        if(member != null){
            throw new ResourceNotFoundException("Data exist");
        }

        return memberRepository.save(member);
    }

    public Member update(String id, Member updMember){
        Member member = memberRepository.findOne(id);

        if (member == null){
            throw new ResourceNotFoundException("Data not found");
        }

        member.setName(updMember.getName());
        member.setBalance(updMember.getBalance());

        return memberRepository.save(member);
    }

    public boolean delete(String id){
        Member member = memberRepository.findOne(id);

        if (member == null){
            throw new ResourceNotFoundException("Data not found");
        }

        memberRepository.deleteById(id);
        return true;
    }


}
