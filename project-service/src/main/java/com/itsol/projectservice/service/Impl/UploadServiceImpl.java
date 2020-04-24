package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.service.UploadService;
import com.sun.deploy.association.utility.AppConstants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public Resource getFile(String fileName) {
        Path fileFromFolder= Paths.get("F://test//").resolve(fileName);
        try {
            Resource resourceOutput=new UrlResource(fileFromFolder.toUri());
            if (resourceOutput.exists() || resourceOutput.isReadable()) {
                System.out.println("Dữ liệu file lấy ra: "+resourceOutput);
                return resourceOutput;
            }
        } catch (MalformedURLException e) {
            System.out.println("Lỗi không lấy được File ra ");
            e.printStackTrace();
        }
        return null;
    }
}
