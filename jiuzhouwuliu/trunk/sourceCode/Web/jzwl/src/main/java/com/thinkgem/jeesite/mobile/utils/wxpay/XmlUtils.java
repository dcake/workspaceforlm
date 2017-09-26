package com.thinkgem.jeesite.mobile.utils.wxpay;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class XmlUtils {
	/**
	 * 将map转换为xml字符串
	 * @param map map对象
	 * @param rootString  xml文档的根节点名称
	 * @return 转换后的xml字符串
	 */
	public static String mapToXml(Map<String,Object> map,String rootString){
		if(rootString==null||"".equals(rootString.trim()))return null;
	StringBuffer sb = new StringBuffer();	
	sb.append("<?xml version=\"1.0\"  encoding=\"utf-8\"?>");	
	sb.append("<"+rootString.trim()+">");
	Set<Map.Entry<String,Object>> set = map.entrySet();
    for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it.hasNext();) {
        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
        if(!(entry.getValue() instanceof Map))
        sb.append("<"+entry.getKey().toString().trim()+">"+(entry.getValue()==null||"".equals(entry.getValue().toString().trim())?"":entry.getValue().toString().trim())+"</"+entry.getKey().toString().trim()+">");
        else{
        	sb.append("<"+entry.getKey().toString().trim()+">");
        	Set<Map.Entry<String,Object>> set2 = ((Map)entry.getValue()).entrySet();
        	 for (Iterator<Map.Entry<String, Object>> it2 = set2.iterator(); it2.hasNext();) {
        		 Map.Entry<String, Object> entry2 = (Map.Entry<String, Object>) it2.next();
        	        if(!(entry2.getValue() instanceof Map))
        	        sb.append("<"+entry2.getKey().toString().trim()+">"+(entry2.getValue()==null||"".equals(entry2.getValue().toString().trim())?"":entry2.getValue().toString().trim())+"</"+entry2.getKey().toString().trim()+">");
        	        else
        	        {
        	        	Set<Map.Entry<String,Object>> set3 = ((Map)entry2.getValue()).entrySet();
        	        	sb.append("<"+entry2.getKey().toString().trim()+">");
        	        	 for (Iterator<Map.Entry<String, Object>> it3 = set3.iterator(); it3.hasNext();) {
        	        		 Map.Entry<String, Object> entry3 = (Map.Entry<String, Object>) it3.next();
        	        		 if(!(entry3.getValue() instanceof Map))
        	          	        sb.append("<"+entry3.getKey().toString().trim()+">"+(entry3.getValue()==null||"".equals(entry3.getValue().toString().trim())?"":entry3.getValue().toString().trim())+"</"+entry3.getKey().toString().trim()+">");
        	        		 else return null;
        	        	 }
        	        	 sb.append("</"+entry2.getKey().toString().trim()+">");
        	        }
        	 }
        	 sb.append("</"+entry.getKey().toString().trim()+">");
        }
    }
    sb.append("</"+rootString.trim()+">");
	String result=sb.toString();
    return result;
}
	/**
	 * 将list转换为xml字符串
	 * @param list list对象
	 * @param rootString  xml文档的根节点名称
	 * @return 转换后的xml字符串
	 */
	public static String listToXml(List list,String rootString){
		if(rootString==null||"".equals(rootString.trim()))return null;
		StringBuffer sb = new StringBuffer();	
		sb.append("<?xml version=\"1.0\"  encoding=\"utf-8\"?>");	
		sb.append("<"+rootString.trim()+">");
	    for (int i=0;i<list.size();i++) {
	    	String str=list.get(i).toString();
	    	if(str==null||"".equals(str.trim()))return null;
	    	String[]str2=str.split(":");
	    	if(str2==null||str2.length!=2)return null;
	        sb.append("<"+str2[0].trim()+">"+str2[1].trim()+"</"+str2[0].trim()+">");
	    }
	    sb.append("</"+rootString.trim()+">");
		String result=sb.toString().trim();
	    return result;
	}
	/**
	 * 将xml字符串转换为map对象
	 * @param xml xml字符串
	 * @return 转换后的xml字符串
	 */
    public static Map xmlToMap(String xml) {
        Map map = new HashMap();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml.replace("﻿<?xml version=\"1.0\" encoding=\"utf-8\"?>","")); // 将字符串转为XML
           /* 
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
    		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
    			System.out.println("======");
    			Element element = (Element) ie.next();
    			System.out.println(element.getName());

    			// 枚举属性
    			for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
    				Attribute attribute = (Attribute) ia.next();
    				System.out.println(attribute.getName() + ":"
    						+ attribute.getData());
    			}
    			// 枚举当前节点下所有子节点
    			for (Iterator ieson = element.elementIterator(); ieson.hasNext();) {
    				Element elementSon = (Element) ieson.next();
    				System.out.println(elementSon.getName() + ":"
    						+ elementSon.getText());
    			}
    		}*/
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
    		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
    			Element element = (Element) ie.next();
    			map.put(element.getName(),element.getText());
    		}
        }catch(Exception e){e.printStackTrace();}
        return map;
    }
    
    
    public static Map xmlToMap1(String xml) {
        Map map = new HashMap();
        Document doc = null;
        try {
//        	xml = xml.replace("<xml>",""); // 将字符串转为XML
        	xml = xml.replace("<![CDATA[",""); // 将字符串转为XML
        	xml = xml.replace("]]>",""); // 将字符串转为XML
//        	xml = xml.replace("</xml>","");
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
           /* 
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
    		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
    			System.out.println("======");
    			Element element = (Element) ie.next();
    			System.out.println(element.getName());

    			// 枚举属性
    			for (Iterator ia = element.attributeIterator(); ia.hasNext();) {
    				Attribute attribute = (Attribute) ia.next();
    				System.out.println(attribute.getName() + ":"
    						+ attribute.getData());
    			}
    			// 枚举当前节点下所有子节点
    			for (Iterator ieson = element.elementIterator(); ieson.hasNext();) {
    				Element elementSon = (Element) ieson.next();
    				System.out.println(elementSon.getName() + ":"
    						+ elementSon.getText());
    			}
    		}*/
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
    		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
    			Element element = (Element) ie.next();
    			map.put(element.getName(),element.getText());
    		}
        }catch(Exception e){e.printStackTrace();}
        return map;
    }
    
