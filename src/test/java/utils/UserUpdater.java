package utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "first_name", "last_name", "avatar"})
public class UserUpdater {
    private String email;
    private String first_name;
    private String last_name;
    private  String avatar;

    public UserUpdater(String email, String first_name, String last_name, String avatar){
            this.email = email;
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar = avatar;
        }
    public UserUpdater(){}

    public String getEmail() {
            return email;
        }
    public void setEmail(String email) {
            this.email = email;
        }

    @JsonProperty("first name")
    public String getFirst_name() {
        return first_name;
    }
    @JsonProperty("first name")
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @JsonProperty("last name")
    public String getLast_name() {
            return last_name;
        }
    @JsonProperty("last name")
    public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
