package com.itsol.projectservice.service;

import org.springframework.core.io.Resource;

public interface UploadService {
    Resource getFile(String fileName);
}
