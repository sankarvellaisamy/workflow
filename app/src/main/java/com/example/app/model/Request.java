package com.example.app.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Request {
    private String id;
    private String category;
    private String description;
    private String tenantId;
    private MetaData meta;
    private User requester;
    private TransitionStatus status;
    private Integer createdBy;
    private LocalDate createdAt;

    public void validateTransition(Request request, User user) {
        if(request.createdBy.equals(user.getId())) {
            throw new RuntimeException("Requester cannot approve their own request");
        }
        if(!user.getId().equals(request.getRequester().getId())) {
            throw new RuntimeException("Only Requester can change the status");
        }
        if(UserRole.MANAGER.equals(request.getRequester().getRole())) {
            if(request.getStatus() != TransitionStatus.PENDING) {
                throw new RuntimeException("Invalid status transition for MANAGER");
            }
        } else if(UserRole.FINANCE.equals(request.getRequester().getRole())) {
            if(request.getStatus() != TransitionStatus.IN_REVIEW) {
                throw new RuntimeException("Invalid status transition for FINANCE");
            }
        } else if(UserRole.LEGAL.equals(request.getRequester().getRole())) {
            if(request.getStatus() != TransitionStatus.APPROVED || request.getStatus() != TransitionStatus.REJECTED) {
                throw new RuntimeException("Invalid status transition for LEGAL");
            }
        } else {
            throw new RuntimeException("Unauthorized user role");
        }
    }
}
