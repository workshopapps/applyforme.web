package com.hydraulic.applyforme.model.dto.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SubmissionResponse {

    private Collection<?> content;

    private int pageNo;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;
}

