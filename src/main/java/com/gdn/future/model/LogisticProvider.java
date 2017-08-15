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
import javax.persistence.Table;

import lombok.Data;

/**
 * @author reza.lesmana
 *
 */
@Data
@Entity
@Table(name = "LOGISTIC_PROVIDER")
public class LogisticProvider implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8792536942741313724L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "LOGISTIC_CODE", nullable = false, unique = true, length =  15)
	private String logisticCode;
	
	@Column(name = "LOGISTIC_NAME", nullable = false, length = 100)
	private String logisticName;
	
	private Float fee;
	
	private Float discount;
}
