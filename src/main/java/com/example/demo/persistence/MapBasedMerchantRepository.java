package com.example.demo.persistence;

import com.example.demo.model.Merchant;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Slf4j
public class MapBasedMerchantRepository implements MerchantRepository {

    private final ConcurrentMap<Long, Merchant> merchants = new ConcurrentHashMap<>();

    @Override
    public List<Merchant> getAllMerchants() {
        return new ArrayList<>(merchants.values());
    }

    @Override
    public Optional<Merchant> getMerchantById(long id) {
        return Optional.ofNullable(merchants.get(id));
    }

    @Override
    public List<Merchant> getMerchantsByName(String name) {
        return merchants.values()
                .stream()
                .filter(merchant -> name.equals(merchant.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        log.info("Saving Merchant: {}", merchant);
        merchants.put(merchant.getId(), merchant);
    }
}
