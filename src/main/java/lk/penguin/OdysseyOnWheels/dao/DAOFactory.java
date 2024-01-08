package lk.penguin.OdysseyOnWheels.dao;

import lk.penguin.OdysseyOnWheels.dao.custom.impl.CountriesDAOImpl;

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
            default:
                return null;
        }
    }
}
