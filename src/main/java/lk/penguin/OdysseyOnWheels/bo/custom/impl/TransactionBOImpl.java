package lk.penguin.OdysseyOnWheels.bo.custom.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lk.penguin.OdysseyOnWheels.bo.custom.TransactionBO;
import lk.penguin.OdysseyOnWheels.controller.AddedCartFormController;
import lk.penguin.OdysseyOnWheels.controller.TransactionFormController;
import lk.penguin.OdysseyOnWheels.dto.VehicleDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class TransactionBOImpl implements TransactionBO {
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

}