package com.yancey.mall2.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class UmsRoleResourceRelation implements Serializable {
    private Long id;

    /**
     * 角色ID
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    /**
     * 资源ID
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "资源ID")
    private Long resourceId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}