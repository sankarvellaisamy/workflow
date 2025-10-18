package com.example.app.repository;

import com.example.app.model.Request;
import com.example.app.model.Response;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class UserRequestRepository {
    public List<Request> findAll(String tenantId, int page, int size) {
        return null;
    }

    public Response findRequestById(String requestId) {
        return null;
    }

    public Response saveRequest(Request request) {
        return null;
    }
}
