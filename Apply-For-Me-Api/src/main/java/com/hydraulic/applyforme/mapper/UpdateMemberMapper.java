package com.hydraulic.applyforme.mapper;

import com.hydraulic.applyforme.model.domain.Member;
import com.hydraulic.applyforme.model.dto.UpdateMemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UpdateMemberMapper {


    UpdateMemberMapper INSTANCE = Mappers.getMapper(UpdateMemberMapper.class);

    UpdateMemberDto modelToDto(Optional<Member> member);
    Member dtoToModel(UpdateMemberDto memberDto);
}
