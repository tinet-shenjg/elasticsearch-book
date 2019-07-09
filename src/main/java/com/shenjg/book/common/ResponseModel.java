package com.shenjg.book.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * ResponseModel
 *
 * @author shenjg
 * @date 2019/07/09
 */
public class ResponseModel extends ResponseEntity<ResponseBody> {

    public ResponseModel(Object result) {
        super(new ResponseBody(result), HttpStatus.OK);
    }

    public ResponseModel(HttpStatus status) {
        super(new ResponseBody(status), status);
    }

    public ResponseModel(Object result, HttpStatus status) {
        super(new ResponseBody(status, status.name(), result), status);
    }

    public ResponseModel(HttpStatus status, String message) {
        super(new ResponseBody(status, message, null), status);
    }

    public ResponseModel(Object result, String message) {

        super(new ResponseBody(HttpStatus.OK, message, result), HttpStatus.OK);
    }

    public ResponseModel(HttpStatus status, String message, Object result) {
        super(new ResponseBody(status, message, result), status);
    }
}
