package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import lk.penguin.OdysseyOnWheels.bo.custom.VehicleBO;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.QueryDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.VehicleDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.QueryDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.VehicleDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.entity.Vehicle;
import lk.penguin.OdysseyOnWheels.util.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO=(VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.VEHICLE);
    QueryDAO queryDAO=(QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.QUERY);

    @Override
    public ArrayList<VehicleDTO> loadAllWithoutRented(String startingDay,String endingDay) throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles= queryDAO.loadAll(startingDay,endingDay);
        ArrayList<VehicleDTO> dtos=new ArrayList<>();
        for(Vehicle vehicle:vehicles){
            dtos.add(new VehicleDTO(vehicle.getVehicleId(),vehicle.getVehicleType(),vehicle.getVehicleName(),vehicle.getPerDay80Km(),vehicle.getExcessMileage(),vehicle.getStatus()));
        }
        return dtos;
    }
    @Override
    public VehicleDTO get(String id) throws SQLException, ClassNotFoundException {
        Vehicle vehicle=vehicleDAO.get(id);
        return new VehicleDTO(vehicle.getVehicleId(),vehicle.getVehicleType(),vehicle.getVehicleName(),vehicle.getPerDay80Km(),vehicle.getExcessMileage(),vehicle.getStatus() );
    }

    @Override
    public ArrayList<VehicleDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles=vehicleDAO.getAll();
        ArrayList<VehicleDTO>vehicleDTOS=new ArrayList<>();
        for(Vehicle vehicle:vehicles){
            VehicleDTO vehicleDTO=new VehicleDTO(
                    vehicle.getVehicleId(),
                    vehicle.getVehicleType(),
                    vehicle.getVehicleName(),
                    vehicle.getPerDay80Km(),
                    vehicle.getExcessMileage(),
                    vehicle.getStatus()
            );
            vehicleDTOS.add(vehicleDTO);
        }
        return vehicleDTOS;
    }

    @Override
    public boolean update(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.update(new Vehicle(
                vehicleDTO.getVehicleId(),
                vehicleDTO.getVehicleType(),
                vehicleDTO.getVehicleName(),
                vehicleDTO.getPerDay80Km(),
                vehicleDTO.getExcessMileage(),
                vehicleDTO.getStatus()
        ));
    }

    @Override
    public boolean delete(String text) throws SQLException, ClassNotFoundException {
        return vehicleDAO.delete(text);
    }

    @Override
    public boolean ifExists(String text) throws SQLException, ClassNotFoundException {
        return vehicleDAO.ifExists(text);
    }

    @Override
    public ArrayList<VehicleDTO> search(String text) throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles=vehicleDAO.search(text);

        ArrayList<VehicleDTO> vehicleDTOS=new ArrayList<>();
        for(Vehicle vehicle:vehicles){
            VehicleDTO vehicleDTO=new VehicleDTO(
                    vehicle.getVehicleId(),
                    vehicle.getVehicleType(),
                    vehicle.getVehicleName(),
                    vehicle.getPerDay80Km(),
                    vehicle.getPerDay80Km(),
                    vehicle.getStatus()
            );
            vehicleDTOS.add(vehicleDTO);
        }
        return vehicleDTOS;
    }

    @Override
    public boolean save(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        return vehicleDAO.save(new Vehicle(
                vehicleDTO.getVehicleId(),
                vehicleDTO.getVehicleType(),
                vehicleDTO.getVehicleName(),
                vehicleDTO.getPerDay80Km(),
                vehicleDTO.getExcessMileage(),
                vehicleDTO.getStatus()
        ));
    }
}
