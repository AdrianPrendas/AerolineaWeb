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
            <form >
                <legend> Agregar un avión </legend>
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
                            <label> Año </label>
                        </td>
                        <td>
                            <select name="año" id="año">
                                <option Selected value="2017">2017</option>
                                <option value="2016">2016</option>
                                <option value="2015">2015</option>
                                <option value="2014">2014</option>
                                <option value="2013">2013</option>
                                <option value="2012">2012</option>
                                <option value="2011">2011</option>
                                <option value="2010">2010</option>
                                <option value="2009">2009</option>
                                <option value="2008">2008</option>
                                <option value="2007">2007</option>
                                <option value="2006">2006</option>
                                <option value="2005">2005</option>
                                <option value="2004">2004</option>
                                <option value="2003">2003</option>
                                <option value="2002">2002</option>
                                <option value="2001">2001</option>
                                <option value="2000">2000</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Modelo </label>
                        </td>
                        <td>
                            <input type="text" id="modelo">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Marca </label>
                        </td>
                        <td>
                            <input type="text" id="marca">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Cantidad de pasajeros </label>
                        </td>
                        <td>
                            <input type="text" id="cantpasajeros">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Cantidad de filas </label>
                        </td>
                        <td>
                            <input type="text" id="cantfilas">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label> Cantidad de asientos por fila </label>
                        </td>
                        <td>
                            <input type="text" id="asientosxfila">
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
                    var identificador = document.getElementById("id").value;
                    var año = document.getElementById("año").value;
                    var modelo = document.getElementById("modelo").value;
                    var marca = document.getElementById("marca").value;
                    var cantpasajeros = document.getElementById("cantpasajeros").value;
                    var cantfilas = document.getElementById("cantfilas").value;
                    var asientosxfila = document.getElementById("asientosxfila").value;
                    var producto = new Avion(identificador,año,modelo, marca, cantpasajeros, cantfilas, asientosxpila);
                    Proxy.avionAdd(producto,imagen,
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