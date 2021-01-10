package com.tsunagi.app.advisor.dto;

import com.tsunagi.app.constant.expertise.Expertise;
import com.tsunagi.app.constant.gender.Gender;
import com.tsunagi.app.domain.advisor.Advisor;
import lombok.Getter;

@Getter
public class AdvisorDto {

    private Long id;
    private String name;
    private Long age;
    private Gender gender;
    private String introduce;
    private Expertise expertise;

    public AdvisorDto(Advisor advisor) {
        this.id = advisor.getId();
        this.name = advisor.getName();
        this.age = advisor.getAge();
        this.gender = advisor.getGender();
        this.introduce = advisor.getIntroduce();
        this.expertise = advisor.getExpertise();
    }
}
