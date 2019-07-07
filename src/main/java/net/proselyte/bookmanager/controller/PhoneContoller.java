package net.proselyte.bookmanager.controller;

import net.proselyte.bookmanager.model.Phone;
import net.proselyte.bookmanager.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhoneContoller {
    private PhoneService phoneService;

    @Autowired(required = true)
    @Qualifier(value = "phoneService")
    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @RequestMapping(value = "phones",method = RequestMethod.GET)
    public String listPhones(Model model) {
        model.addAttribute("phone", new Phone());
        model.addAttribute("listPhones", this.phoneService.listPhones());

        return "phones";
    }
    @RequestMapping(value = "/removephone/{id}")
    public String removePhone(@PathVariable("id") int id) {
        this.phoneService.removePhone(id);

        return "redirect:/phones";
    }
    @RequestMapping(value = "/phones/add" , method = RequestMethod.POST)
    public String addPhone (@ModelAttribute("phone") Phone phone){
        if (phone.getId() == 0) {
            this.phoneService.addPhone(phone);
        } else {
            this.phoneService.updatePhone(phone);
        }
        return "redirect:/phones";
    }
    @RequestMapping(value = "/editphone/{id}")
    public String editPhone(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", this.phoneService.getPhoneById(id));
        model.addAttribute("listPhones", this.phoneService.listPhones());

        return "phones";
    }
}
