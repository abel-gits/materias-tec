window.onload = function() {
var indice=localStorage.getItem("indice");

const { BrowserWindow } = require("electron").remote;
const app = require("electron").app;
const path = require("path");
const url = require("url");



var btnMostrador=document.getElementsByClassName('btnMostrador');

var Grupos = function(){
   localStorage.setItem("mostrador", this.value);
   PantallaMostradores = new BrowserWindow({ width: 1100, height: 650 });
    PantallaMostradores.loadURL(
      url.format({
        pathname: path.join(__dirname, "../Grupos.html"),
        protocol: "file",
        slashes: true
      }));
    PantallaMostradores.show();
    
  };


var buscaMostradores= function(){
	var url="http://museobillete.azurewebsites.net/api/Expo/";
	fetch(url+indice)
	.then(datos=>datos.json())
	.then(datos=>{
      
      document.getElementById("seccion01").innerHTML = "";
      mostradores = datos.mostradores;
      for (let i = 0; i < mostradores.length; i++) {
        document.getElementById("seccion01").innerHTML += `
        <article id="secc01art${i}">
            <header>
            <span id="txtTitulo" class="letraMediana nito">  ${datos.mostradores[i].titulo}   </span>
            </header>
            <p>
        <img src="${datos.mostradores[i].imagenFondoUrl}" id="imgVitrina">
        <br>
        <p>
        <button class="btnMostrador" value = "${i}">Mostrador ${datos.mostradores[i].id}</button>
      </article>
			`;}
    for(let i=0;i<btnMostrador.length;i++){
      btnMostrador[i].addEventListener('click',Grupos)
    }

    });
};

buscaMostradores();
};