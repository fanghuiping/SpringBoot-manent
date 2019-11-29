package com.fanghuiping.springbootmanent.common;

import java.util.ArrayList;
import java.util.List;

public class Tooles {

    /**
     * 使用嵌套循环排序
     *
     * @param todeNodeList
     * @param pId
     * @return
     */
    public static List<TodeNode> navsSort(List<TodeNode> todeNodeList, int pId) {
        List<TodeNode> list = new ArrayList<>();
        for (TodeNode todeNode : todeNodeList) {
            if (todeNode.getPid() == pId)
                list.add(todeNode);
            for (TodeNode todeNode2 : todeNodeList) {
                if (todeNode.getId() == todeNode2.getPid())
                    todeNode.getChildren().add(todeNode2);
            }

        }
        return list;
    }
}
