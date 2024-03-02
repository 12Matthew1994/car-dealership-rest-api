package org.example.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarEntity.class)
public abstract class CarEntity_ {

	public static volatile SingularAttribute<CarEntity, Boolean> isAvailable;
	public static volatile SingularAttribute<CarEntity, Integer> km;
	public static volatile SingularAttribute<CarEntity, Integer> year;
	public static volatile SingularAttribute<CarEntity, CarDealerShipEntity> carDealerShip;
	public static volatile SingularAttribute<CarEntity, Integer> weight;
	public static volatile SingularAttribute<CarEntity, String> model;
	public static volatile SingularAttribute<CarEntity, Long> id;
	public static volatile SingularAttribute<CarEntity, String> brand;
	public static volatile SingularAttribute<CarEntity, Date> dateAdded;

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

