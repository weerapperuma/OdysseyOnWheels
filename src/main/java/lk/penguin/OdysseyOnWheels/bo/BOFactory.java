package lk.penguin.OdysseyOnWheels.bo;

import lk.penguin.OdysseyOnWheels.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory():boFactory;
    }
    public enum BOType{
        WELCOME,CUSTOMER,EMPLOYEE,TRANSACTION,RENT,VEHICLE
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case WELCOME:
                return new WelcomeBoImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case RENT:
                return new RentBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            default:
                return null;
        }
    }
}
