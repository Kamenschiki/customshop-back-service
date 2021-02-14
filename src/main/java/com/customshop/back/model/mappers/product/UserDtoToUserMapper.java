package com.customshop.back.model.mappers.product;

import com.customshop.back.model.dto.command.req.UserReqDto;
import com.customshop.back.model.entity.auth.User;
import com.customshop.back.model.mappers.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserDtoToUserMapper extends BasicMapper<User, UserReqDto> {

    UserDtoToUserMapper INSTANCE = Mappers.getMapper(UserDtoToUserMapper.class);

    @Override
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    User map(UserReqDto source);

    @Override
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    void merge(UserReqDto source, @MappingTarget User target);

}
