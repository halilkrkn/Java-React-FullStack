package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.VehicleRepository;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.vehicle.request.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.request.UpdateVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public void add(AddVehicleRequest addVehicleRequest) {

        if (vehicleRepository.existsByPlateNumber(addVehicleRequest.getPlateNumber())) {
            throw new RuntimeException("Plate number already exists");
        }

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

        if (!vehicleRepository.existsByVehicleId(id)) {
            throw new RuntimeException("Vehicle not found");
        }
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

    @Override
    public List<GetListVehicleResponse> findByPlateNumber(String plateNumber) {
        return vehicleRepository.findByPlateNumber(plateNumber)
                .stream()
                .map((vehicle) -> new GetListVehicleResponse(
                        vehicle.getVehicleId(),
                        vehicle.getBrand(),
                        vehicle.getModel(),
                        vehicle.getYears(),
                        vehicle.getPlateNumber(),
                        vehicle.getPrice(),
                        vehicle.getStatus()
                ))
                .toList();
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicleRepository.findById(id).orElseThrow();
    }


}