/**
 * 格式化xml字符串，去掉字符串的xml声明部分
 * @param xml xml文档字符串
 * @return 转换后的xml字符串
 */
    public static String subXml(String xml) {
        Document doc = null;
        StringBuffer sb=new StringBuffer();
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
            //root.nodeCount();
            for(int i = 0;  i < root.nodeCount()-1;  i++) {
            	Node node = root.node(i);
            	       Element sonElement = (Element) node;
            	       sb.append("<"+sonElement.getName()+">"+sonElement.getText()+"</"+sonElement.getName()+">");
            	}
        }catch(Exception e){e.printStackTrace();}
        return sb.toString();
    }
    /**
     * xml字符串转换为list
     * @param xml xml字符串
     * @return 转换后的xml字符串
     */
    public static List xmlToList(String xml) {
       List list=new ArrayList();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element root = doc.getRootElement();
    		// 枚举根节点下所有子节点
    		for (Iterator ie = root.elementIterator(); ie.hasNext();) {
    			Element element = (Element) ie.next();
    			list.add(element.getName()+":"+element.getText());
    		}
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
  
    
    public static Map<String, Object> xml2map(String xmlString){ 
    	 Document doc=null;
		try {
			doc = DocumentHelper.parseText(xmlString);
		
    	Map<String, Object> map = new HashMap<String, Object>(); 
        if(doc == null) 
            return map; 
        Element root = doc.getRootElement(); 
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) { 
            Element e = (Element) iterator.next(); 
            List list = e.elements(); 
            if(list.size() > 0){ 
                map.put(e.getName(), Dom2Map(e)); 
            }else 
                map.put(e.getName(), e.getText()); 
        } 
        return map; 
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return null;
		}  
       
    } 
    private static Map Dom2Map(Element e){ 
        Map map = new HashMap(); 
        List list = e.elements(); 
        if(list.size() > 0){ 
            for (int i = 0;i < list.size(); i++) { 
                Element iter = (Element) list.get(i); 
                List mapList = new ArrayList(); 
                 
                if(iter.elements().size() > 0){ 
                    Map m = Dom2Map(iter); 
                    if(map.get(iter.getName()) != null){ 
                        Object obj = map.get(iter.getName()); 
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = new ArrayList(); 
                            mapList.add(obj); 
                            mapList.add(m); 
                        }else{ 
                            mapList = (List) obj; 
                            mapList.add(m); 
                        } 
                        map.put(iter.getName(), mapList); 
                    }else 
                        map.put(iter.getName(), m); 
                } 
                else{ 
                    if(map.get(iter.getName()) != null){ 
                        Object obj = map.get(iter.getName()); 
                        if(!obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = new ArrayList(); 
                            mapList.add(obj); 
                            mapList.add(iter.getText()); 
                        } 
                        if(obj.getClass().getName().equals("java.util.ArrayList")){ 
                            mapList = (List) obj; 
                            mapList.add(iter.getText()); 
                        } 
                        map.put(iter.getName(), mapList); 
                    }else 
                        map.put(iter.getName(), iter.getText()); 
                } 
            } 
        }else 
            map.put(e.getName(), e.getText()); 
        return map; 
    } 

}

