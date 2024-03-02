package org.example.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarDealerShipEntity.class)
public abstract class CarDealerShipEntity_ {

	public static volatile SingularAttribute<CarDealerShipEntity, String> zipCode;
	public static volatile SingularAttribute<CarDealerShipEntity, Integer> number;
	public static volatile SingularAttribute<CarDealerShipEntity, String> city;
	public static volatile SingularAttribute<CarDealerShipEntity, String> street;
	public static volatile SingularAttribute<CarDealerShipEntity, Long> id;

	public static final String ZIP_CODE = "zipCode";
	public static final String NUMBER = "number";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String ID = "id";

}

