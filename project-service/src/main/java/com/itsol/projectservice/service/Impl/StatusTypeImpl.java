package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.domain.Status;
import com.itsol.projectservice.domain.StatusType;
import com.itsol.projectservice.dto.IssueDto;
import com.itsol.projectservice.dto.StatusTypeDto;
import com.itsol.projectservice.repository.StatusTypeRepository;
import com.itsol.projectservice.service.StatusTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatusTypeImpl implements StatusTypeService {

    @Autowired
    private StatusTypeRepository statusTypeRepository;

    @Autowired
    private  ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true)
    public List<StatusTypeDto> getAllStatusType() {
        List<StatusType> list = statusTypeRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(statusType ->
                modelMapper.map(statusType, StatusTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(StatusTypeDto statusTypeDto) {
        StatusType statusType = modelMapper.map(statusTypeDto, StatusType.class);
        statusTypeRepository.save(statusType);
    }

    @Override
    public void update(StatusTypeDto statusTypeDto) {
        StatusType statusType = statusTypeRepository.getOne(statusTypeDto.getId());
        statusType.setName(statusTypeDto.getName());
    }

    @Override
    public void delete(long statusTypeID) {
        statusTypeRepository.deleteById(statusTypeID);
    }

    @Override
    public StatusTypeDto getStatusTypeId(Long statusTypeID) {
        Optional<StatusType> statustypeOptional = statusTypeRepository.findById(statusTypeID);
        return statustypeOptional
                .map(statusType->modelMapper.map(statusType, StatusTypeDto.class))
                .orElse(null);
    }


}
