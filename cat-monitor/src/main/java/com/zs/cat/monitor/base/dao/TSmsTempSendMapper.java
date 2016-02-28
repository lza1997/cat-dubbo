package com.zs.cat.monitor.base.dao;

import com.zs.cat.monitor.base.bean.TSmsTempSend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TSmsTempSendMapper {
    int insert(TSmsTempSend record);

    int insertSelective(TSmsTempSend record);

    int updateTableFlag(HashMap map);

    ArrayList<TSmsTempSend> getSmsToSenList(HashMap map);
}