package com.tsunagi.app.advisor.controller;

import com.tsunagi.app.advisor.dto.AdvisorDto;
import com.tsunagi.app.advisor.dto.AdvisorListRequestDto;
import com.tsunagi.app.advisor.dto.AdvisorListResponseDto;
import com.tsunagi.app.advisor.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public AdvisorListResponseDto findAllBySearchCondition(@RequestBody AdvisorListRequestDto requestDto) {
        return advisorService.findAllBySearchCondition(requestDto);
    }

    /**
     * アドバイザーの詳細情報を取得する。
     * @param advisorId
     * @return アドバイザーの詳細情報
     */
    @GetMapping("/advisor/{id}")
    public AdvisorDto findById(@PathVariable("id") Long advisorId) {
        return advisorService.findById(advisorId);
    }

}
