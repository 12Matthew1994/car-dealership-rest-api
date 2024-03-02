package org.example.entity.repository.specification;

import jakarta.persistence.criteria.*;
import org.example.entity.CarDealerShipEntity;
import org.example.entity.CaravanEntity;
import org.example.entity.CaravanEntity_;
import org.example.entity.filter.CaravanFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CaravanSpecification implements Specification<CaravanEntity> {

    @Autowired
    private CaravanFilter filter;

    public CaravanSpecification(CaravanFilter caravanFilter) {
    }

    @Override
    public Predicate toPredicate(Root<CaravanEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if  (filter.getBrand()!=null){
            predicates.add(criteriaBuilder.like(root.get(CaravanEntity_.BRAND), filter.getBrand() + "%"));
        }
        if (filter.getModel()!=null){
            predicates.add(criteriaBuilder.like(root.get(CaravanEntity_.MODEL), filter.getModel() + "%"));
        }
        if (filter.getKm()!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CaravanEntity_.KM), filter.getKm()));
        }
        if (filter.getYear()!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CaravanEntity_.YEAR), filter.getYear()));
        }
        if (filter.getWeight()!=null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(CaravanEntity_.WEIGHT), filter.getWeight()));
        }
        if (filter.getId()!=null){
            Join<CaravanEntity, CarDealerShipEntity> carDealerShipJoin = root.join("carDealerShip");
            predicates.add(criteriaBuilder.equal(carDealerShipJoin.get("id"), filter.getId()));
        }
        return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));

    }
}
