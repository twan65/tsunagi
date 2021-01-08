package com.tsunagi.app.advisor.dto;

import lombok.Getter;

import java.util.List;

/**
 * アドバイザー一覧の検索結果を保存するクラス。
 * インスタンス生成時は、Advisorを使用する必要がある。
 */
@Getter
public class AdvisorListResponseDto {

    private List<AdvisorDto> advisors;

    public AdvisorListResponseDto(List<AdvisorDto> advisors) {
        this.advisors = advisors;
    }
}
