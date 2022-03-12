package wpwa.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wpwa.application.exception.ResourceNotFoundException;
import wpwa.application.model.Subscriber;
import wpwa.application.repository.SubscriberRepository;

@SpringBootApplication
public class ImshomephonesubscriberserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ImshomephonesubscriberserviceApplication.class, args);
	}

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Override
	public void run(String... args) throws Exception {
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber("18675181010");
		subscriber.setUsername("16045906403");
		subscriber.setPassword("p@ssw0rd!");
		subscriber.setDomain("ims.mnc660.mcc302.3gppnetwork.org");
		subscriber.setStatus("ACTIVE");
		subscriberRepository.save(subscriber);
	}
}
