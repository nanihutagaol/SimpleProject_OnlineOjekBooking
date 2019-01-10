package ojek.jpa_project.controller;

import ojek.jpa_project.model.Member;
import ojek.jpa_project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ojek")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    List<Member> getAll(){
        return memberService.getAll();
    }

    @GetMapping("/member/{id}")
    Member getById(@PathVariable String id){
        return memberService.getById(id);
    }

    @PostMapping("/member")
    Member create(@Valid @RequestBody Member member){
        return memberService.create(member);
    }

    @PutMapping("/member/{id}")
    Member update(@PathVariable String id, @Valid @RequestBody Member member){
        return memberService.update(id, member);
    }

    @DeleteMapping("member/{id}")
    boolean detele(@PathVariable String id){
        return memberService.delete(id);
    }
}
