package com.ufopa.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.ufopa.spring.dto.ClienteDetalheDto;
import com.ufopa.spring.dto.ClienteResumoDto;
import com.ufopa.spring.model.Cliente;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

  ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

  ClienteResumoDto clienteToResumoDto(Cliente cliente);

  ClienteDetalheDto clienteToDetalheDto(Cliente cliente);

  @Mapping(source = "enviaEmail", target = "enviaEmail", defaultValue = "false")
  @Mapping(source = "rendaMedia", target = "rendaMedia", defaultValue = "0")
  Cliente clienteFromDto(ClienteDetalheDto cliente);

  Cliente clienteFromDto(ClienteDetalheDto detalheDto, @MappingTarget Cliente cliente);
}
