package com.yancey.mall2.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SmsFlashPromotionSession implements Serializable {
    /**
     * 编号
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "编号")
    private Long id;

    /**
     * 场次名称
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "场次名称")
    private String name;

    /**
     * 每日开始时间
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "每日开始时间")
    private Date startTime;

    /**
     * 每日结束时间
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "每日结束时间")
    private Date endTime;

    /**
     * 启用状态：0->不启用；1->启用
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "启用状态：0->不启用；1->启用")
    private Integer status;

    /**
     * 创建时间
     *
     * @mbggenerated Tue Jun 07 14:46:28 CST 2022
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}