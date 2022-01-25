package com.access.control.models;



import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Allows us create table in db we created earlier
@Entity
//@Data
//Tells program to call table user
@Table(name = "user",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column()
    @NotBlank
    private String firstName;
    @Column()
    @NotBlank
    private String lastName;
    @Column(unique = true)
    @Size(max = 20)
    @NotBlank
    private String userName;
    @Column(unique = true)
    @Size(max = 50)
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;
    @Column
    @Size(max = 120)
    @NotBlank
    private String password;
    //    @Column
//    @NotBlank
//    private boolean loggedIn;
//    @Column
//    private String userLevel;
    @Column
    private String city;
    @Column
    private String address;
    @Column
    private String town;
    @Column
    private String gender;
    @Column
    private String age;
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;
    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id", nullable = false)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, String phoneNumber, String password, String city, String address, String town, String gender, String age, Date createdAt, String createdBy, Date updatedAt, String updatedBy, Set<Roles> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.city = city;
        this.address = address;
        this.town = town;
        this.gender = gender;
        this.age = age;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
//    private Roles role;
//    @ManyToOne
//    @JoinColumn(name = "institution_id", nullable = false)
//    private Institution institution;

//    public User() {
//    }
//
//    public User(Comparable<String> userName, String encodedPassword, String firstName) {
//
//
//    }
//
//    public Roles getRole() {
//        return role;
//    }
//
//    public void setRole(Roles role) {
//        this.role = role;
//    }
//
//
//    public User(String firstName, String lastName, String userName, String email, String phoneNumber, String password, boolean loggedIn, String userLevel, String city, String address, String town, String gender, String age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//        this.loggedIn = loggedIn;
//        this.userLevel = userLevel;
//        this.city = city;
//        this.address = address;
//        this.town = town;
//        this.gender = gender;
//        this.age = age;
//    }
//
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isLoggedIn() {
//        return loggedIn;
//    }
//
//    public void setLoggedIn(boolean loggedIn) {
//        this.loggedIn = loggedIn;
//    }
//
//    public String getUserLevel() {
//        return userLevel;
//    }
//
//    public void setUserLevel(String userLevel) {
//        this.userLevel = userLevel;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getTown() {
//        return town;
//    }
//
//    public void setTown(String town) {
//        this.town = town;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
////    public Roles getRole() {
////        return role;
////    }
////
////    public void setRole(Roles role) {
////        this.role = role;
////    }
//
//    @Override
////    compare object passed to the program with an object in the db
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return Objects.equals(userName, user.userName) &&
//                Objects.equals(password, user.password);
//    }
//    @Override
////    Hashcode generates a hash value of our object
//    public int hashCode() {
//        return Objects.hash(id, userName, password,
//                loggedIn);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", userName='" + userName + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", password='" + password + '\'' +
//                ", loggedIn=" + loggedIn +
//                ", userLevel='" + userLevel + '\'' +
//                ", city='" + city + '\'' +
//                ", address='" + address + '\'' +
//                ", town='" + town + '\'' +
//                ", gender='" + gender + '\'' +
//                ", age='" + age + '\'' +
//                ", role=" + role +
//                '}';
//    }
//}
