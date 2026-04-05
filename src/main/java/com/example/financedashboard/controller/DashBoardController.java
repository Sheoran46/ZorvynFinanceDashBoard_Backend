package com.example.financedashboard.controller;


import com.example.financedashboard.dto.DashBoardSummaryResponse;
import com.example.financedashboard.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

    private final TransactionService transactionService;
    //public DashBoardController(TransactionService t){
        //this.transactionService = t;
    //}

    @GetMapping("/summary")
    @PreAuthorize("hasAnyRole(('ADMIN', 'VIEWER', 'ANALYST')")
    public ResponseEntity<DashBoardSummaryResponse> getDashBoardSummary(){
        DashBoardSummaryResponse response=transactionService.getDashBoardSummary();
        return ResponseEntity.ok(response);
    }
}
