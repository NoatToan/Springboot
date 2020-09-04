<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>

    	
    	<link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css' />" />
 <link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin.css' />" />
    

	  
	  
	  
    <!-- sweetalert -->
    <script src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css' />" />
</head>
<body class="no-skin">
	<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->
	<div id="wrapper">

		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->
		<div id="content-wrapper">
	      	<div class="container-fluid">
				<dec:body/>
			</div>
		</div>
		
		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	


			  <!-- Bootstrap core JavaScript-->
			  <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
			  <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
			
			  <!-- Core plugin JavaScript-->
			  <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
			
			  <!-- Page level plugin JavaScript-->
			  <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js'/>"></script>
			  <script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
			  <script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>
			
			  <!-- Custom scripts for all pages-->
			  <script src="<c:url value='/template/admin/js/sb-admin.min.js'/>"></script>
			
			  <!-- Demo scripts for this page-->
			  <script src="<c:url value='/template/admin/js/demo/datatables-demo.js'/>"></script>
			  <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js'/>"></script>
	

</body>
</html>