package com.fanghuiping.springbootmanent.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TodeNode {
    private Integer id;
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private List<TodeNode> children = new ArrayList<>();

    public TodeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }
}
