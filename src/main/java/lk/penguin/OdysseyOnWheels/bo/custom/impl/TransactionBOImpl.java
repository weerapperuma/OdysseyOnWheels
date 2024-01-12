package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lk.penguin.OdysseyOnWheels.bo.custom.TransactionBO;
import lk.penguin.OdysseyOnWheels.controller.AddedCartFormController;
import lk.penguin.OdysseyOnWheels.controller.TransactionFormController;
import lk.penguin.OdysseyOnWheels.dao.DAOFactory;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.RentDetailDAO;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.RentDAOImpl;
import lk.penguin.OdysseyOnWheels.dao.custom.impl.RentDetailDAOImpl;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;
import lk.penguin.OdysseyOnWheels.util.TransactionUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class TransactionBOImpl implements TransactionBO {

    RentDetailDAO rentDetailDAO=(RentDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.RENT_DETAIL);
    public static ArrayList<VehicleDTO> addToCartVboxList;
    @Override
    public boolean addToCart(VehicleDTO dto){
        if(addToCartVboxList==null){
            addToCartVboxList=new ArrayList<>();
        }
        for(VehicleDTO existingDTO:addToCartVboxList){
            if(existingDTO.getVehicleId().equals(dto.getVehicleId())){
                return false;
            }
        }
        addToCartVboxList.add(dto);
        return true;
    }

    @Override
    public void delete(String addedCartCarID) throws IOException {
        Iterator<VehicleDTO> iterator = addToCartVboxList.iterator();
        while (iterator.hasNext()) {
            VehicleDTO dto = iterator.next();
            if (dto.getVehicleId().equals(addedCartCarID)) {
                iterator.remove();
            }
        }
        reloadVbox();
    }

    @Override
    public void reloadVbox() throws IOException {
        TransactionFormController.addCart.getChildren().clear();
        for(VehicleDTO dto:TransactionBOImpl.addToCartVboxList){
            FXMLLoader loader=new FXMLLoader(TransactionFormController.class.getResource("/view/addedCartForm.fxml"));
            Parent root=loader.load();
            AddedCartFormController addedCartFormController=loader.getController();


            addedCartFormController.setData(dto);
            TransactionFormController.addCart.getChildren().add(root);
        }
    }

    public void createRaw(VehicleDTO vehicleDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(TransactionFormController.class.getResource("/view/addedCartForm.fxml"));
        Parent root=loader.load();
        AddedCartFormController addedCartFormController=loader.getController();


        addedCartFormController.setData(vehicleDTO);
        TransactionFormController.addCart.getChildren().add(root);
    }
    @Override
    public boolean saveRentDetails() throws SQLException, ClassNotFoundException {
        TransactionUtil.startTransaction();
        boolean isSaved= rentDetailDAO.save(addToCartVboxList);
        if(isSaved){
            TransactionUtil.endTransaction();
        }else{
            TransactionUtil.rollBack();
            TransactionUtil.endTransaction();
        }

        return isSaved;
    }

}
