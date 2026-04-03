package com.cts.controller;

import com.cts.dto.request.CreateWorkOrderRequest;
import com.cts.dto.response.WorkOrderResponse;
import com.cts.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService service;

    @PostMapping
    public ResponseEntity<WorkOrderResponse> create(
            @RequestBody CreateWorkOrderRequest dto,
            @RequestHeader("USER ID") Integer userId) {

        return new ResponseEntity<>(service.createWorkOrder(dto, userId), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getWorkOrderById(id));
    }
}