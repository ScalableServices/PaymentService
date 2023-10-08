

/*
 * This code is implemented as part of assignment given to group #3 for  
 * course Scalable Service
 * Assignment Group #3
 * Student Name : Deepish Sharma

 */

package  com.payment.PaymentService;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PaymentId;
    private Long OrderId;
    private Date PaymentDate;
    private String PaymentType;
    private BigDecimal Amount;
    private Long CustomerId;
    private Long EmployeeId;
    private String TransactionId;
    
    
    public Payment() {
    	
    }
    
    public Payment(Long orderId, Date paymentDate, String paymentType, 
            BigDecimal amount, Long customerId, Long employeeId, 
            String transactionId) {
 this.OrderId = orderId;
 this.PaymentDate = paymentDate;
 this.PaymentType = paymentType;
 this.Amount = amount;
 this.CustomerId = customerId;
 this.EmployeeId = employeeId;
 this.TransactionId = transactionId;
}

	/**
	 * @return the PaymentId
	 */
	public Long PaymentId() {
		return PaymentId;
	}
	/*
	  @param orderId the orderId to set
	 */
	public void setPaymentId(Long paymentId) {
		PaymentId = paymentId;
	}
	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return OrderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return PaymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return PaymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return Amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return CustomerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}
	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return EmployeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return TransactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

}