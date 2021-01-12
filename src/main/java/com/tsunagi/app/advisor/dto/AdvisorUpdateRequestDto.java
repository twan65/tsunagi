package com.tsunagi.app.advisor.dto;

import com.tsunagi.app.constant.expertise.Expertise;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AdvisorUpdateRequestDto {

    private String name;
    private String introduce;
    private Expertise expertise;
    // TODO: 経歴

    @Builder
    public AdvisorUpdateRequestDto(String name, Long age, String introduce, Expertise expertise) {
        this.name = name;
        this.introduce = introduce;
        this.expertise = expertise;
    }

}
