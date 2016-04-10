<%@ page import="java.util.List"%>
<%@ page import="com.softdev.core.bean.FarmStatus"%>

<jsp:include page="headerA.jsp" />
<!-- main content start-->
<div id="page-wrapper">
	<div class="main-page general">
		<h3 class="title1">Logs</h3>
		<div class="panel-info widget-shadow">
			<h4 class="title2">PROJECT REPORT:</h4>

			<div class="col-md-6 panel-grids">
				<div class="panel panel-success">
					<form method="post" action="controller?rh=report&cmd=report">
						<input type="radio" name="month" value="01">JANUARY<br>
						<input type="radio" name="month" value="02">FEBRUARY<br>
						<input type="radio" name="month" value="03">MARCH<br>
						<input type="radio" name="month" value="04">APRIL<br>
						<input type="radio" name="month" value="05">MAY<br> <input
							type="radio" name="month" value="06">JUNE<br> <input
							type="radio" name="month" value="07">JULY<br> <input
							type="radio" name="month" value="08">AUGUST<br> <input
							type="radio" name="month" value="09">SEPTEMBER<br> <input
							type="radio" name="month" value="10">OCTOBER<br> <input
							type="radio" name="month" value="11">NOVEMBER<br> <input
							type="radio" name="month" value="12">DECEMBER<br>
						<button>Submit</button>
					</form>
				</div>
				<table border="2" style="width: 100%">
					
					<%
List<FarmStatus> farmStatuses = (List<FarmStatus>) request.getAttribute("farmStatuses");
if (farmStatuses != null) { %>
	<tr>
    <td>Soil Moisture Level</td>
    <td>Analog Soil Moisture Level</td>
    <td>Temperature</td>
    <td>Water Level</td>
    <td>Date Created</td>
</tr>
  <%   for (FarmStatus farmStatus : farmStatuses) { %>
					<tr>
						<td><%= farmStatus.getSmlvl() %></td>
						<td><%= farmStatus.getAnalogSmlvl() %></td>
						<td><%= farmStatus.getTemp() %></td>
						<td><%= farmStatus.getWlvl() %></td>
						<td><%= farmStatus.getCreateDate() %></td>
					</tr>
					<% } 
} else {
    out.println("No report available.");
}%>
				</table>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
</div>


<jsp:include page="footer.jsp" />