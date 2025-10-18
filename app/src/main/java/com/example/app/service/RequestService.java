package com.example.app.service;

import com.example.app.model.Message;
import com.example.app.model.Request;
import com.example.app.model.Response;
import com.example.app.model.User;
import com.example.app.repository.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRequestRepository repository;
    //Can be replace with kafka event on process request
    public Response processRequest(Request request, User user) {
        //validate request by user role
        user = jwtService.validateUser(user);
        request.validateTransition(request, user);
        saveTransition(request);
        return Response.builder()
                .data(Message.builder().status("Success")
                        .message("Request processed successfully")
                        .build())
                .status("SUCCESS")
                .build();
    }

    private void saveTransition(Request request) {
        repository.saveRequest(request);
    }

    public List<Request> listRequests(int page, int size, User user) {
        user = jwtService.validateUser(user);
        return repository.findAll(user.getTenantId(), page, size);
    }

    public Response findRequestById(String requestId) {
        return repository.findRequestById(requestId);
    }

}
