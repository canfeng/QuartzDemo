package com.fang.model;

import java.util.Date;

public class InterfaceInfo implements java.io.Serializable {

    /** 接口编号（uuid�?? */
    private String interfaceID;

    /** 接口描述 */
    private String description;

    /** 接口调用的url */
    private String simpleUrl;

    /** 接口访问地址 */
    private String url;

    /** 创建人UserID */
    private String createUserID;

    /** ChargeUserID */
    private String chargeUserID;

    /** CreateTime */
    private Date createTime;

    /** 接口超时多久报警（eg�??5，单�?? 秒） */
    private Integer timeOut;

    /** 调用周期 */
    private String cronExpression;

    /**  上次调用时间 */
    private  Date lastInvokeTime;

    /** 接口来源，所属集�??(10: 电商 �??20：媒�?? ; 30：平�??) */
    private Integer source = 10;

    /** 报警方式�??1：短信；0：邮件） */
    private Integer alarmWay = 0;

    /** 是否删除�??0：未删除�??1 :已删除） */
    private Integer isDelete = 0;

    /** 是否隐藏�??0：未隐藏�??1：已隐藏�?? */
    private Integer isHide = 0;



    /**
     * 获取 接口编号（uuid�?? 的�??
     * @return String
     */
    public String getInterfaceID() {
        return interfaceID;
    }
    
    /**
     * 设置接口编号（uuid�?? 的�??
     * @param String interfaceID
     */
    public InterfaceInfo setInterfaceID(String interfaceID) {
        this.interfaceID = interfaceID;
        return this;
    }

    public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
     * 获取 接口描述 的�??
     * @return String
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * 设置接口描述 的�??
     * @param String description
     */
    public InterfaceInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * 获取 接口调用的url 的�??
     * @return String
     */
    public String getSimpleUrl() {
        return simpleUrl;
    }
    
    /**
     * 设置接口调用的url 的�??
     * @param String simpleUrl
     */
    public InterfaceInfo setSimpleUrl(String simpleUrl) {
        this.simpleUrl = simpleUrl;
        return this;
    }

    /**
     * 获取 接口访问地址 的�??
     * @return String
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * 设置接口访问地址 的�??
     * @param String url
     */
    public InterfaceInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * 获取 创建人UserID 的�??
     * @return String
     */
    public String getCreateUserID() {
        return createUserID;
    }
    
    /**
     * 设置创建人UserID 的�??
     * @param String createUserID
     */
    public InterfaceInfo setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
        return this;
    }

    /**
     * 获取 ChargeUserID 的�??
     * @return String
     */
    public String getChargeUserID() {
        return chargeUserID;
    }
    
    /**
     * 设置ChargeUserID 的�??
     * @param String chargeUserID
     */
    public InterfaceInfo setChargeUserID(String chargeUserID) {
        this.chargeUserID = chargeUserID;
        return this;
    }

    /**
     * 获取 CreateTime 的�??
     * @return Object
     */
    public Date getCreateTime() {
        return createTime;
    }
    
    /**
     * 设置CreateTime 的�??
     * @param Object createTime
     */
    public InterfaceInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取 接口超时多久报警（eg�??5，单�?? 秒） 的�??
     * @return Integer
     */
    public Integer getTimeOut() {
        return timeOut;
    }
    
    /**
     * 设置接口超时多久报警（eg�??5，单�?? 秒） 的�??
     * @param Integer timeOut
     */
    public InterfaceInfo setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    /**
     * 获取  上次调用时间 的�??
     * @return Object
     */
    public Date getLastInvokeTime() {
        return lastInvokeTime;
    }
    
    /**
     * 设置 上次调用时间 的�??
     * @param Object lastInvokeTime
     */
    public InterfaceInfo setLastInvokeTime(Date lastInvokeTime) {
        this.lastInvokeTime = lastInvokeTime;
        return this;
    }

    /**
     * 获取 接口来源，所属集�??(10: 电商 �??20：媒�?? ; 30：平�??) 的�??
     * @return Integer
     */
    public Integer getSource() {
        return source;
    }
    
    /**
     * 设置接口来源，所属集�??(10: 电商 �??20：媒�?? ; 30：平�??) 的�??
     * @param Integer source
     */
    public InterfaceInfo setSource(Integer source) {
        this.source = source;
        return this;
    }

    /**
     * 获取 报警方式�??1：短信；0：邮件） 的�??
     * @return Integer
     */
    public Integer getAlarmWay() {
        return alarmWay;
    }
    
    /**
     * 设置报警方式�??1：短信；0：邮件） 的�??
     * @param Integer alarmWay
     */
    public InterfaceInfo setAlarmWay(Integer alarmWay) {
        this.alarmWay = alarmWay;
        return this;
    }

    /**
     * 获取 是否删除�??0：未删除�??1 :已删除） 的�??
     * @return Integer
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    
    /**
     * 设置是否删除�??0：未删除�??1 :已删除） 的�??
     * @param Integer isDelete
     */
    public InterfaceInfo setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    /**
     * 获取 是否隐藏�??0：未隐藏�??1：已隐藏�?? 的�??
     * @return Integer
     */
    public Integer getIsHide() {
        return isHide;
    }
    
    /**
     * 设置是否隐藏�??0：未隐藏�??1：已隐藏�?? 的�??
     * @param Integer isHide
     */
    public InterfaceInfo setIsHide(Integer isHide) {
        this.isHide = isHide;
        return this;
    }

	@Override
	public String toString() {
		return "InterfaceInfo [interfaceID=" + interfaceID + ", description=" + description + ", simpleUrl=" + simpleUrl
				+ ", url=" + url + ", createUserID=" + createUserID + ", chargeUserID=" + chargeUserID + ", createTime="
				+ createTime + ", timeOut=" + timeOut + ", cronExpression=" + cronExpression + ", lastInvokeTime="
				+ lastInvokeTime + ", source=" + source + ", alarmWay=" + alarmWay + ", isDelete=" + isDelete
				+ ", isHide=" + isHide + "]";
	}


}