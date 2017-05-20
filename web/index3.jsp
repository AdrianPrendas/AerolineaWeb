<%-- 
    Document   : index3
    Created on : 20-may-2017, 9:03:37
    Author     : Jazmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%@ include file="imports.jspf" %>
    </head>
    <body>
       <%@ include file="Header.jspf" %>
    <header>
    </header>
    <div class="container">
        <br>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a href="#" class="navbar-brand">PULSE</a>-->
                </div>
                <div class="collapse navbar-collapse" id="navbar-1">
                    <ul class="nav nav-tabs nav-justified">
                        <li><a href="Index.jsp" target="frame" class="navbar-brand">Inicio</a></li>
                        <li><a href="promociones.jsp" target="frame" class="navbar-brand">Promociones</a></li>
                        <li><a href="reservaciones.jsp" target="frame" class="navbar-brand">Reservaciones</a></li>
                        <li><a href="rutas.jsp" target="frame" class="navbar-brand">Rutas</a></li>
                        <li><a href="vuelos.jsp" target="frame" class="navbar-brand">Vuelos</a></li>
                        <li><a href="tiquetes.jsp" target="frame" class="navbar-brand">Tiquetes</a></li>
                        <li><a href="servicios.jsp" target="frame" class="navbar-brand">Servicios</a></li>
                        <li><a href="planes.jsp" target="frame" class="navbar-brand">Planes</a></li>
                        <li><a href="contactenos.jsp" target="frame" class="navbar-brand">Contactenos</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="carusel" class="carousel slide">
            <iframe name="frame" src= "index2.html" width=1150 height=600>  
            <ol id="listaCarrucel" class="carousel-indicators" ></ol>
            <!-- lista de objetos para el carrucel cargado por script load.js-->
            <div id="imagenesCarrucel" class="carousel-inner" role="listbox" >
                
            </div>
            <!-- Wrapper for slides --><!-- img para c/u li anteriores cargado con script load.js-->

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#carusel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carusel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            </iframe>
        </div>

        <br>


    </div>
    </body>
</html>
