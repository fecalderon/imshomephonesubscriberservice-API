package wpwa.application.model;

import lombok.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subcribers")
public class Subscriber {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "domain")
    private String domain;

    @Column(name = "status")
    private String status;

//    @Column(name = "features")
//    private static String[] features = {"callForwardNoReply"};

}
