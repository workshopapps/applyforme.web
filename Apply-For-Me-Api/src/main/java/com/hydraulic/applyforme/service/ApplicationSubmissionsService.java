package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.view.ApplicationSubmissionsResponse;

import java.util.List;

public interface ApplicationSubmissionsService {

    List<ApplicationSubmissionsResponse> getAllApplicationSubmissions(int offset, int pageSize);
}
