package com.vicad.controller;


import com.vicad.model.Department;
import com.vicad.model.Members;
import com.vicad.repository.MembersRepo;
import com.vicad.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member")
    public List<Members> getAllMembers(){
        List<Members> members = memberService.getAllMembers();
        return members;
    }

    @PostMapping("/member")
    public ResponseEntity<Object> createDepartment(@RequestBody Members members){

       Members members1= memberService.createMembers(members);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(members.getId()).toUri();

        return ResponseEntity.created(location).build();

    }



    @GetMapping("/member/{id}")
    public ResponseEntity<Object> getOneMember(@PathVariable Integer id){

        Optional<Members> members = memberService.getOneMember(id);

        if (!members.isPresent())

            return new ResponseEntity<>("Member "+id+" Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(members.get(), HttpStatus.OK);


    }


    @PutMapping("/member/{id}")
    public ResponseEntity<Object> updateMember(@RequestBody Members members, @PathVariable Integer id){

        if (!memberService.checkExistence(id))
            return new ResponseEntity<>("Module "+id+" Not Found",
                    HttpStatus.NOT_FOUND);

        members.setId(id);
        memberService.createMembers(members);

        return ResponseEntity.noContent().build();
     

    }

    // Deletes a specific department
    @DeleteMapping("/department/{id}")
    public void removeDepartment(@PathVariable Integer id) {
        memberService.deleteRecord(id);
    }







}
