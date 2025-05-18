package com.demo1.service;

import com.demo1.dao.UploadDao;
import com.demo1.dao.UploadDaoImp;

public class UploadServiceImp implements UploadService{
    public UploadDao uploadDao;
    public UploadServiceImp() {
        uploadDao = new UploadDaoImp();
    }
    @Override
    public boolean addUpload(String fileName, String description) {
        return uploadDao.addUpload(fileName, description);
    }
}
