package com.stocks.sysservice.model;

import java.util.List;

/**
 * @Author: ChenYu
 * @Date: 2019/2/20 12:21
 * @Description:
 */
public class ListResponse<T> {
    private List<T> list;

    private Long count;

    public static <T> ListResponse<T> build(List<T> list, Long count){
        ListResponse<T> response = new ListResponse<T>();
        response.setList(list);
        response.setCount(count);
        return response;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
