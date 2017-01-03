<%--
  User: shiddiq
  Date: 12.05.2016
  Time: 13.28 PM Jakarta add jstl spring form tag 
  Version : 2 
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page session="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="shiddiq">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ISA APP</title> 
      <!-- jQuery -->
     
    <script src="<c:url value='/resources/js/jquery-1.10.2.js' />" > </script>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
     <!-- Bootstrap CSS -->
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    
    <link href="<c:url value='/resources/css/jquery-ui.css' />" rel="stylesheet"> 
    <link href="<c:url value='/resources/css/jqGrid-4.5.4/ui.jqgrid.css' />" rel="stylesheet">
    <script src="<c:url value='/resources/js/jquery-ui.js' />" > </script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <script src="http://www.trirand.com/blog/jqgrid/js/jquery.jqGrid.js" > </script>
    <script src="<c:url value='/resources/js/jquery.jqGrid.min.js' />" > </script>
    <script src="<c:url value='/resources/js/grid.locale-en.js' />" > </script>
    <!-- Custom CSS -->
    <link href="<c:url value='/resources/css/sb-admin.css' />" rel="stylesheet"> 
    <!-- Morris Charts CSS -->
    <link href="<c:url value='/resources/css/plugins/morris.css' />" rel="stylesheet"> 
    <!-- Custom Fonts -->
    <link href="<c:url value='/resources/font-awesome/css/font-awesome.min.css' />" rel="stylesheet"> 
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  
      <style type="text/css">
	  
	    html,
		body {
		  height: 100%;
		  /* The html and body elements cannot have any padding or margin. */
		}
		
		/* Wrapper for page content to push down footer */
		#wrap {
		  min-height: 100%;
		  height: 100%;
		  /* Negative indent footer by its height */
		  margin: 0 auto -82px 0;
		  /* Pad bottom by footer height */
		  padding: 0 0 80px 0;
		}
		
		/* Set the fixed height of the footer here */
		#footer {
		  height: 80px;
		  background-color: #f5f5f5;
		}
		
		
		#wrap > .center-container {
		  padding: 50px 0 0 0;
		  margin:0;
		}
		
		#footer > .container {
		  padding-top:5px
		  padding-left: 15px;
		  padding-right: 15px;
		}
		
		.center-container {
		  height:100%;
		  display: table;
		  width:100%;
		  margin:0;
		}
		
		.center-row {
		  height:50%;
		  width:100%;
		  display: table-row;
		}
		  
		.center-row > div {
		  height:100%;
		  width:50%;
		  display: table-cell;
		  border:1px solid #eee
		}
</style>

<script>
$(document).ready(function() {
  
    
        $("#ISAGrid").jqGrid({
            url:'getsensor',
            mtype : "GET",
            datatype: "json",
            height: 100,
              colNames:['id','period','executiontime','deadline'],
              colModel:[
    			{name:'id',index:'id', width:60},
                {name:'period',index:'period', width:90},
                {name:'executiontime',index:'executiontime', width:160},
                {name:'deadline',index:'deadline', width:60}     
              ],
              multiselect: true,
              pager:'#pager',
              shrinkToFit : false,
              caption: "ISA Sensor List"
          });
        
  });
        
function formSubmit() {
    document.getElementById("logoutForm").submit();
  }

</script>
</head>
<body >
<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ISA Scheduling Project</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
              
               
                <li class="dropdown">
                 <c:url value="/j_spring_security_logout" var="logoutUrl" />
                 <form action="${logoutUrl}" method="post" id="logoutForm">
                 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                 </form>
                  <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>  ${pageContext.request.userPrincipal.name} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                      
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="javascript:formSubmit()"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            </c:if>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li >
                        <a href="/ISAAPP/isasensordashboard"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li class="active">
                        <a href="/ISAAPP/GAtraining"><i class="fa fa-fw fa-bar-chart-o"></i> Data Training</a>
                    </li>
                    <li>
                        <a href=""><i class="fa fa-fw fa-table"></i> Statistics</a>
                    </li>
                  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            ISA Sensor Form 
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> ISA Scheduling Data Training
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <i class="fa fa-info-circle"></i>Genetic Algorithm  is a method for solving both constrained and unconstrained optimization problems based on a natural selection process that mimics biological evolution.
                        </div>
                    </div>
                </div>
              

              
                <!-- /.row -->

                <div class="row">
             
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-money fa-fw"></i>ISA Sensor List</h3>
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                <table id="ISAGrid"></table>
                       
             					<div id="pager"></div>			
                                	                                  
                            	</div>
                        </div>
                    </div>
                </div>
                <!-- /.row 
                  <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Comparison between GA with DMS </h3>
                            </div>
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                        </div>
                    </div>
                </div>
                -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->







</body>
</html>