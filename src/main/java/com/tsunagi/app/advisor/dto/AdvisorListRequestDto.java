package com.tsunagi.app.advisor.dto;

import com.tsunagi.app.constant.expertise.Expertise;
import com.tsunagi.app.constant.gender.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdvisorListRequestDto {
    private Expertise expertise;
    private Gender gender;

    @Builder
    public AdvisorListRequestDto(Expertise expertise, Gender gender) {
        this.expertise = expertise;
        this.gender = gender;
    }
}
