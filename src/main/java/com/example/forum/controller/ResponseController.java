package com.example.forum.controller;

import com.example.forum.model.Response;
import com.example.forum.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responses")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @PostMapping
    public Response createResponse(@RequestBody Response response) {
        return responseService.save(response);
    }

    @PutMapping("/{id}")
    public Response updateResponse(@PathVariable Long id, @RequestBody Response updatedResponse) {
        Response response = responseService.findById(id);
        if (response != null) {
            response.setMessage(updatedResponse.getMessage());
            return responseService.save(response);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteResponse(@PathVariable Long id) {
        responseService.deleteById(id);
    }
}
