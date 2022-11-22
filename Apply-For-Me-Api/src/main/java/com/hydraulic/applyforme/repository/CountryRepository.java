package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.Country;

import java.util.List;

public interface CountryRepository {

    List<Country> getAll();
    List<Country> getAll(Integer pageOffset);

    Country getOne(Long id);

    Country saveOne(Country country);

    Country updateOne(Country country);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
}
