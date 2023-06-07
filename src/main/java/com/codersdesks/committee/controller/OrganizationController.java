package com.codersdesks.committee.controller;

import com.codersdesks.committee.dto.OrganizationDTO;
import com.codersdesks.committee.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/org/v1")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService orgService;

    @PostMapping("/create")
    public OrganizationDTO createOrg(@RequestBody OrganizationDTO dto){
        return orgService.createOrganization(dto);
    }
    @GetMapping("/all")
    public List<OrganizationDTO> getAll(){
        return orgService.fetchAll();
    }
}
