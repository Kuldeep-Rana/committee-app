package com.codersdesks.committee.service;

import com.codersdesks.committee.dto.OrganizationDTO;
import com.codersdesks.committee.entity.Organization;
import com.codersdesks.committee.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationDTO createOrganization(OrganizationDTO dto){
        Organization org = organizationRepository.save(dto.dtoToOrganization());
        return org.organizationToDTO();
    }

    public List<OrganizationDTO> fetchAll() {
        List<Organization> all = organizationRepository.findAll();
        return all.stream().map(organization -> organization.organizationToDTO()).toList();
    }

    public OrganizationDTO fetchById(long id) {
        return organizationRepository.findById(id).get().organizationToDTO();
    }
}
