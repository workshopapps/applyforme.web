package com.hydraulic.applyforme.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Response {

    private Collection<?> content;

    private int pageNo;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;
}

