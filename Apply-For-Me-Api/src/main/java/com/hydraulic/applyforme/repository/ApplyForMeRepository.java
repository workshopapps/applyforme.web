package com.hydraulic.applyforme.repository;

import com.hydraulic.applyforme.model.domain.ApplyForMe;
import com.hydraulic.applyforme.model.domain.Submission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApplyForMeRepository {

    List<ApplyForMe> getAll(Integer pageOffset);

    ApplyForMe getOne(Long id);

    ApplyForMe saveOne(ApplyForMe body);

    ApplyForMe updateOne(ApplyForMe body);

    boolean remove(Long id);

    boolean removeMany(List<Long> ids);

    boolean removeAll();


}
