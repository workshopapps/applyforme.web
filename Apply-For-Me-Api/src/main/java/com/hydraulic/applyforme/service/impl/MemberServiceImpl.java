//package com.hydraulic.applyforme.service.impl;
//
//import com.hydraulic.applyforme.model.domain.Country;
//import com.hydraulic.applyforme.model.domain.Member;
//import com.hydraulic.applyforme.model.domain.Role;
//import com.hydraulic.applyforme.model.dto.authentication.SignupDto;
//import com.hydraulic.applyforme.model.dto.member.UpdateMemberDto;
//import com.hydraulic.applyforme.model.enums.RoleType;
//import com.hydraulic.applyforme.model.exception.EmailAlreadyExistsException;
//import com.hydraulic.applyforme.model.exception.MemberNotFoundException;
//import com.hydraulic.applyforme.model.exception.RoleNotFoundException;
//import com.hydraulic.applyforme.repository.MemberRepository;
//import com.hydraulic.applyforme.repository.MemberSecretCodeRepository;
//import com.hydraulic.applyforme.repository.jpa.MemberJpaRepository;
//import com.hydraulic.applyforme.repository.jpa.RoleJpaRepository;
//import com.hydraulic.applyforme.service.MemberService;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Slf4j
//@Service
//public class MemberServiceImpl implements MemberService {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    private MemberRepository repository;
//
//    private MemberJpaRepository jpaRepository;
//
//    @Autowired
//    private MemberSecretCodeRepository memberSecretCodeRepository;
//
//    @Autowired
//    private RoleJpaRepository roleJpaRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public MemberServiceImpl(MemberRepository repository, MemberJpaRepository jpaRepository) {
//        this.repository = repository;
//        this.jpaRepository = jpaRepository;
//    }
//
//    @Override
//    public Member findOne(Long id) {
//        Member member = repository.getOne(id);
//        if (member == null) {
//            throw new MemberNotFoundException(id);
//        }
//        return member;
//    }
//
//    @Override
//    @Transactional
//    public Member save(SignupDto body) {
//        boolean existingMember = jpaRepository.existsByEmailAddress(body.getEmailAddress());
//
//        if (existingMember) {
//            throw new EmailAlreadyExistsException();
//        }
//
//        Optional<Role> existingRole = roleJpaRepository.findByCode(RoleType.RECRUITER.getValue());
//
//        if (existingRole.isEmpty()) {
//            throw new RoleNotFoundException(RoleType.RECRUITER.getValue());
//        }
//
//        Member member = new Member();
//        member = modelMapper.map(body, Member.class);
//
//        member.addRole(existingRole.get());
//        member.setPassword(body.getPassword());
//
//        repository.saveOne(member);
//        String generatedSecretCode = generateSignUpCode();
//        memberSecretCodeRepository.saveSecretCode(generatedSecretCode);
//
//        return member;
//    }
//
//
//    /*
//    * This method helps to generate sign-up verification and was used in the method above
//    * to save the sign-up verification code into the DB as shown below.
//    * String generatedSecretCode = generateSignUpCode();
//       memberSecretCodeRepository.saveSecretCode(generatedSecretCode);
//    *
//    **/
//    private String generateSignUpCode(){
//        int[] numbers = new int[4];
//
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = (int) (Math.random() * 9);
//        }
//        String code = "" + numbers[0] + numbers[1] + numbers[2] + numbers[3] + "";
//        return  code;
//
//    @Override
//    @Transactional
//    public Member update(Long id, UpdateMemberDto body) {
//
//        Member existingMember = repository.getOne(id);
//
//        if (existingMember == null) {
//            throw new MemberNotFoundException(id);
//        }
//
//        Member member = new Member();
//        member = modelMapper.map(body, Member.class);
//        member.setId(id);
//        member.setNationality(Country.builder().id(body.getNationality()).build());
//        member.setCountryOfResidence(Country.builder().id(body.getCountryOfResidence()).build());
//
//        return repository.updateOne(member);
//    }
//}
