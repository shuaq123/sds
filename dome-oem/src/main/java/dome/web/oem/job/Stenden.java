package dome.web.oem.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.base.SendPostDemo;
import com.fasterxml.jackson.databind.ObjectMapper;
import dome.web.oem.model.admin;
import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class Stenden {

    @Autowired
    private SendPostDemo sendPostDemo;


    @Scheduled(fixedDelay = 5000)
    public void SutdenLi() throws IOException {
//        Date date=new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String conntext = sendPostDemo.SendPOST("http://oem.beeeeego.com/beegoapi/oem/agency/recharge/info","{}");
//        JSONObject jsonObject = JSON.parseObject(conntext);
//        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
//        Object jsonObject2 = jsonObject1.get("subAgencys");
//        JSONArray a=JSONArray.parseArray(jsonObject2.toString());
//        jsonObject1.put("wwwsds.dfd",33445);
//        System.out.println(jsonObject.getJSONObject("data").getBigDecimal("faceRecognitionNumber").doubleValue());
//        for (Object i:a){
//            System.out.println(JSONObject.parseObject(i.toString()).get("agencyId"));
//
//        }
//        List<String> dataList = new ArrayList<>();
//        dataList.add("刘子健");
//        dataList.add("杨慧灰");
//        byte[] a = dataList.toString().getBytes();
//        String b=new String(a);
//        System.out.println(b);
//        admin Admin = new admin();
//        Integer a = -12;
//        Integer b = 2;
//        System.out.println(Admin);
//        System.out.println(a.compareTo(b));


    }


}

