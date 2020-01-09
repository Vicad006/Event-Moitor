package com.vicad.service;


import com.vicad.model.Members;
import com.vicad.repository.MembersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MembersRepo membersRepo;


    public MemberService(MembersRepo membersRepo) {
        this.membersRepo = membersRepo;
    }


    public Optional<Members> getOneMember(Integer id){

        Optional<Members> member = membersRepo.findById(id);
        return member;
    }


    public List<Members> getAllMembers(){

        List<Members> members = membersRepo.findAll();

        return members;

    }


    public Members createMembers(Members members){

        return membersRepo.save(members);
    }

    public  void deleteRecord(Integer id){

        membersRepo.deleteById(id);
    }



    public Boolean checkExistence(Integer id){

        boolean result = membersRepo.existsById(id);

        return result;
    }


    public long countRecord(){

        long count = membersRepo.count();
        return count;
    }

}
