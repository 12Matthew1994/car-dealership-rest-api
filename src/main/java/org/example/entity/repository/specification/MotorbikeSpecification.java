package org.example.entity.repository.specification;


import jakarta.persistence.criteria.*;
import org.example.entity.CarDealerShipEntity;
import org.example.entity.MotorbikeEntity;
import org.example.entity.MotorbikeEntity_;
import org.example.entity.filter.MotorbikeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeSpecification implements Specification<MotorbikeEntity> {

    @Autowired
    private MotorbikeFilter filter;

    public MotorbikeSpecification(MotorbikeFilter motorbikeFilter) {
    }


    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(filter.getBrand() !=null){
            predicates.add(criteriaBuilder.like(root.get(MotorbikeEntity_.BRAND), filter.getBrand() + "%"));
        }
        if(filter.getModel() !=null){
            predicates.add(criteriaBuilder.like(root.get(MotorbikeEntity_.MODEL), filter.getModel() + "%"));
        }
        if(filter.getKm() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(MotorbikeEntity_.KM), filter.getKm()));
        }
        if(filter.getWeight() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(MotorbikeEntity_.WEIGHT), filter.getWeight()));
        }
        if(filter.getYear() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(MotorbikeEntity_.YEAR), filter.getYear()));
        }
        if (filter.getId() != null) {
            Join<MotorbikeEntity, CarDealerShipEntity> carDealerShipJoin = root.join("carDealerShip");
            predicates.add(criteriaBuilder.equal(carDealerShipJoin.get("id"), filter.getId()));
        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

}