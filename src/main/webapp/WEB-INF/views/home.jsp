<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Persons</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <c:if test="${not empty personList}">
                <h1 class="text-center">Persons</h1>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="person" items="${personList}">
                            <tr>
                                <td>
                                    <a href="${s:mvcUrl('PC#getPerson').arg(0, person.id).build()}">${person.firstName}</a>
                                </td>
                                <td>
                                    <a href="${s:mvcUrl('PC#getPerson').arg(0, person.id).build()}">${person.lastName}</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <h2 class="text-center">Create person</h2>
            <form:form modelAttribute="personForm" class="form-horizontal" action="${s:mvcUrl('PC#createPerson').build()}">
                <div class="form-group">
                    <form:label path="firstName" class="col-xs-2 control-label">First name</form:label>
                    <div class="col-xs-10">
                        <form:input path="firstName" class="form-control" placeholder="First name"/>
                        <form:errors path="firstName" cssClass="help-block" cssStyle="color: #a94442"/>
                    </div>
                </div>
                <div class="form-group">
                    <form:label path="lastName" class="col-xs-2 control-label">Last name</form:label>
                    <div class="col-xs-10">
                        <form:input path="lastName" class="form-control" placeholder="Last name"/>
                        <form:errors path="lastName" cssClass="help-block" cssStyle="color: #a94442"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-2 col-xs-10">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>