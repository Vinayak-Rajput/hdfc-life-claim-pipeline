package com.hdfclife.model;

public class Claim {

    private final String claimId;
    private final int claimAmount;
    private final String policyId;
    private final String customerName;
    private final Urgency urgency;

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
        return String.format("CLAIM ID: %s | Amount: %s | Policy ID: %-20s | Customer Name: %-6s | Urgency: %-6s | ", claimId, claimAmount, policyId, customerName, claimAmount);
    }
}
