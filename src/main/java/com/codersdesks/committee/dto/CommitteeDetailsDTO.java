package com.codersdesks.committee.dto;

import com.codersdesks.committee.entity.CommitteeDetails;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CommitteeDetailsDTO extends BaseDTO{
    private Long committee_id;
    private String committee_name;
    private long org_id;
    private Double monthly_share;
    private Double loan_interest_rate;
    private Double loan_limit;

    public CommitteeDetails dtoToCommitteeDetails(){
        CommitteeDetails committeeDetails = new CommitteeDetails();
        BeanUtils.copyProperties(this,committeeDetails);
        return committeeDetails;
    }
}
