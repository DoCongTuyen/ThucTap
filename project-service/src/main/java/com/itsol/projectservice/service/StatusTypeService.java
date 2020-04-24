package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.StatusDto;
import com.itsol.projectservice.dto.StatusTypeDto;

import java.util.List;

public interface StatusTypeService {
    List<StatusTypeDto> getAllStatusType();

    void create(StatusTypeDto statusTypeDto);

    void update(StatusTypeDto statusTypeDto);

    void delete(long statusTypeID);

    StatusTypeDto getStatusTypeId(Long statusTypeID);
}
