package kg.megacom.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


public class User {

    private Long id;
    @NotEmpty(message = "First name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String name;
    @NotBlank
    @Size(min = 2, max = 18, message = "Family name must not be blank")
    @Pattern(regexp = "^[A-Za-z]*$")
    private String familyName;
    private String phone;
    private String accountId;
    private String courierStatusId;
    @Size(min = 8, max = 20, message = "Password should be minimum 8 characters")
    @Pattern(regexp = "[a-zA-Z0-9!-&]*")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCourierStatusId() {
        return courierStatusId;
    }

    public void setCourierStatusId(String courierStatusId) {
        this.courierStatusId = courierStatusId;
    }
}