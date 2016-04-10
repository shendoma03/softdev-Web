<jsp:include page="headerA.jsp" />
<!-- main content start-->
<div id="page-wrapper">
	<div class="main-page general">
		<h3 class="title1">Analytic Report</h3>
		<div class="panel-info widget-shadow">
			<h4 class="title2">THE PROJECT:</h4>

			<div class="col-md-6 panel-grids">
				<div class="panel panel-success">
					<h4><b>Scatter Diagram</b></h4>

					<p>Regression analysis is a statistical tool for the
						investigation of relationships between variables. Usually, the
						investigator seeks to ascertain the causal effect of one variable
						upon another. €”The effect of a price increase upon demand, for
						example, or the effect of changes in the money supply upon the
						inflation rate. To explore such issues, the investigator assembles
						data on the underlying variables of interest and employs
						regression to estimate the quantitative effect of the causal
						variables upon the variable that they influence. The investigator
						also typically assesses the €œstatistical significance of the
						estimated relationships, that is, the degree of confidence that
						the true relationship is close to the estimated relationship.</p>
						<br>
						<i>http://www.law.uchicago.edu/files/files/20.Sykes_.Regression.pdf</i>
				</div>
			</div>

            <div class="col-md-6 panel-grids">
                <div class="panel panel-success">
                    <h4><b>Regression Model</b></h4>
                        <br> 
                            Regression Model: y = -140.8x + 4707.1
                        <br>
                        This model will predict the soil moisture level given a temperature.
                        <br>
                        <br>
                        <form method="post" action="controller?rh=report&cmd=analytics">
                        Enter temperature: <input type="text" name="temperature"><br>
                        <input type="submit" value="Submit">
                        </form>
					<%
						Double psmlvl = (Double) request.getAttribute("psmlvl");
						if (psmlvl != null) {
							out.println("Predicted Soil Moisture Level: " + psmlvl);
						}
					%>
				</div>
            </div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />