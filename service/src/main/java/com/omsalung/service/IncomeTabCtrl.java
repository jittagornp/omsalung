/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsalung.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anonymous
 */
@Controller
public class IncomeTabCtrl {

    @ResponseBody
    @RequestMapping(value = "/api/v1/income/tabs", method = RequestMethod.GET)
    public String getIncomeTab() {
        return "[\n"
                + "            {\n"
                + "                title: 'วัน',\n"
                + "                name: 'day',\n"
                + "                link: '#!/income/day',\n"
                + "                order : 1\n"
                + "            },\n"
                + "            {\n"
                + "                title: 'สัปดาห์',\n"
                + "                name: 'week',\n"
                + "                link: '#!/income/week',\n"
                + "                order : 2\n"
                + "            },\n"
                + "            {\n"
                + "                title: 'เดือน',\n"
                + "                name: 'month',\n"
                + "                link: '#!/income/month',\n"
                + "                order : 3\n"
                + "            },\n"
                + "            {\n"
                + "                title: 'ปี',\n"
                + "                name: 'year',\n"
                + "                link: '#!/income/year',\n"
                + "                order : 4\n"
                + "            },\n"
                + "            {\n"
                + "                title: 'ทั้งหมด',\n"
                + "                name: 'all',\n"
                + "                link: '#!/income/all',\n"
                + "                order : 5\n"
                + "            }\n"
                + "        ]";
    }
}
