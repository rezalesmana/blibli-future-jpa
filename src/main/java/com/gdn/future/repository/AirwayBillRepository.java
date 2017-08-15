/**
 * 
 */
package com.gdn.future.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdn.future.model.AirwayBill;
import com.gdn.future.model.AirwayBillStatus;
import com.gdn.future.model.LogisticProvider;

/**
 * @author reza.lesmana
 *
 */
public interface AirwayBillRepository extends JpaRepository<AirwayBill, Long> {
	
	long countByLogisticProviderAndStatus(LogisticProvider logisticProvider, AirwayBillStatus status);

}
