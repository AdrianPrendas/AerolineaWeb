<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <%@ include file="imports.jspf" %>        
    </head>
    <body>       
        <div style="width: 400px; margin :auto; margin-top: 100px; margin-left: 200px; background-color: #6496c8"> 
            <form id="managerCiudades">
                <legend> Agregar una ciudad </legend>
                <table>
                    <tr>
                        <td>
                            <label> Identificador </label> 
                        </td>
                        <td>
                            <input type="text" id="id" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Siglas </label>
                        </td>
                        <td>
                            <input type="text" id="año">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Nombre </label>
                        </td>
                        <td>
                            <input type="text" id="modelo">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Pais </label>
                        </td>
                        <td>
                            <input type="text" id="marca">
                        </td>
                    </tr>
                    <tr>
                        <td colspan = 2>
                            <input type="file" id="imagen">
                        </td>
                    </tr>
                </table>
                <p><button type="button" onclick="#">Agregar</button></p>                
            </form>
        </div> 
        <script> // Model
            function Model() {
                this.Model();
            }              
  
            Model.prototype={
                Model: function(){
                }
            };
        </script>       
        <script> // Controller
            function Controller(model,view) {
                this.Controller(model,view);
            }  
            Controller.prototype={
                Controller: function(model,view){
                    this.model=model;
                    this.view=view;
                    model.producto=new Producto("","",0,[]);
                    view.showProducto();
                },
                productAdd: function(){
                    var view = this.view;
                    var model = this.model;
                    var codigo = document.getElementById("codigo").value;
                    var descripcion = document.getElementById("descripcion").value;
                    var precio = parseInt(document.getElementById("precio").value);
                    var producto = new Producto(codigo,descripcion,precio,[]);
                    var imagen = document.getElementById("imagen").files[0];
                    Proxy.productAdd(producto,imagen,
                    function(status){
                        switch(status){
                            case 0:
                                view.showMessage("Datos agregados");
                                model.producto=new Producto("","",0,[]);
                                view.showProducto();
                                break;                                 
                            case 1:
                                view.showMessage("Registro duplicado");
                        }
                    });
                }
            };
        </script>
        <script> // View
            var model;
            var controller;
            function pageLoad(event){
		model=new Model();  
		controller = new Controller(model,window);
            }
            function showMessage(message){
                window.alert(message);
            }        
            function showProducto(){
                document.getElementById("codigo").value=model.producto.codigo;
                document.getElementById("descripcion").value=model.producto.descripcion;
                document.getElementById("precio").value=model.producto.precio;
            }       
            document.addEventListener("DOMContentLoaded",pageLoad);
        </script>   
    </body>
</html>