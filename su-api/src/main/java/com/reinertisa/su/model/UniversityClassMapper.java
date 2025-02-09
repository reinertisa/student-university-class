package com.reinertisa.su.model;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversityClassMapper {

    @Mapping(source = "universityClassName", target = "name")
    UniversityClass toEntityFromRequest(UniversityClassRequest universityClassRequest);

    @Mappings({
            @Mapping(source = "name", target = "universityClassName"),
            @Mapping(source = "id", target = "universityClassId")
    })
    UniversityClassDto toDtoFromEntity(UniversityClass universityClass);

    List<UniversityClassDto> toDtoListFromEntityList(List<UniversityClass> universityClasses);
}
