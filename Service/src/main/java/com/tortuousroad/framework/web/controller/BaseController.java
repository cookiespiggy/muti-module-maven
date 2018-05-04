package com.tortuousroad.framework.web.controller;

import com.tortuousroad.framework.spring.web.bind.support.DateConvertEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Controller基类
 * 有关抽象类的学习,见博客
 *
 * @See https://www.cnblogs.com/liangqiyuan/p/5568464.html
 */
public abstract class BaseController {

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
    }
}
