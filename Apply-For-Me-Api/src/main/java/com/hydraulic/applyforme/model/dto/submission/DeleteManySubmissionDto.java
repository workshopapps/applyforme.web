package com.hydraulic.applyforme.model.dto.submission;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeleteManySubmissionDto {

    List<Long> ids;
}
