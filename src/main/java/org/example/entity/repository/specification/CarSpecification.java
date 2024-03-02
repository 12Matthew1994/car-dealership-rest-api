package org.example.entity.repository.specification;


import jakarta.persistence.criteria.*;
import org.example.entity.CarDealerShipEntity;
import org.example.entity.CarEntity;
import org.example.entity.CarEntity_;
import org.example.entity.filter.CarFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSpecification implements Specification<CarEntity> {

    @Autowired
    private CarFilter filter;

    public CarSpecification(CarFilter carFilter) {
    }


    @Override
    public Predicate toPredicate(Root<CarEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(filter.getBrand() !=null){
            predicates.add(criteriaBuilder.like(root.get(CarEntity_.BRAND), filter.getBrand() + "%"));
        }
        if(filter.getModel() !=null){
            predicates.add(criteriaBuilder.like(root.get(CarEntity_.MODEL), filter.getModel() + "%"));
        }
        if(filter.getKm() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CarEntity_.KM), filter.getKm()));
        }
        if(filter.getWeight() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CarEntity_.WEIGHT), filter.getWeight()));
        }
        if(filter.getYear() !=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CarEntity_.YEAR), filter.getYear()));
        }
        if (filter.getId() != null) {
            Join<CarEntity, CarDealerShipEntity> carDealerShipJoin = root.join("carDealerShip");
            predicates.add(criteriaBuilder.equal(carDealerShipJoin.get("id"), filter.getId()));
        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }
}
