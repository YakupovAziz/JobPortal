package jobportal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<Users> users;


    public UsersType() {

    }

    public UsersType(int userTypeId, List<Users> users, String userTypeName) {
        this.userTypeId = userTypeId;
        this.users = users;
        this.userTypeName = userTypeName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}