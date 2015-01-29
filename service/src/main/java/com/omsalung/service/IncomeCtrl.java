/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsalung.service;

import com.omsalung.api.IXTab;
import com.omsalung.api.JsonResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author anonymous
 */
@Controller
public class IncomeCtrl {

    private IXTab createTab(String id, String title, String link, int order) {
        IXTab tab = new IXTab();
        tab.setId(id);
        tab.setTitle(title);
        tab.setLink(link);
        tab.setOrder(order);

        return tab;
    }

    private List<IXTab> findTabs() {
        List<IXTab> tabs = new ArrayList<>();
        tabs.add(createTab("day", "วัน", "#!/income/day", 1));
        tabs.add(createTab("week", "สัปดาห์", "#!/income/week", 2));
        tabs.add(createTab("month", "เดือน", "#!/income/month", 3));
        tabs.add(createTab("year", "ปี", "#!/income/year", 4));
        tabs.add(createTab("all", "ทั้งหมด", "#!/income/all", 5));
        return tabs;
    }

    @ResponseBody
    @RequestMapping(value = "/income/tabs", method = RequestMethod.GET)
    public JsonResponse getIncomeTab() {
        return JsonResponse.fromData(findTabs());
    }
}
