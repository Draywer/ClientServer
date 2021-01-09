package ru.idcore;

import java.util.Objects;

public class User {
    private String name;
    private boolean adult;
    private String ipAddress;
    private int port;

    public User(String name, boolean adult, String ipAddress, int port) {
        this.name = name;
        this.adult = adult;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", adult=" + adult +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isAdult() == user.isAdult() &&
                getPort() == user.getPort() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getIpAddress(), user.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isAdult(), getIpAddress(), getPort());
    }
}
