
 var tagScript = '(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)'; 
        /** 
        * Eval script fragment 
        * @return String 
        */ 
        String.prototype.evalScript = function() 
        { 
                return (this.match(new RegExp(tagScript, 'img')) || []).evalScript(); 
        }; 
        /** 
        * strip script fragment 
        * @return String 
        */ 
        String.prototype.stripScript = function() 
        { 
                return this.replace(new RegExp(tagScript, 'img'), ''); 
        }; 
        /** 
        * extract script fragment 
        * @return String 
        */ 
        String.prototype.extractScript = function() 
        { 
                var matchAll = new RegExp(tagScript, 'img'); 
                return (this.match(matchAll) || []); 
        }; 
        /** 
        * Eval scripts 
        * @return String 
        */ 
        Array.prototype.evalScript = function(extracted) 
        { 
                var s=this.map(function(sr){ 
                         var sc=(sr.match(new RegExp(tagScript, 'im')) || ['', ''])[1]; 
                         if(window.execScript){ 
                              window.execScript(sc); 
                         } 
                        else 
                       { 
                           window.setTimeout(sc,0); 
                        } 
                }); 
                return true; 
        }; 
        /** 
        * Map array elements 
        * @param {Function} fun 
        * @return Function 
        */ 
        Array.prototype.map = function(fun) 
        { 
                if(typeof fun!=="function"){return false;} 
                var i = 0, l = this.length; 
                for(i=0;i<l;i++) 
                { 
                        fun(this[i]); 
                } 
                return true; 
        };  







function retornaLista(variable){
	var valor = localStorage.getItem(variable);
	return valor;
}

function cargarHTTP(){
	var XMLHTTP;
	if(window.XMLHttpRequest){
		XMLHTTP = new XMLHttpRequest();
	}
	else{
		XMLHTTP = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return XMLHTTP;
}

function cargarDatos(div,parametro,pagina){
			ajax = cargarHTTP();//primer div
			//alert("Ejecuto");
			ajax.onreadystatechange=function(){
			if(ajax.readyState==4 && ajax.status==200){
				var scs=ajax.responseText.extractScript();
				document.getElementById(div).innerHTML=ajax.responseText.stripScript();
				scs.evalScript();
			}
			}
			ajax.open("POST",pagina,true);
			ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			ajax.send("objetoJson="+parametro);
                             
            
        
}

function asynTaskConfirm(mensaje,parametro, opcion, pagina){
  if(confirm(mensaje)){
           $.ajax({
                   type: "POST",
                    url: pagina,
                    data: {"objetoJson" : parametro, "funcion": opcion },
                    success: function(data){
                         alert(data);
                     }
          });
       
  }
}

function nuevoDetalle(idEquipo, idPedido, cantidad){
      if(confirm(mensaje)){
           $.ajax({
                   type: "POST",
                    url: "/inventariocapris/PedidoController",
                    data: {"equipo" : idEquipo,"pedido": idPedido, "metodo": "" },
                    success: function(data){
                         alert(data);
                     }
          });
       
  }
    
    
}

function asynTask(mensaje,parametro, opcion, pagina, paginaResponse){
           $.ajax({
                   type: "POST",
                    url: pagina,
                    data: {"IdMaterial" : parametro, "opcion": opcion },
                    success: function(data){
                         alert(data);
                     }
          });
}


