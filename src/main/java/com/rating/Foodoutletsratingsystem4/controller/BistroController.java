package com.rating.Foodoutletsratingsystem4.controller;

import com.rating.Foodoutletsratingsystem4.entity.Bistro;
import com.rating.Foodoutletsratingsystem4.service.BistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BistroController {
    private BistroService bistroService;

    @Autowired
    public BistroController(BistroService bistroService) {
        this.bistroService = bistroService;
    }

    @GetMapping("/outlets/new-bistro")
    public String createBistroForm(Model model){
        Bistro bistro = new Bistro();
        model.addAttribute("bistro",bistro);
        return "new-bistro";
    }

    @PostMapping("/bistros")
    public String saveBistro(@ModelAttribute("bistro") Bistro bistro){
        bistroService.saveBistro(bistro);
        return "redirect:/outlets";
    }

    @GetMapping("/bistros/edit/{id}")
    public String editBistro(@PathVariable Long id, Model model){
        model.addAttribute("bistro",bistroService.getBistroById(id));
        return "edit-bistro";
    }

    @PostMapping("/bistros/{id}")
    public String updateBistro(@PathVariable Long id, @ModelAttribute("bistro") Bistro bistro, Model model){
        Bistro existBistro = bistroService.getBistroById(id);
        existBistro.setId(id);
        existBistro.setName(bistro.getName());
        try {
            String [] splitRating = existBistro.getGiven_vote().split("-");
            double sumOfRatings = 0;
            try {
                for (String s : splitRating) {
                    sumOfRatings += Double.parseDouble(s);
                }
                if (Integer.parseInt(bistro.getCurrent_vote()) >= 0 ) {
                    double rating = (sumOfRatings+Double.parseDouble(bistro.getCurrent_vote()))/(splitRating.length+1);
                    String calculatedRating = String.format("%.2f",rating);
                    existBistro.setRating(calculatedRating);
                    existBistro.setRange(bistro.getRange());
                    existBistro.setHours(bistro.getHours());
                    existBistro.setCity(bistro.getCity());
                    existBistro.setGiven_vote(bistro.getGiven_vote()+"-"+bistro.getCurrent_vote());
                    existBistro.setCurrent_vote(bistro.getCurrent_vote());
                    bistroService.updateBistro(existBistro);
                }
            }catch (Exception ex){
                existBistro.setGiven_vote(bistro.getCurrent_vote());
                existBistro.setCurrent_vote(bistro.getCurrent_vote());
                bistroService.updateBistro(existBistro);
            }
        }catch (Exception e){
        }
        return "redirect:/outlets";
    }

    @GetMapping("/bistros/{id}")
    public String deleteBistro(@PathVariable Long id){
        bistroService.deleteBistroByid(id);
        return "redirect:/outlets";
    }
}
