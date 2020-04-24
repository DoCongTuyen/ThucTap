package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.StatusDto;

import java.util.List;

public interface StatusService {
    List<StatusDto> getAllStatus();

    void create(StatusDto statusDto);

    void update(StatusDto statusDto);

    void delete(Long statusId);

    StatusDto getStatusID(Long statusId);
}
