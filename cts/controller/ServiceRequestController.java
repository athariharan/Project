package com.cts.controller;

import com.cts.api.ApiResponse;
import com.cts.dto.request.CreateServiceRequest;
import com.cts.dto.response.ServiceRequestResponse;
import com.cts.service.ServiceRequestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serv_req")
@RequiredArgsConstructor

public class ServiceRequestController {

    private final ServiceRequestService serviceRequestService;

    @PostMapping
    public ResponseEntity<ApiResponse<ServiceRequestResponse>> submit(
            @Valid @RequestBody CreateServiceRequest dto,
            @RequestParam Long citizenId) {

        ServiceRequestResponse response = serviceRequestService.submit(dto, citizenId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Service request submitted successfully", response));
    }

    
    @GetMapping("/my")
    public ResponseEntity<ApiResponse<List<ServiceRequestResponse>>> getMyRequests(
            @RequestParam Long citizenId) {

        List<ServiceRequestResponse> list = serviceRequestService.getBySubmitter(citizenId);
        return ResponseEntity.ok(ApiResponse.success("Fetched your service requests", list));
    }


    @GetMapping("/pending")
    public ResponseEntity<ApiResponse<List<ServiceRequestResponse>>> getPending() {
        List<ServiceRequestResponse> list = serviceRequestService.getPending();
        return ResponseEntity.ok(ApiResponse.success("Fetched pending requests", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceRequestResponse>> getById(
            @PathVariable Long id) {

        ServiceRequestResponse response = serviceRequestService.getById(id);
        return ResponseEntity.ok(ApiResponse.success("Fetched service request", response));
    }

    
    @PatchMapping("/{id}/validate")
    public ResponseEntity<ApiResponse<ServiceRequestResponse>> validate(
            @PathVariable Long id,
            @RequestParam Long dispatcherId) {

        ServiceRequestResponse response = serviceRequestService.validate(id, dispatcherId);
        return ResponseEntity.ok(ApiResponse.success("Request validated", response));
    }

    
    @PatchMapping("/{id}/reject")
    public ResponseEntity<ApiResponse<ServiceRequestResponse>> reject(
            @PathVariable Long id,
            @RequestParam Long dispatcherId) {

        ServiceRequestResponse response = serviceRequestService.reject(id, dispatcherId);
        return ResponseEntity.ok(ApiResponse.success("Request rejected", response));
    }
}