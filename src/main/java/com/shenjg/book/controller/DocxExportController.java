package com.shenjg.book.controller;

import com.deepoove.poi.XWPFTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * DocxExportController
 *
 * @author shenjg
 * @date 2019/08/01
 */
@RestController
@RequestMapping("/docxExport")
public class DocxExportController {

    @RequestMapping("title")
    public void title() {
        XWPFTemplate template = null;
        try {
            template = XWPFTemplate.compile("~/docTemplates/template_title.docx").render(new HashMap<String, Object>() {{
                put("title", "Poi-tl 模板引擎");
            }});
            FileOutputStream out = new FileOutputStream("out_template.docx");
            template.write(out);
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
