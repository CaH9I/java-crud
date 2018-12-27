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
            <h1 class="text-center">Update person</h1>
            <form:form modelAttribute="personForm" class="form-horizontal">
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
                        <button type="submit" class="btn btn-warning">Update</button>
                        <button type="submit" class="btn btn-danger" name="_method" value="DELETE">Delete</button>
                    </div>
                </div>
            </form:form>
            <hr/>
            <a class="col-xs-offset-2 btn btn-default" href="${s:mvcUrl('HC#home').build()}">&#8592;&nbsp;Back</a>
        </div>
    </body>
</html>