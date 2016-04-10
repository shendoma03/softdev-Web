<jsp:include page="header.jsp" />
        <!-- main content start-->
        <div id="page-wrapper">
            <div class="main-page general">
                <h3 class="title1">Control Sprinkler</h3>
                <center>
                <div class="panel-info widget-shadow">
               
                    <div class="col-md-6 panel-grids">
                        <div class="panel panel-success"> 
                            <div class="panel-heading"> 
                                <h1 class="panel-title">SPRINKLER ON/OFF</h1>
                            </div> 
                            <div class="panel-body"> 
                                <form method="post" action="controller?rh=sprinklerRequest&cmd=switch">
                                <input type="radio" name="operation" value="on">ON<br>
                                <input type="radio" name="operation" value="off">OFF<br>
                                <button>Submit</button>
                                </form>
                                <% 
                                
                                String message = (String) request.getAttribute("message");
                                if (message != null){
                                    out.println(message);
                                }
                                %>
                            </div> 
                         </div>
                    </div>
                   
                    <div class="clearfix"> </div>
                </div>
                </center>
            </div>
        </div>

<jsp:include page="footer.jsp" />