<%@ page import="pjug.Pjugger" %>



<div class="fieldcontain ${hasErrors(bean: pjuggerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="pjugger.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${pjuggerInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pjuggerInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="pjugger.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${pjuggerInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pjuggerInstance, field: 'about', 'error')} ">
	<label for="about">
		<g:message code="pjugger.about.label" default="About" />
		
	</label>
	<g:textField name="about" value="${pjuggerInstance?.about}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pjuggerInstance, field: 'recruiter', 'error')} ">
	<label for="recruiter">
		<g:message code="pjugger.recruiter.label" default="Recruiter" />
		
	</label>
	<g:checkBox name="recruiter" value="${pjuggerInstance?.recruiter}" />
</div>

