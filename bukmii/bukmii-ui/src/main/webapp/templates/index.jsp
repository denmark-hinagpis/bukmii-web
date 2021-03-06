<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="bukmii" uri="bukmiiTag" %>
<%@ taglib prefix="template" uri="templateTag" %>
<template:insert template='/templates/maintemplate.jsp'>
  <template:put name='title' content='message::Application.Title' direct='true'/>
  <template:put name='styles' content='/pages/styles/index.html'/>
  <template:put name='content' content='/pages/contents/index.jsp'/>
  <template:put name='scripts' content='/pages/scripts/index.html'/>
</template:insert>