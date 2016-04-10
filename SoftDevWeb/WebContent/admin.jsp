<%@ page import="com.softdev.core.bean.User" %>
<jsp:include page="headerA.jsp" />
        <!-- main content start-->
                <div id="page-wrapper">
            <div class="main-page">
                <div class="elements">
                    
                    <div class="clearfix"> </div>
                </div>
                <div class="elements  row">
                    <div class="col-md-4 profile widget-shadow chat-mdl-grid">
                        <h4 class="title3">Admin Profile</h4>
                        <div class="profile-top">
                            <img src="images/profile.png" alt="">
                            <h4>
                            <% 
                             User user = (User) session.getAttribute("user");
                             out.println(user.getFname().toUpperCase());
                             out.println(user.getLname().toUpperCase());
                            %>
                            </h4>
                            <h5>
                            <%
                                if (user.getType().equals("U")){
                                    out.println("User");
                                }else{
                                    out.println("Admin");
                                }
                            %>
                            </h5>
                        </div>
                        <div class="profile-text">
                            <div class="profile-row">
                                <div class="profile-left">
                                    <i class="fa fa-envelope profile-icon"></i>
                                </div>
                                <div class="profile-right">
                               
                                    <h4> <% out.println(user.getUsername()); %></h4>
                                    <p>Username</p>
                                </div> 
                                <div class="clearfix"> </div>   
                            </div>
                        </div>
                 
                    </div>
                    
                    <div class="clearfix"> </div>   
                </div>
                
            </div>
        </div>

<jsp:include page="footer.jsp" />