package com.tsunagi.app.advisor.controller;

import com.tsunagi.app.advisor.dto.AdvisorDto;
import com.tsunagi.app.advisor.dto.AdvisorListRequestDto;
import com.tsunagi.app.advisor.dto.AdvisorListResponseDto;
import com.tsunagi.app.advisor.dto.AdvisorUpdateRequestDto;
import com.tsunagi.app.advisor.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * アドバイザー関連のAPIを定義する。
 */
@RequiredArgsConstructor
@RestController("/advisor")
public class AdvisorController {

    private final AdvisorService advisorService;

    /**
     * 検索条件によるアドバイザー一覧を取得する。
     *
     * @param requestDto 検索条件
     * @return アドバイザー一覧
     */
    @GetMapping
    @ResponseBody
    public AdvisorListResponseDto findAllBySearchCondition(@RequestBody AdvisorListRequestDto requestDto) {
        return advisorService.findAllBySearchCondition(requestDto);
    }

    /**
     * アドバイザーの詳細情報を取得する。
     * @param advisorId
     * @return アドバイザーの詳細情報
     */
    @GetMapping("/advisor/{id}")
    @ResponseBody
    public AdvisorDto findById(@PathVariable("id") Long advisorId) {
        return advisorService.findById(advisorId);
    }

    /**
     * アドバイザー情報を更新する。
     * @param advisorId アドバイザーID
     * @param requestDto 更新内容
     * @return
     */
    @PutMapping("/advisor/{id}")
    @ResponseBody
    public Long update(@PathVariable("id") Long advisorId, @RequestBody AdvisorUpdateRequestDto requestDto) {
        return advisorService.update(advisorId, requestDto);
    }

}
