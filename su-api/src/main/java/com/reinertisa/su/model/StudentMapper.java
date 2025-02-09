package com.reinertisa.su.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UniversityClassMapper.class})
public interface StudentMapper {

    @Mapping(source = "studentName", target = "name")
    @Mapping(source = "studentEmail", target = "email")
    @Mapping(source = "universityClassesRequest", target = "universityClasses")
    Student toEntityFromRequest(StudentRequest studentRequest);

    @Mapping(source = "name", target = "studentName")
    @Mapping(source = "email", target = "studentEmail")
    @Mapping(source = "universityClasses", target = "universityClassesDto")
    StudentDto toDtoFromEntity(Student student);

    List<StudentDto> toDtoListFromEntityList(List<Student> students);
}
