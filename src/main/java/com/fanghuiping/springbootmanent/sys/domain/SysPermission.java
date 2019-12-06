package com.fanghuiping.springbootmanent.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 方慧平
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "目录")
public class SysPermission implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id",name = "id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "pid",name = "父类ip",example = "1")
    private Integer pid;

    /**
     * 权限类型[menu/permission]
     */
    @ApiModelProperty(value = "type",name = "权限类型")
    private String type;

    @ApiModelProperty(value = "loginip",name = "日志ip",example = "121.0.0.1")
    private String title;

    /**
     * 权限编码[只有type= permission才有  user:view]
     */
    @ApiModelProperty(value = "percode",name = "权限编码")
    private String percode;

    @ApiModelProperty(value = "icon",name = "图标")
    private String icon;

    @ApiModelProperty(value = "href",name = "地址")
    private String href;

    @ApiModelProperty(value = "target",name = "tagrgt")
    private String target;

    @ApiModelProperty(value = "open",name = "是否展开[0不展开1展开]",example = "1")
    private Integer open;

    @ApiModelProperty(value = "ordernum",name = "排序码【为了调事显示顺序】",example = "1")
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
     */
    @ApiModelProperty(value = "available",name = "状态【0不可用1可用】",example = "1")
    private Integer available;


}
