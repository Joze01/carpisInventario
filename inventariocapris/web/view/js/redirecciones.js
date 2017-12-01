/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function eliminar(item,id,url){
    if(confirm("Esta seguro de eliminar este "+item)){
          window.location=url+"?metodo=eliminar&id="+id;
    }else{
        
        
    }
}


function eliminar2(item,id,url){
    if(confirm("Esta seguro de eliminar este "+item)){
          window.location=url+"?metodo=retirar&id="+id;
    }else{
        
        
    }
}


