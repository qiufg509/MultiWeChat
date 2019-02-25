package com.cloudservice.multiwechat.bean;

public class RegisterBean {
    /**
     * name : string
     * userName : string
     * password : string
     * realName : string
     * tenantGuid : string
     * tenantType : 0
     */

    private String name;
    private String userName;
    private String password;
    private String realName;
    private String tenantGuid;
    private int tenantType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTenantGuid() {
        return tenantGuid;
    }

    public void setTenantGuid(String tenantGuid) {
        this.tenantGuid = tenantGuid;
    }

    public int getTenantType() {
        return tenantType;
    }

    public void setTenantType(int tenantType) {
        this.tenantType = tenantType;
    }

    @Override
    public String toString() {
        return "RegisterBean{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", tenantGuid='" + tenantGuid + '\'' +
                ", tenantType=" + tenantType +
                '}';
    }
}
