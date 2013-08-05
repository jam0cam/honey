function createChart (destination, url, xLegendCoordinate) {
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: destination,
            type: 'column',
            marginRight: 50,
            marginBottom: 45,
            events: {
                load:
                    function requestData() {
                        var myChart = this;
                        $.ajax({
                            url: url,
                            type: "GET",
                            dataType: "json",
                            success: function(data) {
                                for (var i=0; i<data.series.length; i++) {
                                    myChart.addSeries({
                                        type: data.series[i].seriesType,
                                        name: data.series[i].name,
                                        data: data.series[i].myData
                                    });
                                }

                                myChart.xAxis[0].setCategories(data.xAxis.data, false);
                                myChart.yAxis[0].setTitle({
                                    text: data.yTitle
                                }, false);

                                myChart.setTitle({
                                    text: data.chartTitle,
                                    margin: 50
                                })

                                //if there is no pie data, it will just bomb out
                                myChart.addSeries({
                                    type: 'pie',
                                    name: data.pieData.name,
                                    data: data.pieData.data,
                                    center: [200, 20],
                                    size: 100,
                                    showInLegend: false,
                                    dataLabels: {
                                        distance: -25,
                                        color: 'white',
                                        enabled: true,
                                        format: '{point.y}'
                                    }
                                })

                                myChart.redraw();
                            },
                            cache: false
                        });
                    }
            }
        },
        title: {
            text: ''
        },
        yAxis: {
            title: {
                text: 'y-axis'
            },
            labels:
            {
                enabled:true
            }
        },
        plotOptions: {
            column: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            align: 'right',
            x: xLegendCoordinate,
            verticalAlign: 'top',
            y: 20,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        series: []
    });
};



function createPie(destination, url) {
    $("#" + destination).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            events: {
                load:
                    function requestData() {
                        var myChart = this;
                        $.ajax({
                            url: url,
                            type: "GET",
                            dataType: "json",
                            success: function(data) {
                                myChart.addSeries({
                                    type: 'pie',
                                    name: data.name,
                                    data: data.data
                                });

                                myChart.setTitle({
                                    text: data.title
                                })

                                myChart.redraw();
                            },
                            cache: false
                        });
                    }
            }
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ' '
        },
        tooltip: {
            pointFormat: '{series.name}: <b>${point.y}.00</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: []
    });
};