package com.codersdesks.committee;

import com.codersdesks.committee.dto.OrganizationDTO;
import com.codersdesks.committee.dto.UserDTO;
import com.codersdesks.committee.entity.Organization;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.time.Instant;

public class main {
    public static void main(String[] args) throws JsonProcessingException {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setCreated_by(1L);
        dto.setCreated_on(Timestamp.from(Instant.now()));
        dto.setIs_active(true);
        dto.setLogin_url("https://hello.com");
        dto.setName("sunday meeting");
        dto.setUnique_identifier("sunmeeting");
        dto.setOrgId(11L);
        dto.setLogo_url("https://logourl.com");
        //System.out.println(dto);
        Organization org = dto.dtoToOrganization();
        //System.out.println(org);

        OrganizationDTO dto1 = org.organizationToDTO();
       // System.out.println(dto1);

        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("1234567");
        userDTO.set_admin(false);
        userDTO.setEmail("hello@gm.com");
        userDTO.setCreated_by(1L);
        userDTO.setMobile("2324324235");
        userDTO.setIs_active(true);
        userDTO.setOrg_id(1L);
        userDTO.setRole_id(1L);
        userDTO.setUser_name("kuldeep");
        userDTO.set_admin(false);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println( mapper.writeValueAsString(userDTO));
    }
}
