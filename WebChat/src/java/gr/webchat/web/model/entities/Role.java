package gr.webchat.web.model.entities;

import gr.webchat.web.messenger.main.MessengerException;
import java.util.Objects;


public final class Role {
    
    public static final Role USER  = new Role(1, "USER");
    public static final Role ADMIN = new Role(2, "ADMIN");
    public static final Role MODERATOR = new Role(3, "MODERATOR");
    
    private final int id;
    private final String name;
    
    private Role(int id, String name) {
        this.id   = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public static final Role getRoleFor(int id) throws MessengerException {
        if (id == USER.getId()) {
            return USER;
        }
        else if (id == ADMIN.getId()) {
            return ADMIN;
        }
        else if (id== MODERATOR.getId()){
            return MODERATOR;
        }
        else {
            throw new MessengerException("Invalid role id: " + id);
        }
    }
}
