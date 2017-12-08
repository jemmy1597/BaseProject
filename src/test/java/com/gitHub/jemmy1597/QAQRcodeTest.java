package com.gitHub.jemmy1597;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QAQRcodeTest {
    @Test
    public void haha() throws Exception {
        ////////////第一階段
        QAQRcode qaq = new QAQRcode();

        ///////////第二階段
        int temp = qaq.haha(1);

        /////////第三階段w
        Assert.assertEquals(1 , temp);

    }
    @Test
    public void haha1() throws Exception {
        ////////////第一階段
        QAQRcode qaq = new QAQRcode();

        ///////////第二階段
        int temp = qaq.haha(0);

        /////////第三階段
        Assert.assertEquals(0 , temp);

    }
}
