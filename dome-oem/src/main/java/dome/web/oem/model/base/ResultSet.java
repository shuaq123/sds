package dome.web.oem.model.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 通用返回结果集
 * @ClassName ResultSet
 * @Author yannuodong
 * @Date 2021-04-09
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ResultSet<T> implements Serializable {

    /**
     * 状态码
     */
    //ApiModelProperty("状态码")
    private int code;

    /**
     * 消息描述
     */
    //ApiModelProperty("消息描述")
    private String message;

    /**
     * 状态(布尔值)
     */
    //ApiModelProperty("状态")
    private boolean flag;

    /**
     * 返回数据
     */
    //ApiModelProperty("返回数据")
    private T data;

    private static ResultSet resultSet;

    /**
     * 单例模式获取结果集对象
     * @param <T>
     * @return
     */
    public static <T> ResultSet<T> getResultSet() {
        resultSet = new ResultSet();
        return resultSet;
    }

    /**
     * 生成成功结果集对象
     * @return
     */
    public static ResultSet success() {
        ResultSet.getResultSet();
        resultSet.setCode(200);
        resultSet.setMessage("成功");
        resultSet.setData(null);
        return resultSet;
    }

    public static ResultSet success(String message) {
        ResultSet.success();
        resultSet.setMessage(message);
        return resultSet;
    }

    public static <T> ResultSet<T> success(T t) {
        ResultSet.success();
        resultSet.setData(t);
        return resultSet;
    }

    public static <T> ResultSet<T> success(String message, T t) {
        ResultSet.success();
        resultSet.setMessage(message);
        resultSet.setData(t);
        return resultSet;
    }

//    public static ResultSet<Map<String,Object>> success(PageInfo page){
//        ResultSet.getResultSet();
//        resultSet.setCode(200);
//        resultSet.setMessage("成功");
//        Map<String,Object> result=new HashMap<>();
//        result.put("list",page.getList());
//        result.put("pageNum",page.getPageNum());
//        result.put("pageSize",page.getPageSize());
//        result.put("total",page.getTotal());
//        resultSet.setData(result);
//        return resultSet;
//    }

    /**
     * 生成失败结果集对象
     * @return
     */
    public static ResultSet fail() {
        ResultSet.getResultSet();
        resultSet.setCode(500);
        resultSet.setMessage("系统异常");
        resultSet.setData(null);
        return resultSet;
    }

    public static <T> ResultSet<T> fail(T t) {
        resultSet.setCode(500);
        resultSet.setMessage("系统异常");
        resultSet.setData(t);
        return resultSet;
    }

//    public static ResultSet fail(ErrorCodeEnum errorCodeEnum) {
//        ResultSet.getResultSet();
//        resultSet.setCode(errorCodeEnum.getCode());
//        resultSet.setMessage(errorCodeEnum.getMsg());
//        return resultSet;
//    }

    public static ResultSet fail(String message) {
        ResultSet.fail();
        resultSet.setMessage(message);
        return resultSet;
    }

    public static ResultSet fail(int code, String message) {
        ResultSet.fail();
        resultSet.setMessage(message);
        resultSet.setCode(code);
        return resultSet;
    }

    public boolean isFlag() {
        flag = false;
        if (code == 200) {
            flag = true;
        }
        return flag;
    }

    public static <T> ResultSet<T> build(int code,String message,T t){
        ResultSet.getResultSet();
        resultSet.setCode(code);
        resultSet.setMessage(message);
        resultSet.setData(t);
        return resultSet;
    }

}
