package org.example.entity.repository;


import org.example.entity.MotorbikeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MotorbikeRepository extends JpaRepository<MotorbikeEntity, Long>, JpaSpecificationExecutor<MotorbikeEntity> {

    Page<MotorbikeEntity> findAll(Pageable page);

}
