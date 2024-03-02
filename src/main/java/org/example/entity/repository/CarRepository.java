package org.example.entity.repository;


import org.example.entity.CarEntity;
import org.example.entity.CaravanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarRepository extends JpaRepository<CarEntity, Long>, JpaSpecificationExecutor<CarEntity>  {

    Page<CarEntity>findAll(Pageable page);


}
