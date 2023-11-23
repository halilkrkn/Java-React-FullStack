package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.VehicleRepository;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.vehicle.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.UpdateVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public void add(AddVehicleRequest addVehicleRequest) {

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(addVehicleRequest.getBrand());
        vehicle.setModel(addVehicleRequest.getModel());
        vehicle.setYears(addVehicleRequest.getYears());
        vehicle.setPlateNumber(addVehicleRequest.getPlateNumber());
        vehicle.setPrice(addVehicleRequest.getPrice());
        vehicle.setStatus(addVehicleRequest.getStatus());

        vehicleRepository.save(vehicle);

    }

    @Override
    public void update(Integer id, UpdateVehicleRequest updateVehicleRequest) {

            Vehicle vehicle = vehicleRepository.findById(id).orElseThrow();
            vehicle.setBrand(updateVehicleRequest.getBrand());
            vehicle.setModel(updateVehicleRequest.getModel());
            vehicle.setYears(updateVehicleRequest.getYears());
            vehicle.setPlateNumber(updateVehicleRequest.getPlateNumber());
            vehicle.setPrice(updateVehicleRequest.getPrice());
            vehicle.setStatus(updateVehicleRequest.getStatus());

            vehicleRepository.save(vehicle);

    }

    @Override
    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}