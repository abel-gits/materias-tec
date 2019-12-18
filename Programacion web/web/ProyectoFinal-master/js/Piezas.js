window.onload = function() {	
var indice=localStorage.getItem("indice");
var mostrador=localStorage.getItem("mostrador");
var grupo=localStorage.getItem("grupo");
var guardados=[];
const { BrowserWindow } = require("electron").remote;
const app = require("electron").app;
const path = require("path");
const url = require("url");
var botonFav = document.getElementsByClassName("botonFav");

var detalles="";

var btnMostrador=document.getElementsByClassName('btnMostrador');
mostrarFavoritos();
var Detalles=function(){
 var url = "http://museobillete.azurewebsites.net/api/Expo/";
  console.log(url + indice);
  fetch(url + indice)
    .then(datos => datos.json())
    .then(datos => {
      detalles =
        datos.mostradores[mostrador].grupos[grupo].piezas[this.value]
          .detallesUrl;
      window.open(detalles, "_self");
    });
}
function mostrarFavoritos(){

  fetch('http://localhost/pw218309server/mostrar.php')   
  .then(dato => dato.json())
  .then(dato => {
      for (var i = 0; i < dato.length; i++) {
        guardados.push(dato[i].favId);        
      }
  })
}
var agregar=function(){ 
    var fid=this.value.toString();        
    console.log(fid); 
    var x=document.getElementById(fid);
    var atributo = x.getAttribute('src');   
    if (atributo=='img/rosa.png') {     
      document.getElementById(fid).src="img/blanco.png";
      var id=this.value;
      const data = new FormData();
          data.append("id",id);                  
          fetch('http://localhost/pw218309server/eliminar.php',{
              method:'post',
              body:data
            })          
    }else{
      document.getElementById(fid).src="img/rosa.png";
      var fav=this.value;                        
            const data = new FormData();
            data.append('favId',fav);          
          fetch('http://localhost/pw218309server/agregar.php',{
              method:'post',
              body:data
            })      
    }         
  }
var buscarPiezas= function(){
	var url="http://museobillete.azurewebsites.net/api/Expo/";
	fetch(url+indice)
	.then(datos=>datos.json())
	.then(datos=>{
		var fav;
      document.getElementById("seccion01").innerHTML = "";

     	 for (let i = 0; i < datos.mostradores[mostrador].grupos[grupo].piezas.length; i++) {     	 	
     	 	if (guardados.indexOf(datos.mostradores[mostrador].grupos[grupo].piezas[i].id)==-1) {
     	 		fav='<button class="botonFav" style=" background: transparent;border:none; width:70px;" value = "'+datos.mostradores[mostrador].grupos[grupo].piezas[i].id+'"> <img id="'+datos.mostradores[mostrador].grupos[grupo].piezas[i].id+'" style="width:50px;" src="img/blanco.png" /></button>'
     	 	}
     	 	else{
     	 		fav='<button class="botonFav" style=" background: transparent;border:none; width:70px;" value = "'+datos.mostradores[mostrador].grupos[grupo].piezas[i].id+'"> <img id="'+datos.mostradores[mostrador].grupos[grupo].piezas[i].id+'" style="width:50px;" src="img/rosa.png" /></button>'
     	 	}
        	document.getElementById("seccion01").innerHTML += `
        	<article id="secc01art${i}">
            <header>
            <span id="txtTitulo" class="letraMediana nito">  ${datos.mostradores[mostrador].grupos[grupo].piezas[i].titulo}   </span>
            </header>
            <p>
        	<img src="${datos.mostradores[mostrador].grupos[grupo].piezas[i].imagenFondoUrl}" id="imgVitrina">
        	<br>
        	<p>
          <button class="btnMostrador" value = "${i}">Detalle</button>
          ${fav}
      		</article>
			`;}
      for (let i = 0; i < btnMostrador.length; i++) {
            btnMostrador[i].addEventListener('click', Detalles)
      }
      for (let i = 0; i < botonFav.length; i++) {
            botonFav[i].addEventListener('click', agregar)
      }
    });
};

buscarPiezas();
 } ;