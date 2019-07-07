package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.Auto;
import net.proselyte.bookmanager.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AutoController {
    private AutoService autoService;

    @Autowired(required = true)
    @Qualifier(value = "autoService")
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }

    @RequestMapping(value = "autos", method = RequestMethod.GET)
    public String listAutos(Model model) {
        model.addAttribute("auto", new Auto());
        model.addAttribute("listAutos", this.autoService.listAutos());

        return "autos";
    }

    @RequestMapping(value = "removeauto/{id}")
    public String removeAuto(@PathVariable("id") int id) {
        this.autoService.removeAuto(id);

        return "redirect:/autos";
    }

    @RequestMapping(value = "editauto/{id}")
    public String editAuto(@PathVariable("id") int id, Model model) {
        model.addAttribute("auto", this.autoService.getAutoById(id));
        model.addAttribute("listAutos", this.autoService.listAutos());

        return "autos";
    }

    @RequestMapping(value = "/autos/add", method = RequestMethod.POST)
    public String addAuto(@Valid @ModelAttribute("auto") Auto auto) {
        if (auto.getId() == 0) {
            this.autoService.addAuto(auto);
        } else {
            this.autoService.updateAuto(auto);
        }
        return "redirect:/autos";
    }

    @RequestMapping(value = "/refreshtable")
    public String refresh(Model model) {
        model.addAttribute("auto", new Auto());
        model.addAttribute("listAutos", this.autoService.listAutos());

        return "autos";
    }
}
