package community.demo.dto;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;

@Data
public class ResultDTO {
    private Integer code;
    private  String message;
    public static ResultDTO errOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }
}
