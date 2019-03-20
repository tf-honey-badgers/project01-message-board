 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Register</title>

  <!-- Custom fonts for this template-->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/resources/css/board.css">
</head>

<body class="bg-gradient-primary">
<jsp:include page="../include/header.jsp"></jsp:include>
  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Board Read Page</h1>
              </div>
              <form class="user" method="post" >
             	 <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="bno" value="${board.bno }" readonly="readonly">
                </div>
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="title" value="${board.title }" readonly="readonly">
                  </div>
                </div>
                <div class="form-group ">
                  	<textarea rows="7"  name="content" class="form-control"  readonly="readonly">${board.content }</textarea>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="writer" value="${board.writer }" readonly="readonly">
                </div>
         		 <hr>
              <!--   <button class="btn btn-primary btn-user " data-oper="modify"> -->
                 	<a href="/board/modify?bno=${board.bno }" class="btn btn-primary btn-user " >Modify</a> 
               <!--  </button > -->
                 <button class="btn btn-primary btn-user " data-oper="list">
                  <a href="/board/listYuni" class="text-white" >List</a> 
                </button >
                
                 <button class="btn btn-primary btn-user " data-oper="remove">
                  <a href="/board/removeYuni" class="text-white" >Remove</a> 
                </button >
                <hr>
               
              </form>
         
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/js/sb-admin-2.min.js"></script>
  <script>
  	$(document).ready(function(){
  		
  		var formObj= $('form');
  		
  		console.log(formObj);
  		
  		$('button').on('click', function(e){
  			e.preventDefault();
  			
  			var operation= $(this).data('oper');
  			
  			console.log(operation)
  			
  			if(operation==='remove'){
  				formObj.attr('action', '/board/removeYuni?bno=${board.bno }')
  			}else if(operation==='list'){
  				formObj.attr('action', '/board/listYuni')
  			}
  			formObj.submit();
  			
  		})
  		
  	})
  	
  
  
  </script>

</body>

</html>
