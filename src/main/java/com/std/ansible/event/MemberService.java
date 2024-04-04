package com.std.ansible.event;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final ResultRepository resultRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final EntityManager entityManager;

    public String applyMember(PostMemberReq postMemberReq) {
        try {
            Member member = Member.builder()
                    .name(postMemberReq.getName())
                    .team(postMemberReq.getTeam())
                    .build();
//            log.info(postMemberReq.getName());
            memberRepository.save(member);
            return "성공";
        } catch (Exception e) {
            return "실패";
        }
    }

    public void resultProcess() {

        List<Member> list = memberRepository.randomResult();
        for (Member i: list) {
            log.info(i.getName() + i.getTeam());
            Result result = Result.builder()
                    .name(i.getName())
                    .team(i.getTeam())
                    .build();
            resultRepository.save(result);
        }
    }
    public boolean resultCheck() {
        boolean check = false;
        List<Result> list = resultRepository.findAll();
        return !list.isEmpty();
    }

    public List<GetResultDto> getResult() {
        List<Result> list = resultRepository.findAll();
        List<GetResultDto> dtoList = new ArrayList<>();
        try {
            for (int i = 0; i < 3; i++) {
                Result r = list.get(i);
                GetResultDto getResultDto = new GetResultDto(r.getName(), r.getTeam());
                dtoList.add(getResultDto);
            }
        } catch (Exception e) {
            return dtoList;
        }
        return dtoList;
    }

}
