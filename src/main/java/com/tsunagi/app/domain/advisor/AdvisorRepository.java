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

    // TODO: 検索条件で検索をすること。パラメータ使用例は以下となる。
    // @Query("select u from User u where u.firstname = :#{#customer.firstname}")
    // List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);
    @Query("SELECT a FROM advisor a")
    List<Advisor> findAll(@Param("condition") AdvisorListRequestDto requestDto);

}
