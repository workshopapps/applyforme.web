package com.hydraulic.applyforme.service.impl;

import com.hydraulic.applyforme.model.domain.Country;
import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.domain.Professional;
import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.professional.ApplicantDto;
import com.hydraulic.applyforme.model.enums.RoleType;
import com.hydraulic.applyforme.model.exception.ApplicantAlreadyExistException;
import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
import com.hydraulic.applyforme.repository.jpa.CountryJpaRepository;
import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
import com.hydraulic.applyforme.repository.jpa.ProfessionalJpaRepository;
import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
import com.hydraulic.applyforme.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    private final PasswordEncoder passwordEncoder;
    private  final ProfessionalJpaRepository jpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private  final RoleJpaRepository roleJpaRepository;

    private final CountryJpaRepository countryRepository;

    @Override
    public String addApplicant(ApplicantDto body) {
        final String RESPONSE = "Applicant successfully saved";
        boolean exist = memberJpaRepository.existsByEmailAddress(body.getEmailAddress());
        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.PROFESSIONAL.getValue());
        if (exist) {
            throw new ApplicantAlreadyExistException();
        }
        if (existingRole.isEmpty()){
            throw new RoleNotFoundException(RoleType.PROFESSIONAL.getValue());
        }

        Member member = this.convertToMember(body);
        Professional professional = this.convertToProfessional(body);
        Member savedMember = memberJpaRepository.save(member);
        professional.setMember(savedMember);
        jpaRepository.save(professional);

        return RESPONSE;
    }

    private Date formatDate(String date) {
        Date formattedDate = new Date();
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyy-MM-dd");
          formattedDate = dateFormatter.parse(date);
        } catch (ParseException parseException){
            parseException.getMessage();
        }
        return formattedDate;
    }

    private Member convertToMember(ApplicantDto data){

        Country applicantNationality =  countryRepository.findByTitleIgnoreCase(data.getNationality());
        Country country = countryRepository.save(applicantNationality);
        Country applicantCountryOfResidence = countryRepository.findByTitleIgnoreCase(data.getCountryOfResidence());
        Country persistedCountryOfResidence = countryRepository.save(applicantCountryOfResidence);
        Member member = Member.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .emailAddress(data.getEmailAddress())
                .currentJobTitle(data.getCurrentJobTitle())
                .city(data.getCity())
                .state(data.getState())
                .password(passwordEncoder.encode(data.getPassword()))
                .phoneNumber(data.getPhoneNumber())
                .dateOfBirth(this.formatDate(data.getDateOfBirth()))
                .nationality(country)
                .countryOfResidence(persistedCountryOfResidence)
                .active(data.getActive())
                .avatar(data.getAvatar())
                .build();

                return member;
    }

    private Professional convertToProfessional(ApplicantDto data){
        Professional professional = Professional.builder()
                .availableForInterview(data.isAvailableForInterview())
                .facebookLink(data.getFacebookLink())
                .instagramLink(data.getInstagramLink())
                .linkedinLink(data.getLinkedinLink())
                .otherLink1(data.getOtherLink1())
                .otherLink2(data.getOtherLink2())
                .otherLink3(data.getOtherLink3())
                .hobbies(data.getHobbies())
                .twitterLink(data.getTwitterLink())
                .build();
        return professional;
    }

}
