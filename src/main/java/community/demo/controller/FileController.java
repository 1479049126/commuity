package community.demo.controller;

import community.demo.dto.FileDto;
import community.demo.provider.AliyuProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@Controller
public class FileController {
    @Autowired
    private AliyuProvider aliyuProvider;
    @ResponseBody
    @PostMapping("/file/upload")
    public FileDto upload(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        FileDto fileDto = new FileDto();
        try {
            assert file != null;
            String url = aliyuProvider.fileUpload(file.getInputStream(), Objects.requireNonNull(file.getOriginalFilename()));
            fileDto.setUrl(url);
            fileDto.setSuccess(1);
            fileDto.setMessage("上传成功");
        } catch (IOException e) {
            fileDto.setSuccess(0);
            fileDto.setMessage("上传失败");
            e.printStackTrace();
        }
        return fileDto;
    }
}
