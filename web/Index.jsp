
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="imports.jspf" %>
    </head>
    <body style="background:#3F4DB8;font-family: Georgia;">
    <center>
        <div class="embed-responsive embed-responsive-16by9" style="height: 3000px;">
            <iframe class="embed-responsive-item" src="index2.html" ></iframe>
        </div>
    </center>

    <!--bootstrap pop-up-->
    <div class="modal fade" id="log" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1>Login</h1>
                </div>
                <div class="modal-body">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. In officia voluptates officiis minus a aut animi dolorum, doloremque est reiciendis alias id libero quaerat facilis delectus iusto recusandae sed. Nostrum!
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">Save changes</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <!--bootstrap pop-up-->


    <%@ include file="FootImports.jspf" %>
</body>
</html>
