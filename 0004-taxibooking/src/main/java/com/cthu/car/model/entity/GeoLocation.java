package com.cthu.car.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class GeoLocation {

	private double lattitude;
	private double longitude;
}
