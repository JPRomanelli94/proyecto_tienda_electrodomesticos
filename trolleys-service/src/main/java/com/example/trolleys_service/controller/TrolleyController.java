package com.example.trolleys_service.controller;

import com.example.trolleys_service.dto.TrolleyDTO;
import com.example.trolleys_service.model.Trolleys;
import com.example.trolleys_service.service.ITrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trolleys")
public class TrolleyController {

    @Autowired
    private ITrolleyService serv_troll;

    @GetMapping("/all")
    public List<Trolleys> getTrolleys(){
        return serv_troll.getTrolleys();
    }

    @GetMapping("/id/{id}")
    public TrolleyDTO getTrolleysById(@PathVariable Long id){
        return serv_troll.getTrolleysById(id);
    }

    @PostMapping("/create")
    public String create_trolleys (@RequestBody Trolleys trolley){
        serv_troll.create_trolleys(trolley);
        return "The trolley was created correctly.";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_trolleys(@PathVariable Long id){
        serv_troll.delete_trolleys(id);
        return "The trolley was deleted correctly.";
    }

    @PutMapping("/edit/{id}")
    public String edit_trolleys (@PathVariable Long id, @RequestBody Trolleys trolley){
        serv_troll.edit_trolleys(id, trolley);
        return "The trolley was modified correctly.";
    }
}
