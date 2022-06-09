package com.yancey.mall2.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsResourceCategory implements Serializable {
    private Long id;

    /**
     * 创建时间
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 分类名称
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 排序
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", name=").append(name);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}