package com.itsol.projectservice.rest;

import com.itsol.projectservice.service.Impl.NewsServiceImpl;
import com.itsol.projectservice.service.Impl.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin("*")
@RequestMapping("/upload")
public class UploadController {
    private static String UPLOAD_FOLDER = "F://test//";

    @Autowired
    private UploadServiceImpl uploadService;
    @PostMapping("")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Please select a file and try again");
        }

        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file .getOriginalFilename());
            Files.write(path, bytes);
            return ResponseEntity.status(HttpStatus.OK).body("File Uploaded Successfully !");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Upload fail");
        }
    }
    @GetMapping("/getFile/{nameFile:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFileByName(@PathVariable("nameFile") String nameFile){
        Resource resourceOutput=uploadService.getFile(nameFile);
        if (resourceOutput!=null){
            return ResponseEntity.ok(resourceOutput);
        }
        return ResponseEntity.ok(null);
    }
}
