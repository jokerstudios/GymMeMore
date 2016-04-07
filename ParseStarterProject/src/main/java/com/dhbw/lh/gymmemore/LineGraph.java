/*package com.dhbw.lh.gymmemore;

import android.content.Context;
import android.content.Intent;

import org.achartengine.ChartFactory;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LineGraph {
    public Intent getIntent(Context context){
        int x[] = {1, 3, 5, 8, 12};
        int y[] = {12, 26, 22, 35, 62};

        TimeSeries series = new TimeSeries("Line1");

        for(int i=0; i < x.length; i++){
            series.add(x[i],y[i]);
        }

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        dataset.addSeries(series);

        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
        XYSeriesRenderer renderer = new XYSeriesRenderer();

        mRenderer.addSeriesRenderer(renderer);

        Intent intent = ChartFactory.getLineChartIntent(context, dataset, mRenderer, "Line Graph");
        return intent;
    }
}
*/