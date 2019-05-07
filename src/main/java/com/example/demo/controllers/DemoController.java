package com.example.demo.controllers;

import com.example.demo.model.Merchant;
import com.example.demo.persistence.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/merchants")
public class DemoController {

    private final MerchantRepository merchantRepository;

    public DemoController(@Autowired MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @GetMapping
    public ModelAndView getMerchants(@RequestParam(value = "name", required = false) String name) {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");

        final List<Merchant> merchants;
        if (name == null) {
            merchants = merchantRepository.getAllMerchants();
        } else {
            merchants = merchantRepository.getMerchantsByName(name);
        }

        modelAndView.getModel().put("merchants", merchants);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getMerchantById(@PathVariable("id") long id) {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");

        final Optional<Merchant> merchant = merchantRepository.getMerchantById(id);

        modelAndView.getModel().put("merchants", merchant.stream().collect(Collectors.toList()));
        return modelAndView;
    }

    @PostMapping(consumes = "application/json")
    public ModelAndView postMerchant(@RequestBody Merchant merchant) {

        merchantRepository.updateMerchant(merchant);

        return getMerchants(null);
    }
}
