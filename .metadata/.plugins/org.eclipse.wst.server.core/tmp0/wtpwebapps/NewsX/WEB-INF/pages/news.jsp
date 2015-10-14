<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/NewsX/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/NewsX/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
<link href="/NewsX/resources/bootstrap/css/carousel.css" rel="stylesheet"/>
<script type="text/javascript" src="/NewsX/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/NewsX/resources/bootstrap/js/bootstrap.min.js"></script>
<title>View latest news</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">NewsX</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/NewsX/addnews">Add News <span class="sr-only">(current)</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class = "container">
<div class="row">
<div class="col-md-8">
<div class="row">


<div class="panel panel-default">
  <div class="panel-body">
    ${news.headlines}
  </div>


</div>
</div>
<div class="row">
<div class="panel-body">
    Mainstory
  </div>

</div>
<div class="row">
<div class="panel-body">
<c:if test="${news.videourl is not empty}">
   <div class="embed-responsive embed-responsive-4by3">
  <iframe class="embed-responsive-item" src="${new.videourl}"></iframe>
    
  </div>
</c:if>
<c:if test="${news.imageurl is not empty and news.videourl is empty}">
<img src="${news.imageurl}" alt="..."></div>
</c:if>
 
 
</div>
<div class="col-md-4">
<div class="row">
<div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3><a href="#">Headlines go..</a></h3>
      </div>
    </div>
</div>
<div class="row">
<div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3><a href="#">Headlines go..</a></h3>
      </div>
    </div>
</div>

<div class="row">
<div class="thumbnail">
      <img src="..." alt="...">
      <div class="caption">
        <h3><a href="#">Headlines go..</a></h3>
      </div>
    </div>
</div>
</div>

</div>
</div>

<h1> You can see the latest News</h1>
</body>
</html>