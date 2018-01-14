package com.dylan.girl.repository;

import com.dylan.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer>{

    /**
     * 根据条件查询女生列表
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
