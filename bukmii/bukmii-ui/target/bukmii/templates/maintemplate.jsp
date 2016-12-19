<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="bukmii" uri="bukmiiTag" %>
<%@ taglib prefix="template" uri="templateTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=IE8" />
	<meta charset="utf-8" />
	
	<link rel="shortcut icon" href="favicon.ico" />
	<title><template:get name='title'/></title>
	
	<!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="styles/materialize.min.css?<bukmii:currentDate />" media="screen,projection" />
	<template:get name='styles'/>
	
	<!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
	<template:get name='content'/>
</body>
<script type="text/javascript" src="scripts/jquery-3.1.1.min.js?<bukmii:currentDate />"></script>
<script type="text/javascript" src="scripts/materialize.min.js?<bukmii:currentDate />"></script>
<template:get name='scripts'/>
</html>