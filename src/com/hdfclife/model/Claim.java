package com.hdfclife.model;

public class Claim {

    private String claimId;
    private int claimAmount;
    private String policyId;
    private String customerName;
    private Urgency urgency;

    public Claim(String claimId, int claimAmount, String policyId, String customerName, Urgency urgency) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.policyId = policyId;
        this.customerName = customerName;
        this.urgency = urgency;
    }

    public String getClaimId() {
        return claimId;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Urgency: %-6s | Amount: %s", claimId, urgency, claimAmount);
    }
}
