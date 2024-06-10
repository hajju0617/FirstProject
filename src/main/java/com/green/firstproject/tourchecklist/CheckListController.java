package com.green.firstproject.tourchecklist;

import com.green.firstproject.tourchecklist.model.*;
import com.green.firstproject.common.model.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tour/checklist")
@RequiredArgsConstructor
@Slf4j
public class CheckListController {
    private final CheckListService service;

    @PostMapping
    public ResultDto<Integer> postCheckList(@ParameterObject @RequestBody PostCheckListReq p){
        int result = service.postCheckList(p);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list에 등록되었습니다.")
                .build();
    }

    @PutMapping
    public ResultDto<Integer> putCheckList(@ParameterObject @RequestBody PutCheckListReq p){
        int result = service.putCheckList(p);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list를 수정하였습니다.")
                .build();
    }

    @DeleteMapping
    public ResultDto<Integer> deleteCheckList(@RequestParam("checklist_id") int checklistId){
        int result = service.deleteCheckList(checklistId);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list를 삭제하였습니다.")
                .build();
    }

    @GetMapping
    public ResultDto<List<GetCheckListRes>> getCheckList(@ParameterObject @ModelAttribute GetCheckListReq p){
        List<GetCheckListRes> result = service.getCheckList(p);

        return ResultDto.<List<GetCheckListRes>>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .build();
    }

    @PatchMapping
    public ResultDto<Integer> toggleCheckList(@RequestBody ToggleCheckList p){
        int result = service.toggleCheckList(p);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .build();
    }
}