<%@include file='template/menu.jsp'%>
<%@ page import="remarema.web.main.Main" %>
<%@ page import="remarema.web.main.Util" %>
<%@ page import="remarema.web.display.Setting" %>
<%@ page import="remarema.web.display.Test" %>
<%@ page import="remarema.web.display.Version" %>
<%@ page import="remarema.web.display.Node" %>
<%@ page import="remarema.web.display.Deploy" %>
<%@ page import="remarema.test.TestNode" %>

<% 
	//Creates Objects to call methods later
								
	Main main = new Main();
	Setting setting = new Setting();
	Util util = new Util();
	Test test = new Test();
	Version version = new Version();
	Node node = new Node();
	Deploy deploy = new Deploy();
%>								  


<!-- 
	Introduction
 -->
					<section id="top" class="two">
						<div class="container">

							<header>
								<%
								
							      out.println("<h1>" + test.test() + "</h1>");				//Some Testings
							      out.println("<h1>Insert some introduction here</h1>");
							      
							      TestNode n = new TestNode();
							      out.println(n.Test());
							      
							    %>
							 </header>   
							    
						</div>
					</section>


	</body>
 	
</html>