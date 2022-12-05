package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.SalaryRange;

import java.util.List;

public interface SalaryRangeRepository {

    List<SalaryRange> getAll();

    List<SalaryRange> getAll(Integer pageOffSet);

    SalaryRange getOne(Long id);

    SalaryRange getRef(Long id);

    SalaryRange saveOne(SalaryRange country);

    SalaryRange updateOne(SalaryRange country);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();
    
}
