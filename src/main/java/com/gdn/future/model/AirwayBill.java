/**
 * 
 */
package com.gdn.future.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import lombok.Data;

/**
 * @author reza.lesmana
 *
 */
@Data
@Entity
@Table(name = "AIRWAY_BILL")
public class AirwayBill implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -5289792632487380854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "AWB_NUMBER", nullable = false, unique = true, length = 25)
	private String airwayBillNumber;
	
	@Column(name = "STATUS", nullable = false)
    @Type(type = "com.gdn.future.datatype.PGEnumUserType",
            parameters = {@Parameter(name = "enumClassName",
                    value = "com.gdn.future.model.AirwayBillStatus")})
	private AirwayBillStatus status;
	
	@ManyToOne
    @JoinColumn(name = "LOGISTIC_PROVIDER_FK")
	private LogisticProvider logisticProvider;
    
}
