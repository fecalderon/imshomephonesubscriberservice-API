package wpwa.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wpwa.application.model.Subscriber;
import org.springframework.stereotype.Repository;

public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
    //CRUD methods

}
