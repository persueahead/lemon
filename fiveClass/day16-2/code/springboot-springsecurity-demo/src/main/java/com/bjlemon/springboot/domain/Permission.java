package com.bjlemon.springboot.domain;

public class Permission {
    private Integer permissionId;

    private String permissionCode;

    private String permissionName;

    private String permissionnUrl;

    private Integer parentId;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionnUrl() {
        return permissionnUrl;
    }

    public void setPermissionnUrl(String permissionnUrl) {
        this.permissionnUrl = permissionnUrl == null ? null : permissionnUrl.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}