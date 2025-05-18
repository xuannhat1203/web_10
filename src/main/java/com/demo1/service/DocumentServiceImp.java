package com.demo1.service;

import com.demo1.dao.DocumentDao;
import com.demo1.dao.DocumentDaoImp;

public class DocumentServiceImp implements DocumentService {
    public DocumentDao documentDao;
    public DocumentServiceImp() {
        documentDao = new DocumentDaoImp();
    }
    @Override
    public boolean addDocument(String title, String description, String filePath) {
        return documentDao.addDocument(title, description, filePath);
    }
}
