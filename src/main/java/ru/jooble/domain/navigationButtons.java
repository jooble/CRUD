package ru.jooble.domain;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class navigationButtons extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("<p>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/\" role=\"button\">All Purse</a>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/all/currency\" role=\"button\">All Currency</a>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/all/user\" role=\"button\">All User</a>\n" +
                "    </p>");

    }
}