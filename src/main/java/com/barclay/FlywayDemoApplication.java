package com.barclay;

import com.barclay.model.Car;
import com.barclay.model.Owner;
import com.barclay.model.Truck;
import com.barclay.model.Vehicle;
import com.barclay.service.OwnerService;
import com.barclay.service.VehicleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class FlywayDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(FlywayDemoApplication.class, args);

		OwnerService ownerService = context.getBean(OwnerService.class);

		Owner owner = new Owner();
		owner.setName("Bryan");

		owner = ownerService.save(owner);

		VehicleService vehicleService = context.getBean(VehicleService.class);

		Truck truck = new Truck();
		truck.set4wd(true);
		truck.setMake("Dodge");
		truck.setOwner(owner);

		Vehicle v1 = vehicleService.save(truck);

		Car car = new Car();
		car.setMake("Subaru");
		car.setType("Crosstrek");
		car.setOwner(owner);

		Vehicle v2 =vehicleService.save(car);

		System.out.println(v1.getId());
		System.out.println(v1.getMake());
		System.out.println(v2.getId());
		System.out.println(v2.getMake());

		List<Vehicle> vehicles = vehicleService.findAllVehicles();
		for(Vehicle vehicle: vehicles) {
			System.out.println(vehicle.getMake());
			System.out.println(vehicle.getOwner().getName());
		}
	}
}
