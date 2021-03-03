package top_interview_question.easy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class fiaTest {
    /*
     * The profit is the sum of sub-profits. Each sub-profit is the difference
     * between selling at day j, and buying at day i (with j > i). The range [i, j]
     * should be chosen so that the sub-profit is maximum:
     * 
     * sub-profit = prices[j] - prices[i] We should choose j that prices[j] is as
     * big as possible, and choose i that prices[i] is as small as possible (of
     * course in their local range).
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int buy;
        int sell;
        int profit = 0;
        int N = prices.length - 1;
        while (i < N) {
            // i+1 比 i 小 => 移往下一位 => 找到買點
            while (i < N && prices[i + 1] <= prices[i]) {
                i++;
            }
            buy = prices[i];

            // i+1 比 i 大 => 移往下一位 => 找到賣點
            while (i < N && prices[i + 1] > prices[i]) {
                i++;
            }
            sell = prices[i];

            profit += sell - buy;
        }

        return profit;
    }
    
    private Map<String, Object> readXmltoMap(String XmlString) throws Exception {

        InputStream is = new ByteArrayInputStream(XmlString.toString().getBytes("UTF-8"));

        String RQ_001 = "mofxmq003req:XMQ003_RQ_001";
        String RQ_002 = "mofxmq003req:XMQ003_RQ_002";
        String banTag = "mofxmq003:XMQ003_CMQ_001";
        String CMQ_002 = "mofxmq003:XMQ003_CMQ_002";
        String CMQ_003 = "mofxmq003:XMQ003_CMQ_003";
        String CMQ_004 = "mofxmq003:XMQ003_CMQ_004";
        String idnTag = "mofxmq003:XMQ003_CMQ_005";

        String[] inputTagGroup = { RQ_001, RQ_002, idnTag, CMQ_002, CMQ_003, CMQ_004, banTag };
        String[] inputTagValue = new String[inputTagGroup.length];

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(is);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("mofxmq003req:XMQ003_RQ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element node = (Element) nodeList.item(i);
            for (int j = 0; j < inputTagGroup.length; j++) {
                // 取出xml的內容並放到陣列, 若查無資料則回傳空字串
                inputTagValue[j] = getTextValue(node, inputTagGroup[j]);
            }
        }
        is.close();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("RQ_001", inputTagValue[linerSearch(inputTagGroup, RQ_001)]);
        params.put("RQ_002", inputTagValue[linerSearch(inputTagGroup, RQ_002)]);
        params.put("idn", inputTagValue[linerSearch(inputTagGroup, idnTag)]);
        params.put("CMQ_002", inputTagValue[linerSearch(inputTagGroup, CMQ_002)]);
        params.put("CMQ_003", inputTagValue[linerSearch(inputTagGroup, CMQ_003)]);
        params.put("CMQ_004", inputTagValue[linerSearch(inputTagGroup, CMQ_004)]);
        params.put("ban", inputTagValue[linerSearch(inputTagGroup, banTag)]);
        return params;
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = "";
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            try {
                textVal = el.getFirstChild().getNodeValue();
            } catch (NullPointerException e) {
                textVal = "";
            }
        }

        return textVal;
    }

    private int linerSearch(String[] array, String target) {
        int idx = -1;
        for (int i = 0; i < array.length; i++) {
            if (target.equals(array[i])) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public String getSmallestBlYrPd(List<String> yearTempLs) {
        String small = yearTempLs.get(0);
        for (String year : yearTempLs) {
            if (small.compareTo(year) > 0) {
                System.out.println("small:" + small + " > year:" + year);
                small = year;
            }
        }
        return small;
    }

    public static void main(String[] args) {
        // int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        int[] numbers = { 1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 8 };
        int[] numbers2 = { 7, 1, 5, 3, 6, 4 };
        int[] numbers3 = { 3, 2, 5, 8, 1 };
        int[] numbers4 = { 7, 6, 4, 3, 1 };
        fiaTest aa = new fiaTest();
        System.out.println(aa.maxProfit(numbers4));
        System.out.println("hello world");
        String text = "091L";
        System.out.println(Integer.valueOf(text.substring(0, 2)));
        // System.out.println(Integer.valueOf(text));

        String text1 = "10911";
        String text2 = "097CV";
        if (text1.compareTo(text2) > 0) {
            System.out.println("text1>text2");
        } else if (text1.compareTo(text2) < 0) {
            System.out.println("text1<text2");
        }
        // String[] numbers5 = { "109CV", "097CV", "10911", "0984I", "09653" };
        String[] numbers5 = { "10909", "093BV", "10911", "09845", "093BC" };
        System.out.println(Collections.min(Arrays.asList(numbers5)));
        
        System.out.println(aa.getSmallestBlYrPd(Arrays.asList(numbers5)));
        

        String asdf = "屏東縣三地門鄉";
        String qwer = "Nantou City, Nantou County";

        System.out.println(asdf.substring(0, 3));
        System.out.println(asdf.substring(3, asdf.length()));
        System.out.println(qwer.split(",")[0].trim());
        System.out.println(qwer.split(",")[1].trim());
        System.out.println();


        //String xml = '<mofxmq003req:XMQ003_RQ xmlns:mofxmq003req="http://li.etax.nat.gov.tw/MOF/XMQ003Req_new_definition" xmlns:mofxmq003="http://li.etax.nat.gov.tw/MOF/XMQ003_new_definition" XMQ003_RQA_001="003" XMQ003_RQA_002="017"><mofxmq003req:XMQ003_RQ_001>10000092_1091015_228638_2793</mofxmq003req:XMQ003_RQ_001><mofxmq003req:XMQ003_RQ_002>10000092_1091015_228640_2723</mofxmq003req:XMQ003_RQ_002><mofxmq003req:XMQ003_RQ_003>S</mofxmq003req:XMQ003_RQ_003><mofxmq003req:XMQ003_RQ_004>8030065</mofxmq003req:XMQ003_RQ_004><mofxmq003req:XMQ003_RQ_005>313050000G</mofxmq003req:XMQ003_RQ_005><mofxmq003req:XMQ003_RQ_006>經濟部中小企業處</mofxmq003req:XMQ003_RQ_006><mofxmq003:XMQ003_CMQ><mofxmq003:XMQ003_CMQ_001>43818734</mofxmq003:XMQ003_CMQ_001><mofxmq003:XMQ003_CMQ_002>0809320540280908</mofxmq003:XMQ003_CMQ_002><mofxmq003:XMQ003_CMQ_003>泓福實業股份有限公司</mofxmq003:XMQ003_CMQ_003><mofxmq003:XMQ003_CMQ_004>109</mofxmq003:XMQ003_CMQ_004><mofxmq003:XMQ003_CMQ_006>8030065</mofxmq003:XMQ003_CMQ_006><mofxmq003:XMQ003_CMQ_007/><mofxmq003:XMQ003_CMQ_008/><mofxmq003:XMQ003_CMQ_009/><mofxmq003:XMQ003_CMQ_010/><mofxmq003:XMQ003_CMQ_011/></mofxmq003:XMQ003_CMQ></mofxmq003req:XMQ003_RQ>';        
        StringBuilder str = new StringBuilder();
        str.append("<mofxmq003req:XMQ003_RQ XMQ003_RQA_001=\"003\" XMQ003_RQA_002=\"017\" xmlns:mofxmq003=\"http://li.etax.nat.gov.tw/MOF/XMQ003_new_definition\" xmlns:mofxmq003req=\"http://li.etax.nat.gov.tw/MOF/XMQ003Req_new_definition\">");
        str.append("<mofxmq003req:XMQ003_RQ_001>10000092_1091015_228638_2793</mofxmq003req:XMQ003_RQ_001><mofxmq003req:XMQ003_RQ_002>10000092_1091015_228640_2723</mofxmq003req:XMQ003_RQ_002><mofxmq003req:XMQ003_RQ_003>S</mofxmq003req:XMQ003_RQ_003><mofxmq003req:XMQ003_RQ_004>8030065</mofxmq003req:XMQ003_RQ_004><mofxmq003req:XMQ003_RQ_005>313050000G</mofxmq003req:XMQ003_RQ_005><mofxmq003req:XMQ003_RQ_006>經濟部中小企業處</mofxmq003req:XMQ003_RQ_006><mofxmq003:XMQ003_CMQ><mofxmq003:XMQ003_CMQ_001>43818734</mofxmq003:XMQ003_CMQ_001><mofxmq003:XMQ003_CMQ_002>0809320540280908</mofxmq003:XMQ003_CMQ_002><mofxmq003:XMQ003_CMQ_003>泓福實業股份有限公司</mofxmq003:XMQ003_CMQ_003><mofxmq003:XMQ003_CMQ_004>109</mofxmq003:XMQ003_CMQ_004><mofxmq003:XMQ003_CMQ_006>8030065</mofxmq003:XMQ003_CMQ_006><mofxmq003:XMQ003_CMQ_007></mofxmq003:XMQ003_CMQ_007><mofxmq003:XMQ003_CMQ_008></mofxmq003:XMQ003_CMQ_008><mofxmq003:XMQ003_CMQ_009></mofxmq003:XMQ003_CMQ_009><mofxmq003:XMQ003_CMQ_010></mofxmq003:XMQ003_CMQ_010><mofxmq003:XMQ003_CMQ_011></mofxmq003:XMQ003_CMQ_011></mofxmq003:XMQ003_CMQ></mofxmq003req:XMQ003_RQ>");
        System.out.println(str.toString());
        System.out.println();
        System.out.println();

        StringBuilder str2 = new StringBuilder();
        str2.append("<mofxmq003req:XMQ003_RQ XMQ003_RQA_001=\"003\" XMQ003_RQA_002=\"017\" xmlns:mofxmq003=\"http://li.etax.nat.gov.tw/MOF/XMQ003_new_definition\" xmlns:mofxmq003req=\"http://li.etax.nat.gov.tw/MOF/XMQ003Req_new_definition\">");
        //source
        str2.append("<mofxmq003req:XMQ003_RQ_001>10000092_1091015_228638_2793</mofxmq003req:XMQ003_RQ_001>");
        str2.append("<mofxmq003req:XMQ003_RQ_002>10000092_1091015_228640_2723</mofxmq003req:XMQ003_RQ_002> ");
        str2.append("<mofxmq003req:XMQ003_RQ_003>S</mofxmq003req:XMQ003_RQ_003>");
        str2.append("<mofxmq003req:XMQ003_RQ_004>8030065</mofxmq003req:XMQ003_RQ_004>");
        str2.append("<mofxmq003req:XMQ003_RQ_005>313050000G</mofxmq003req:XMQ003_RQ_005>");
        str2.append("<mofxmq003req:XMQ003_RQ_006>經濟部中小企業處</mofxmq003req:XMQ003_RQ_006>");
        //query para
        // 牌照稅甲測測試案例
        // 66896598
        // O100055821
        str2.append("<mofxmq003:XMQ003_CMQ>");
        str2.append("<mofxmq003:XMQ003_CMQ_001>66896598</mofxmq003:XMQ003_CMQ_001>");
        str2.append("<mofxmq003:XMQ003_CMQ_002/>");
        str2.append("<mofxmq003:XMQ003_CMQ_003>張瑞益即億利鮮魚行</mofxmq003:XMQ003_CMQ_003>");
        str2.append("<mofxmq003:XMQ003_CMQ_004/>");
        str2.append("<mofxmq003:XMQ003_CMQ_005/>");
        str2.append("<mofxmq003:XMQ003_CMQ_006/>");
        str2.append("<mofxmq003:XMQ003_CMQ_007/>");
        str2.append("<mofxmq003:XMQ003_CMQ_008/>");
        str2.append("<mofxmq003:XMQ003_CMQ_009/>");
        str2.append("<mofxmq003:XMQ003_CMQ_010/>");
        str2.append("<mofxmq003:XMQ003_CMQ_011/>");
        str2.append("</mofxmq003:XMQ003_CMQ>");
        
        str2.append("</mofxmq003req:XMQ003_RQ>");

        System.out.println(str2.toString());
        System.out.println();
        System.out.println();
        //String xml = 'aa';


                // output
                List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
                Map<String, Object> msgParams = new LinkedHashMap<String, Object>();
                Map<String, Object> rtnPparams = new LinkedHashMap<String, Object>();
        
                Map<String, Object> params = null;
                try {
                    params = aa.readXmltoMap(str2.toString());
                    System.out.println();
                    System.out.println();
                    System.out.println(params);
                    System.out.println();
                    
                } catch (Exception e1) {
                    String errMsg = e1.getMessage();
                    msgParams.clear();
                    rtnPparams.clear();
                    msgParams.put("msgCode", "97");
                    msgParams.put("msgBody", "輸入格式錯誤!!");
      
                    resultList.add(msgParams);
                    // 回傳檢查傳入參數結果
            
                }
    }
}