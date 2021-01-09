package com.tsunagi.app.domain.advisor;

import com.tsunagi.app.constant.expertise.Expertise;
import com.tsunagi.app.constant.gender.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AdvisorのCRUDを生成
 * AdvisorのEntityクラスの同じパッケージ内で管理する必要がある。
 */
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

    List<Advisor> findByExpertiseContaining(Expertise expertise);
    List<Advisor> findByGenderContaining(Gender gender);
    List<Advisor> findByExpertiseAndGenderContaining(Expertise expertise, Gender gender);

}
