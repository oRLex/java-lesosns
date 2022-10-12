package app.dto;

import app.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Person1Mapper {

  Person1Mapper INSTANCE = Mappers.getMapper( Person1Mapper.class );

  @Mapping(source = "name", target = "name")
  @Mapping(source = "extra", target = "extra")

  Person1 convert(Person p);

}
