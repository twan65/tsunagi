package com.tsunagi.app.domain.advisor;

import com.tsunagi.app.advisor.dto.AdvisorListRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * AdvisorのCRUDを生成
 * AdvisorのEntityクラスの同じパッケージ内で管理する必要がある。
 */
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

    /**
     * 検索条件でアドバイザー一覧を取得する。
     * @param requestDto　検索条件
     * @return アドバイザー一覧
     */
    @Query("SELECT a FROM advisor a WHERE a.expertise = :#{#condition.expertise} AND a.gender = :#{#condition.gender}")
    List<Advisor> findAll(@Param("condition") AdvisorListRequestDto requestDto);

}
