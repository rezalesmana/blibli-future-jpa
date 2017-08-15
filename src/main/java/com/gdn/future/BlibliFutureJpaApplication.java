package com.gdn.future;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gdn.future.model.AirwayBill;
import com.gdn.future.model.AirwayBillStatus;
import com.gdn.future.model.LogisticProvider;
import com.gdn.future.repository.AirwayBillRepository;
import com.gdn.future.repository.LogisticProviderRepository;

import scala.annotation.meta.setter;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.gdn.future.repository"})
@EntityScan(basePackages = "com.gdn.future.model")
@EnableJpaRepositories(basePackages = {"com.gdn.future.repository"})
public class BlibliFutureJpaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BlibliFutureJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlibliFutureJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(LogisticProviderRepository logisticProviderRepository, AirwayBillRepository airwayBillRepository) {
		return (args) -> {
			LogisticProvider jne = new LogisticProvider();
			jne.setLogisticCode("JNE");
			jne.setLogisticName("PT TIKI JALUR NUGRAHA EKAKURIR");
			jne.setFee(new Float(15000));
			jne.setDiscount(new Float(0.025));
			jne = logisticProviderRepository.save(jne);
			List<LogisticProvider> list = logisticProviderRepository.findAll();
			for(LogisticProvider lp : list) {
				log.info(lp.toString());
			}
			Random rnd = new Random();
			for(int i = 0; i < 1000; i++) {
				AirwayBill awb = new AirwayBill();
				awb.setAirwayBillNumber("JNE" + (1000000 + rnd.nextInt(9000000)));
				awb.setStatus(rnd.nextInt(2) == 0 ? AirwayBillStatus.NEW : AirwayBillStatus.USED);
				awb.setLogisticProvider(jne);
				airwayBillRepository.save(awb);
			}
			long countJNEWithStatusNew = airwayBillRepository.countByLogisticProviderAndStatus(jne, AirwayBillStatus.NEW);
			log.info("JUMLAH AWB JNE DENGAN STATUS NEW : " + countJNEWithStatusNew);
		};
	}
}
