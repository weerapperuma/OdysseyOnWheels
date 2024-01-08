package lk.penguin.OdysseyOnWheels.dao;

import lk.penguin.OdysseyOnWheels.dao.custom.impl.*;

import java.security.PublicKey;

public class DAOFactory {
    public static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOType{
        COUNTRIES,CUSTOMER,EMPLOYEE,LANGUAGE,LOCATIONS,QUERY,RENT,RENT_DETAIL,USER,VEHICLE
    }

    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case COUNTRIES :
                return new CountriesDAOImpl();
            case LANGUAGE:
                return new LanguageDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case USER:
                return new UserDAOImpl();
            case RENT:
                return new RentDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case LOCATIONS:
                return new LocationsDAOImpl();
            case RENT_DETAIL:
                return new RentDetailDAOImpl();
            default:
                return null;
        }
    }
}
