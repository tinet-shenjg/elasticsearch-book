package com.shenjg.book.utils;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ExportUtils
 *
 * @author shenjg
 * @date 2019/08/05
 */
public class ExportUtils {

    private static final String UTF = "UTF-8";

    public static void setResponse(@NotNull HttpServletResponse response, String fileName) throws UnsupportedEncodingException {

        // 设置响应
        response.setContentType("application/ms-txt.numberformat:@");
        response.setCharacterEncoding(UTF);
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Content-Disposition", "attachment; filename=" +
                URLEncoder.encode(fileName, UTF));
    }
}
