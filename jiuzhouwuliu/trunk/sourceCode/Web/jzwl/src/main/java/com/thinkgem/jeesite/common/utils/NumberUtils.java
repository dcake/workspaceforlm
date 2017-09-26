package com.thinkgem.jeesite.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * @description:数字类型操作工具类
 * @author pangchengxiang
 * @date 2017年8月26日 上午9:51:38
 */
public class NumberUtils{
    /**
     * @description	：四舍五入，保留两位小数
     * @author pangchengxiang
     * @date 2017年8月26日 上午9:48:22
     * @return double
     */
    public static double formatDouble2(double d) {
    	try{
    		BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
    		return bg.doubleValue();
    	}catch(Exception e){
    		return 0.00;
    	}
        
    }
}
