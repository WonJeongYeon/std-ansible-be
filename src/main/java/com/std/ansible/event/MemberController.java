package com.std.ansible.event;

import com.std.ansible.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

//    @GetMapping("")
//    @Operation(summary = "부품 목록 조회", description = "부품 목록을 조회합니다. 파라미터로 검색 조건을 활성화할 수 있습니다.")
//    @ResponseBody
//    public BaseResponse<List<GetPartsDto>> getParts(GetPartsParam getPartsParam) throws ParseException {
//        log.warn(getPartsParam.toString());
//
//        List<GetPartsDto> list = partsService.getParts(getPartsParam);
//
//        return new BaseResponse<>(list);
//    }

    @PostMapping("")
    @ResponseBody
    public BaseResponse<String> applyMember(@RequestBody PostMemberReq postMemberReq) {
        log.info(postMemberReq.getName() + postMemberReq.getTeam());
        return new BaseResponse<>(memberService.applyMember(postMemberReq));

    }


    @PostMapping("/result")
    @ResponseBody
    public BaseResponse<Integer> resultProcess() {

        memberService.resultProcess();
        return new BaseResponse<>(1);
    }

    @GetMapping("/result/check")
    @ResponseBody
    public BaseResponse<Boolean> resultCheck() {
        return new BaseResponse<>(memberService.resultCheck());
    }

    @GetMapping("/result")
    @ResponseBody
    public BaseResponse<List<GetResultDto>> getResult() {
        return new BaseResponse<>(memberService.getResult());
    }

}
