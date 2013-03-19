
<%@ page import="pjug.Pjugger" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pjugger.label', default: 'Pjugger')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pjugger" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pjugger" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pjugger">
			
				<g:if test="${pjuggerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="pjugger.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${pjuggerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pjuggerInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="pjugger.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${pjuggerInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pjuggerInstance?.about}">
				<li class="fieldcontain">
					<span id="about-label" class="property-label"><g:message code="pjugger.about.label" default="About" /></span>
					
						<span class="property-value" aria-labelledby="about-label"><g:fieldValue bean="${pjuggerInstance}" field="about"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pjuggerInstance?.recruiter}">
				<li class="fieldcontain">
					<span id="recruiter-label" class="property-label"><g:message code="pjugger.recruiter.label" default="Recruiter" /></span>
					
						<span class="property-value" aria-labelledby="recruiter-label"><g:formatBoolean boolean="${pjuggerInstance?.recruiter}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${pjuggerInstance?.id}" />
					<g:link class="edit" action="edit" id="${pjuggerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
