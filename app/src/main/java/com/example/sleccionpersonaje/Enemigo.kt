package com.example.sleccionpersonaje

class Enemigo {
    var clase=""
    var vida=100
    var ataque=0
    constructor(clase:String){
        if(clase.equals("Jefe")){
            vida=200
            ataque=30
        }
        else{
            vida=100
            ataque =20}
        this.clase=clase
    }

}