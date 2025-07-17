package com.BankTable.BankTable.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.Month;
import java.util.Date;

@Entity
@Table(name = "disbursement_info")
@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
public class User {

    @Id
    //@PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Account name is mandatory")
    private String account_name;
    @NotBlank(message = "Loan Account number is required")
    private String loan_account_number;
    @NotNull(message = "Disbursement date is required")
    @PastOrPresent(message = "Disbursement date cannot be in the future")
    private Date disbursment_date;
    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @DecimalMin(value = "0.1", inclusive = true, message = "Rate of interest must be greater than 0")
    private double rate_of_interest;

    @NotBlank(message = "Tenure is required")
    private String tenure;

    @NotBlank(message = "Type of loan is required")
    private String type_of_loan;

    @PositiveOrZero(message = "Eligible security value must be non-negative")
    private double eligible_security_value;

    @Min(value = 0, message = "Security coverage must be zero or positive")
    private int security_coverage;

    @NotBlank(message = "Security details are required")
    private String security_details_as_per_sanction;

    private boolean client_identification_done_with_varification;

    private boolean guarantor_identification_done_with_varification;

    private boolean fund_utilization_ensured;

    @Min(value = 0, message = "Single borrower exposure limit must be non-negative")
    private int single_borrower_exposure_limit;

    private boolean compliance_with_credit_policy;

    @Size(max = 100, message = "Comments cannot exceed 250 characters")
    private String comments;

//    public long getSerialNumber() {
//        return serialNumber;
//    }
//
//    public void setSerialNumber(long serialNumber) {
//        this.serialNumber = serialNumber;
//    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getLoan_account_number() {
        return loan_account_number;
    }

    public void setLoan_account_number(String loan_account_number) {
        this.loan_account_number = loan_account_number;
    }

    public Date getDisbursment_date() {
        return disbursment_date;
    }

    public void setDisbursment_date(Date disbursment_date) {
        this.disbursment_date = disbursment_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate_of_interest() {
        return rate_of_interest;
    }

    public void setRate_of_interest(double rate_of_interest) {
        this.rate_of_interest = rate_of_interest;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getType_of_loan() {
        return type_of_loan;
    }

    public void setType_of_loan(String type_of_loan) {
        this.type_of_loan = type_of_loan;
    }

    public double getEligible_security_value() {
        return eligible_security_value;
    }

    public void setEligible_security_value(double eligible_security_value) {
        this.eligible_security_value = eligible_security_value;
    }

    public int getSecurity_coverage() {
        return security_coverage;
    }

    public void setSecurity_coverage(int security_coverage) {
        this.security_coverage = security_coverage;
    }

    public String getSecurity_details_as_per_sanction() {
        return security_details_as_per_sanction;
    }

    public void setSecurity_details_as_per_sanction(String security_details_as_per_sanction) {
        this.security_details_as_per_sanction = security_details_as_per_sanction;
    }

    public boolean isClient_identification_done_with_varification() {
        return client_identification_done_with_varification;
    }

    public void setClient_identification_done_with_varification(boolean client_identification_done_with_varification) {
        this.client_identification_done_with_varification = client_identification_done_with_varification;
    }

    public boolean isGuarantor_identification_done_with_varification() {
        return guarantor_identification_done_with_varification;
    }

    public void setGuarantor_identification_done_with_varification(boolean guarantor_identification_done_with_varification) {
        this.guarantor_identification_done_with_varification = guarantor_identification_done_with_varification;
    }

    public boolean isFund_utilization_ensured() {
        return fund_utilization_ensured;
    }

    public void setFund_utilization_ensured(boolean fund_utilization_ensured) {
        this.fund_utilization_ensured = fund_utilization_ensured;
    }

    public int getSingle_borrower_exposure_limit() {
        return single_borrower_exposure_limit;
    }

    public void setSingle_borrower_exposure_limit(int single_borrower_exposure_limit) {
        this.single_borrower_exposure_limit = single_borrower_exposure_limit;
    }

    public boolean isCompliance_with_credit_policy() {
        return compliance_with_credit_policy;
    }

    public void setCompliance_with_credit_policy(boolean compliance_with_credit_policy) {
        this.compliance_with_credit_policy = compliance_with_credit_policy;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comment) {
        this.comments = comment;
    }
}
