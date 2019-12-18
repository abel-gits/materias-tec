window.onload = function() {
const { BrowserWindow } = require("electron").remote;
const app = require("electron").app;
const path = require("path");
const url = require("url");
var grupo=localStorage.getItem("grupo");
var botonFav = document.getElementsByClassName("botonFav");
var indice=localStorage.getItem("indice");
var mostrador=localStorage.getItem("mostrador");
var guardados=[];
var btnMostrador=document.getElementsByClassName('btnMostrador');


mostrarFavoritos();
var Detalles=function(){
  window.open(this.value, "Detalles")
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

var Piezas=function(){
    localStorage.setItem('grupo', this.value)
    PantallaPiezas = new BrowserWindow({width: 1100, height: 650 })
    PantallaPiezas.loadURL(
      url.format({
        pathname: path.join(__dirname, '../Piezas.html'),
        protocol: 'file',
        slashes: true
    }));
    PantallaPiezas.show();
}

var eliminarFav=function(){  
    var fid=this.value.toString();        
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

var buscaGrupos= function(){ 
	var url="http://museobillete.azurewebsites.net/api/Expo/";
	fetch(url+indice)
	.then(datos=>datos.json())
	.then(datos=>{
    var fav='';
      document.getElementById("seccion01").innerHTML = "";       
     	 for (let i = 0; i < datos.mostradores[mostrador].grupos.length; i++) {
        console.log((datos.mostradores[mostrador].grupos[i].unico));
        if (datos.mostradores[mostrador].grupos[i].unico&&(mostrador!=3)) {
       
          if (guardados.indexOf(datos.mostradores[mostrador].grupos[i].id)==-1) {
          fav='<button class="botonFav" style=" background: transparent;border:none; width:70px;" value = "'+datos.mostradores[mostrador].grupos[i].id+'"> <img id="'+datos.mostradores[mostrador].grupos[i].id+'" style="width:50px;" src="img/blanco.png" /></button>';
        }
        else
        {
          fav='<button class="botonFav" style=" background: transparent;border:none; width:70px;" value = "'+datos.mostradores[mostrador].grupos[i].id+'"> <img id="'+datos.mostradores[mostrador].grupos[i].id+'" style="width:50px;" src="img/rosa.png" /></button>';
        }
        }
          
            
        	document.getElementById("seccion01").innerHTML += `
        	<article id="secc01art${i}">
            <header>
            <span id="txtTitulo" class="letraMediana nito">  ${datos.mostradores[mostrador].grupos[i].titulo}   </span>
            </header>
            <p>
        	<img src="${datos.mostradores[mostrador].grupos[i].imagenFondoUrl}" id="imgVitrina">
        	<br>
        	<p>
          <button class="btnMostrador" value = "${i}">Grupo ${datos.mostradores[mostrador].grupos[i].id}</button>
          ${fav}
      		</article>
			`;}
        for (let i = 0; i < btnMostrador.length; i++) {
          if (datos.mostradores[mostrador].grupos[i].unico){
              btnMostrador[i].setAttribute('value', datos.mostradores[mostrador].grupos[i].piezas[0].detallesUrl)                
              btnMostrador[i].addEventListener('click', Detalles)
          }
          else{
              btnMostrador[i].addEventListener('click', Piezas)
          }
        }
        for (let t = 0; t < botonFav.length; t++) {        
            botonFav[t].addEventListener('click', eliminarFav)
      }

    });
};

buscaGrupos();
};