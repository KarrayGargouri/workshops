package tn.esprit.pidev.utils.jfree_chart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sana
 */




import java.io.IOException;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class BarChart3D extends ApplicationFrame {


    public BarChart3D(final String title) throws IOException {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400,400));
        setContentPane(chartPanel);

    }


   private CategoryDataset createDataset() throws  IOException {

                // 0. Création d'un diagramme.
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          Connexion con=new Connexion();
          Jfcamembert j = new Jfcamembert();


         Double d;
         String ch;
//        try {
//            try {
//                Connexion.rs = Connexion.st.executeQuery("select * from marchandise");
//            } catch (SQLException ex) {
//
//            }
//            while (Connexion.rs.next()) {
//                d=Connexion.rs.getDouble(2);
//                ch=Connexion.rs.getString(1);
//                System.out.println(""+d);
//                System.out.println(""+ch);
//              dataset.addValue(d, ch, "");
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("    nndxc,;kx");
//        }


                dataset.addValue(10, "Taux de défaut de couverture", " ");
                dataset.addValue(12, " Taux de couverture Outdoor", " ");
                dataset.addValue(25, "Taux de couverture Indoor", " ");
                dataset.addValue(19, "Taux de couverture Incar", " ");
        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart3D(
            " le taux des produit ",      // chart title
            " ",               // domain axis label
            "  Le nombre de produit ",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            true                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI /2.0)
        );

//        final CategoryItemRenderer renderer = plot.getRenderer();
//        renderer.setItemLabelsVisible(true);
//        final BarRenderer r = (BarRenderer) renderer;
 
    

        return chart;

    }

   
    public static void main(final String[] args) throws IOException {

        final BarChart3D demo = new BarChart3D("Test de la couverture ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
