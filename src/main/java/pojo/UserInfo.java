package pojo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "root")
public class UserInfo {
    private String city;
    private String firstName;
    private String lastName;
    private String state;
}
