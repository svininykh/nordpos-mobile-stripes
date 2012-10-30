/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nordpos.mobile.stripes.chart;

import br.com.digilabs.jqplot.JqPlotUtils;
import br.com.digilabs.jqplot.chart.AreaChart;
import br.com.digilabs.jqplot.chart.BarChart;
import br.com.digilabs.jqplot.chart.LineChart;
import br.com.digilabs.jqplot.chart.PieChart;
import br.com.digilabs.jqplot.data.item.LabeledItem;
import br.com.digilabs.jqplot.elements.Legend;
import br.com.digilabs.jqplot.elements.Location;
import br.com.digilabs.jqplot.elements.Serie;
import com.nordpos.mobile.stripes.action.BaseActionBean;
import com.nordpos.mobile.stripes.dao.PeoplePersist;
import com.nordpos.mobile.stripes.model.People;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author svininykh-av
 */
public class JqPlotSample {

    public static String barChart(ServletContext sc, String divId) {
        PeoplePersist peopleDao = new PeoplePersist(sc);
        BarChart<Integer> barChart;
        barChart = new BarChart<Integer>("Bar Chart");

        Iterator ticketsSales = peopleDao.readUserTickets();
        List<String> namesList = new ArrayList<String>();
        List<Integer> ticketsList = new ArrayList<Integer>();

        while (ticketsSales.hasNext()) {
            People currentUser = (People) ticketsSales.next();
            namesList.add(currentUser.getName());
            ticketsList.add(currentUser.getTicketsSales());
        }

        barChart.setTicks(namesList.toArray(new String[0]));
        barChart.addValue(ticketsList);

        barChart.setPadMin(1.05f);
        barChart.setStackSeries(true);
        barChart.setCaptureRightClick(true);
        barChart.setHighlightMouseDown(true);

        barChart.setBarMargin(30);

        barChart.setLabelX("Users");
        barChart.setLabelY("Tickets");

        barChart.getChartConfiguration().getAxes().getYaxis().setMin("");
        barChart.getChartConfiguration().getAxes().getYaxis().setMax("20");

        return JqPlotUtils.createJquery(barChart, divId);
    }

    public static String pieChart(ServletContext sc, String divId) {
        PeoplePersist peopleDao = new PeoplePersist(sc);
        PieChart<Integer> pizzaChart = new PieChart<Integer>("Pizza Chart");

        Iterator ticketsSales = peopleDao.readUserTickets();
        while (ticketsSales.hasNext()) {
            People currentUser = (People) ticketsSales.next();
            pizzaChart.addValue(currentUser.getName(), currentUser.getTicketsSales());
        }

        return JqPlotUtils.createJquery(pizzaChart, divId);
    }
}
