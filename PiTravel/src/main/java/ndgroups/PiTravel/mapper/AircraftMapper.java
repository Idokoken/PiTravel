package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.model.Aircraft;
import ndgroups.PiTravel.request.AircraftRequest;

public class AircraftMapper {
    public static Aircraft toAircraftEntity(AircraftRequest request){
        if(request == null) return  null;
        return Aircraft.builder()
                .aircraftName(request.getAircraftName())
                .code(request.getCode())
                .model(request.getModel())
                .manufacturer(request.getManufacturer())
                .seatingCapacity(request.getSeatingCapacity())
                .economySeats(request.getEconomySeats())
                .premiumEconomySeats(request.getPremiumEconomySeats())
                .businessSeat(request.getBusinessSeat())
                .firstClassSeat(request.getFirstClassSeat())
                .rangeKm(request.getRangeKm())
                .cruisingSpeedKmh(request.getCruisingSpeedKmh())
                .maxAltitudeFeet(request.getMaxAltitudeFeet())
                .yearOfManufacture(request.getYearOfManufacture())
                .registrationDate(request.getRegistrationDate())
                .nextMaintenanceDate(request.getNextMaintenanceDate())
                .aircraftStatus(request.getAircraftStatus())
                .isAvailable(request.isAvailable())
                .currentAirportId(request.getCurrentAirportId())
                .build();
    }

    public static AircraftDTO toAircraftDto(Aircraft aircraft){
        if(aircraft == null) return  null;
        return AircraftDTO.builder()
                .id(aircraft.getId())
                .aircraftName(aircraft.getAircraftName())
                .code(aircraft.getCode())
                .model(aircraft.getModel())
                .manufacturer(aircraft.getManufacturer())
                .seatingCapacity(aircraft.getSeatingCapacity())
                .economySeats(aircraft.getEconomySeats())
                .premiumEconomySeats(aircraft.getPremiumEconomySeats())
                .businessSeat(aircraft.getBusinessSeat())
                .firstClassSeat(aircraft.getFirstClassSeat())
                .rangeKm(aircraft.getRangeKm())
                .cruisingSpeedKmh(aircraft.getCruisingSpeedKmh())
                .maxAltitudeFeet(aircraft.getMaxAltitudeFeet())
                .yearOfManufacture(aircraft.getYearOfManufacture())
                .registrationDate(aircraft.getRegistrationDate())
                .nextMaintenanceDate(aircraft.getNextMaintenanceDate())
                .aircraftStatus(aircraft.getAircraftStatus())
                .isAvailable(aircraft.isAvailable())
                .currentAirportId(aircraft.getCurrentAirportId())
//                computed values
                .totalSeats(aircraft.getTotalSeats())
                .requiredMaintenance(aircraft.requiredMaintenance())
                .isOperational(aircraft.isOperational())
//                Audit
                .createdAt(aircraft.getCreatedAt())
                .updatedAt(aircraft.getUpdatedAt())
                .build();
    }

    public static Aircraft updateAircraftEntity(Aircraft aircraft, AircraftRequest request) {
        if (request.getAircraftName() != null) {
            aircraft.setAircraftName(request.getAircraftName());
        }
        if (request.getCode() != null) {
            aircraft.setCode(request.getCode());
        }
        if (request.getModel() != null) {
            aircraft.setModel(request.getModel());
        }
        if (request.getManufacturer() != null) {
            aircraft.setManufacturer(request.getManufacturer());
        }
        if (request.getSeatingCapacity() != null) {
            aircraft.setSeatingCapacity(request.getSeatingCapacity());
        }
        aircraft.setEconomySeats(request.getEconomySeats());
        aircraft.setPremiumEconomySeats(request.getPremiumEconomySeats());
        aircraft.setBusinessSeat(request.getBusinessSeat());
        aircraft.setFirstClassSeat(request.getFirstClassSeat());
        aircraft.setRangeKm(request.getRangeKm());
        aircraft.setCruisingSpeedKmh(request.getCruisingSpeedKmh());
        aircraft.setMaxAltitudeFeet(request.getMaxAltitudeFeet());
        aircraft.setYearOfManufacture(request.getYearOfManufacture());
        aircraft.setRegistrationDate(request.getRegistrationDate());
        aircraft.setNextMaintenanceDate(request.getNextMaintenanceDate());
        aircraft.setAircraftStatus(request.getAircraftStatus());
        aircraft.setAvailable(request.isAvailable());
        aircraft.setCurrentAirportId(request.getCurrentAirportId());


        return aircraft;
    }
}
