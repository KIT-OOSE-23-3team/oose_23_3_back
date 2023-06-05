package com.example.oose_23_3_back.managementcontrol.service;

import com.example.oose_23_3_back.managementcontrol.entity.RentalOffice;
import com.example.oose_23_3_back.managementcontrol.repository.BicycleRepository;
import com.example.oose_23_3_back.managementcontrol.entity.Bicycle;
import com.example.oose_23_3_back.managementcontrol.repository.RentalOfficeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BicycleService {
    private final BicycleRepository bicycleRepository;
    private final RentalOfficeService rentalOfficeService;

    public void bicycleSave(Bicycle bicycle) {
        RentalOffice rentalOffice = rentalOfficeService.rentalOfficeFindById(bicycle.getRentalOffice().getRentalOfficeNum());
        bicycle.setRentalOffice(rentalOffice);
        System.out.println(bicycle);
        this.bicycleRepository.save(bicycle);
    }

    public List<Bicycle> findBicycleByRentalOffice(RentalOffice rentalOffice) {
        return bicycleRepository.findByRentalOffice(rentalOffice);
    }

    public boolean rentalBicycle(Bicycle bicycle) {
        bicycle.setIsRented(true);
        this.bicycleRepository.save(bicycle);

        return true;
    }
}
