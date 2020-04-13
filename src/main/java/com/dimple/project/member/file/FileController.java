package com.dimple.project.member.file;

import com.dimple.framework.web.page.TableDataInfo;
import com.dimple.project.member.itemBank.entity.EduItemBank;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {


    @RequestMapping(value="/image/add",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam(value="file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream os = null;
        InputStream is = null;
        boolean returnBoolean = false;
        String bug_id = request.getParameter("fileId");   // 传过来的额外参数
        try {
            String path = "E:\\";
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            String currentDate = df.format(System.currentTimeMillis());
            String pathTemp = path + File.separator + currentDate + File.separator + bug_id;
            File fileTemp = new File(pathTemp);
            if(!fileTemp.exists()) {
                fileTemp.mkdirs();
            }
            String fullFilePath = pathTemp + File.separator + file.getOriginalFilename();
            File fullFile = new File(fullFilePath);

            os = new FileOutputStream(fullFile);
            is =file.getInputStream();
            byte buf[] = new byte[1024];//可以修改 1024 以提高读取速度
            int length = 0;
            while( (length = is.read(buf)) > 0 ){
                os.write(buf, 0, length);
            }
            returnBoolean = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is !=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os !=null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return JSONObject.fromObject("{\"success\":"+ returnBoolean +"}").toString();
    }


}
