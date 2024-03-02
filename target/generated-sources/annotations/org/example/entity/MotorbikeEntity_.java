package org.example.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MotorbikeEntity.class)
public abstract class MotorbikeEntity_ {

	public static volatile SingularAttribute<MotorbikeEntity, Boolean> isAvailable;
	public static volatile SingularAttribute<MotorbikeEntity, Integer> km;
	public static volatile SingularAttribute<MotorbikeEntity, Integer> year;
	public static volatile SingularAttribute<MotorbikeEntity, CarDealerShipEntity> carDealerShip;
	public static volatile SingularAttribute<MotorbikeEntity, Integer> weight;
	public static volatile SingularAttribute<MotorbikeEntity, String> model;
	public static volatile SingularAttribute<MotorbikeEntity, Long> id;
	public static volatile SingularAttribute<MotorbikeEntity, String> brand;
	public static volatile SingularAttribute<MotorbikeEntity, Date> dateAdded;

	public static final String IS_AVAILABLE = "isAvailable";
	public static final String KM = "km";
	public static final String YEAR = "year";
	public static final String CAR_DEALER_SHIP = "carDealerShip";
	public static final String WEIGHT = "weight";
	public static final String MODEL = "model";
	public static final String ID = "id";
	public static final String BRAND = "brand";
	public static final String DATE_ADDED = "dateAdded";

}

