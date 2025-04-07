package com.example.trolleys_service.service;


import com.example.trolleys_service.dto.TrolleyDTO;
import com.example.trolleys_service.model.Products;
import com.example.trolleys_service.model.Trolleys;
import com.example.trolleys_service.repository.IAPIProducts;
import com.example.trolleys_service.repository.ITrolleyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrolleyService implements ITrolleyService{

    @Autowired
    private ITrolleyRepository repo_troll;

    @Autowired
    private IAPIProducts api_troll;

    @Override
    public List<Trolleys> getTrolleys() {
        return repo_troll.findAll();
    }

    @Override
    public TrolleyDTO getTrolleysById(Long id) {

        Trolleys trolley = repo_troll.findById(id).orElse(null);

        List<Long> allAppliances = trolley.getTrolley_id_appliances();

        List<String> allProductsNames = new ArrayList<>();

        //For each
        for (Long appliance : allAppliances){
            if ((api_troll.getProductsById(appliance))!=null){
                Products nameProduct = api_troll.getProductsById(appliance);
                allProductsNames.add(nameProduct.getProduct_name());
            }
        }

        TrolleyDTO trolleysProd = new TrolleyDTO(trolley.getTrolley_id(), trolley.getTrolley_price(), allProductsNames);

        return trolleysProd;
    }

    @Override
    public void create_trolleys(Trolleys trolley) {
        repo_troll.save(trolley);
    }

    @Override
    public void delete_trolleys(Long id) {
        repo_troll.deleteById(id);
    }

    @Override
    public void edit_trolleys(Long id, Trolleys trolley) {

        List<Trolleys> allTrolleys = this.getTrolleys();

        //For each
        for (Trolleys trolleys: allTrolleys){
            if (trolleys.getTrolley_id().equals(id)){
                System.out.println("entra al if");
                trolleys.setTrolley_price(trolley.getTrolley_price());
                trolleys.setTrolley_id_appliances(trolley.getTrolley_id_appliances());
                repo_troll.save(trolleys);
            }
        }
    }
}