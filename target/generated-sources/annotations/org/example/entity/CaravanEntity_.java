package org.example.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CaravanEntity.class)
public abstract class CaravanEntity_ {

	public static volatile SingularAttribute<CaravanEntity, Boolean> isAvailable;
	public static volatile SingularAttribute<CaravanEntity, Integer> km;
	public static volatile SingularAttribute<CaravanEntity, Integer> year;
	public static volatile SingularAttribute<CaravanEntity, CarDealerShipEntity> carDealerShip;
	public static volatile SingularAttribute<CaravanEntity, Integer> weight;
	public static volatile SingularAttribute<CaravanEntity, String> model;
	public static volatile SingularAttribute<CaravanEntity, Long> id;
	public static volatile SingularAttribute<CaravanEntity, String> brand;
	public static volatile SingularAttribute<CaravanEntity, Date> dateAdded;

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

