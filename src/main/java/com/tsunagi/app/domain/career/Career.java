package com.tsunagi.app.domain.career;

import com.tsunagi.app.domain.advisor.Advisor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Career {

    @Id
    private long advisorId;
    private String overview;

    @ManyToOne
    private Advisor advisor;

}
