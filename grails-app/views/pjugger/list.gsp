
<%@ page import="pjug.Pjugger" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pjugger.label', default: 'Pjugger')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pjugger" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pjugger" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'pjugger.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'pjugger.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="about" title="${message(code: 'pjugger.about.label', default: 'About')}" />
					
						<g:sortableColumn property="recruiter" title="${message(code: 'pjugger.recruiter.label', default: 'Recruiter')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pjuggerInstanceList}" status="i" var="pjuggerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pjuggerInstance.id}">${fieldValue(bean: pjuggerInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: pjuggerInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: pjuggerInstance, field: "about")}</td>
					
						<td><g:formatBoolean boolean="${pjuggerInstance.recruiter}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pjuggerInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
