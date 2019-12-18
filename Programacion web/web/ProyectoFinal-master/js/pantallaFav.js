window.onload = function(){
	
const { BrowserWindow } = require("electron").remote;
const app = require("electron").app;
const path = require("path");
const url = require("url");
var indice=localStorage.getItem("indice");
var grupo=localStorage.getItem("grupo");	
var mostrador=localStorage.getItem("mostrador");
	var vit='V1';
	var guardado=[];
	mostrarFavoritos();
var botonFav = document.getElementsByClassName("botonFav");
var btnMostradores = document.getElementsByClassName("btnMostradores");
var eliminarFav=function(){		
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
	function mostrarFavoritos(){

  fetch('http://localhost/pw218309server/mostrar.php')   
  .then(dato => dato.json())
  .then(dato => {
      for (var i = 0; i < dato.length; i++) {
        guardado.push(dato[i].favId);        
      }
  })
}


function mostrarGrupos(guardados){		
		fetch('http://museobillete.azurewebsites.net/api/Expo/V4')
		.then(datos=>datos.json())
		.then(datos=>{
			for (var mos = 0; mos < datos.mostradores.length; mos++) {
				for (var gru = 0; gru < datos.mostradores[mos].grupos.length; gru++) {	
					for (var pie = 0; pie < datos.mostradores[mos].grupos[gru].piezas.length; pie++) {						
						if (guardado.indexOf(datos.mostradores[mos].grupos[gru].piezas[pie].id)!=-1) {
								document.getElementById("artFav").innerHTML += `
				                  <article class="abajoIzquierda infogrupo">
				                  <article>
				                  <img src="${
				                        datos.mostradores[mos].grupos[gru].piezas[pie]
				                          .imagenFondoUrl
				                      }" class="imgFoto">
				                      

				                  </article> 
				                  <article class="textogrupo">
				                  <div class="txtNombre">${
				                        datos.mostradores[mos].grupos[gru].piezas[pie]
				                          .titulo
				                      }</div>
				                     
				                      				                      
				                  		<button value ="${datos.mostradores[mos].grupos[gru].piezas[pie].id}" class="botonFav" style=" background: transparent;border:none; width:70px;" > <img id="${datos.mostradores[mos].grupos[gru].piezas[pie].id}" style="width:50px;" src="img/rosa.png" /></button>				                
				                  </article>				                      				                    
				                  </article>				                  				  
				              `;
							}
										
					for (let p = 0; p < botonFav.length; p++) { 		    			
        				botonFav[p].addEventListener("click", eliminarFav);
      				}      		
					}			
				}
			}
		})
	}
fetch('http://localhost/pw218309server/mostrar.php')   
	.then(dato => dato.json())
	.then(dato => {		
		if (dato.length==0) {
			document.getElementById("artFav").innerHTML += `
				<article id="favoritosVacio"><h1>No hay favoritos</h1></article>				
			`
		}

	    for (var v =0; v <3; v++) {

	    	fetch('http://museobillete.azurewebsites.net/api/Expo/'+vit)
	    	.then(datos=>datos.json())
	    	.then(datos=>{
	    		
		    	for (var i =0; i<datos.mostradores.length; i++) {

		    		for (var t = 0; t <datos.mostradores[i].grupos.length; t++) {

		    			for (var r=0; r < dato.length; r++) {
		    				
		    				if (dato[r].favId==(datos.mostradores[i].grupos[t].id)) {		    					
		    					descrip = datos.mostradores[i].grupos[t].descripcion;
							    if (descrip == null) {
							        descrip = "Grupo de Piezas";
							        }

		    					document.getElementById("artFav").innerHTML += `
								<article class="abajoIzquierda info">
									<img src="${datos.mostradores[i].grupos[t].imagenFondoUrl}" class="imgFoto">													
									<div class="txtNombre">${datos.mostradores[i].grupos[t].titulo}</div>
					          		<div class="txtNombre">${descrip}
					          		</div>
									
									<button class="botonFav" style=" background: transparent;border:none; width:70px;" value ="${datos.mostradores[i].grupos[t].id}"> <img id="${datos.mostradores[i].grupos[t].id}" style="width:50px;" src="img/rosa.png" /></button>
								</article>   

				    			`;
		    				}	
		    			}
		    			

		    			for (let p = 0; p < botonFav.length; p++) { 		    			
        					botonFav[p].addEventListener("click", eliminarFav);
      					}		
      					 		
		    		}
		    	}	    	
	        })
	    	if (vit=='V1') {
	    		vit='V2';
	    	}else
	    		if (vit=='V2') {
	    			vit='V3';
	    		}
	    }	    	   
	    mostrarGrupos(dato);
	    vit='V1';
	})
}
