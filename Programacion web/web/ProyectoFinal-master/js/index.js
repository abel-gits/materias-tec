window.onload = function() {
  const { BrowserWindow } = require("electron").remote;
  const app = require("electron").app;
  const path = require("path");
  const url = require("url");

  var btnMostrador=document.getElementsByClassName('btnMostrador');

    var Mostradores = function(){
          var variable = "";
    var urls = "http://museobillete.azurewebsites.net/api/Expo";
    fetch(urls)
      .then(datos => datos.json())
      .then(datos => {
        variable = datos[this.value].id;
        console.log(variable);
        localStorage.setItem("indice", variable);
      });


    PantallaMostradores = new BrowserWindow({ width: 1200, height: 650 });
    PantallaMostradores.loadURL(
      url.format({
        pathname: path.join(__dirname, "../Mostradores.html"),
        protocol: "file",
        slashes: true
      }));
    PantallaMostradores.show();
    
  };
  var mostrarFav=function(){
    PantallaFav = new BrowserWindow({ width: 900, height: 500 });
    PantallaFav.loadURL(
      url.format({
        pathname: path.join(__dirname, "../PantallaFav.html"),
        protocol: "file",
        slashes: true
      }));
    PantallaMostradores.show();
  }

  var muestraVitrinas = function() {
    fetch("http://museobillete.azurewebsites.net/api/Expo")
      .then(datos => datos.json())
      .then(datos => {
        document.getElementById("seccion01").innerHTML = "";
        for (let i = 0; i < datos.length; i++) {
          
        	document.getElementById("seccion01").innerHTML += `
          
        	<article id="secc01art${i}">
        		<header>
        		<span id="txtTitulo" class="letraMediana nito">   ${datos[i].titulo}   </span>
        		</header>
        		<p>
				<img src="${datos[i].imagenFondoUrl}" id="imgVitrina">
				<br>
				<p>
				<button class="btnMostrador" value = "${i}">Vitrina ${i+1}</button>
			</article>
			`;}
			for(let i=0;i<btnMostrador.length;i++){
			btnMostrador[i].addEventListener('click',Mostradores)
		}
    	});
      document.getElementById('favoritos').addEventListener('click',mostrarFav);
  };



  muestraVitrinas();
};