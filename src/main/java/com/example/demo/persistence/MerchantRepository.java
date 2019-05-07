package com.example.demo.persistence;

import com.example.demo.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantRepository {

    List<Merchant> getAllMerchants();

    Optional<Merchant> getMerchantById(long id);

    List<Merchant> getMerchantsByName(String name);

    void updateMerchant(Merchant merchant);
}
