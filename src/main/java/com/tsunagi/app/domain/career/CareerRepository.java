package com.tsunagi.app.domain.career;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CareerのCRUDを生成
 * CareerのEntityクラスの同じパッケージ内で管理する必要がある。
 */
public interface CareerRepository  extends JpaRepository<Career, Long> {
}
