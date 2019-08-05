package com.shenjg.book.controller;

import com.deepoove.poi.XWPFTemplate;
import com.shenjg.book.utils.DataTimeUtils;
import com.shenjg.book.utils.ExportUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

/**
 * DocxExportController
 *
 * @author shenjg
 * @date 2019/08/01
 */
@Controller
@RequestMapping("/docxExport")
public class DocxExportController {

    @RequestMapping("title")
    public void title(HttpServletResponse response) {
        XWPFTemplate template = null;
        String url = "docTemplates" + File.separator + "template_title.docx";
        try {
            template = XWPFTemplate.compile(this.getClass().getClassLoader()
                    .getResourceAsStream(url))
                    .render(new HashMap<String, Object>() {{
                        put("title", "Poi-tl 模板引擎");
                    }});

            String outFileName = DataTimeUtils.getDataTimeStr() + "-title.docx";

            // 设置响应
            ExportUtils.setResponse(response, outFileName);
            OutputStream out = response.getOutputStream();

            template.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {

        } finally {
            try {
                if (!Objects.isNull(template)) {
                    template.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
