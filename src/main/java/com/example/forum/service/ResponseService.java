package com.example.forum.service;

import com.example.forum.model.Response;
import com.example.forum.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    public Response save(Response response) {
        return responseRepository.save(response);
    }

    public void deleteById(Long id) {
        responseRepository.deleteById(id);
    }
}
