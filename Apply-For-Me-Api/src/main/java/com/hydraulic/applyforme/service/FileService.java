package com.hydraulic.applyforme.service;

import com.hydraulic.applyforme.model.dto.FileDto;

public interface FileService {

    FileDto saveMemberPictures(String extension);

    FileDto saveCoverLetters(String extension);

    FileDto savePassports(String extension);

    FileDto saveResumes(String extension);
}
