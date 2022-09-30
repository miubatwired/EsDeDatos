public static void main(String[] args) {
		Puerta[] arreglo = new Puerta[5];
		
		for(int ind=0; ind<arreglo.length; ind++) {
			String material = JOptionPane.showInputDialog(
					"Ingresa material de la puerta " + (ind+1) + ": ");
			int resp = JOptionPane.showConfirmDialog(null,
					"Esta la puerta abierta", "Objeto Puerta",
					JOptionPane.YES_NO_OPTION);
			if(resp == 0) {
				arreglo[ind] = new Puerta(material, true);
			}else {
				arreglo[ind] = new Puerta(material, false);
			}
			resp = JOptionPane.showConfirmDialog(null, 
					"Capturar otra puerta?", "Captura puertas",
					JOptionPane.YES_NO_OPTION);
			if(resp != 0) {
				ind = arreglo.length;
			}
		}
		
		//Mostrar el arreglo
		String salida = "\n Lista de puertas \n";
		for(int ind=0; ind<arreglo.length; ind++) {
			if(arreglo[ind] != null) {   //hay objeto
				salida = salida + arreglo[ind].toString() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, salida);

		//Mostrar las puertas de metal
		salida = "\nPuertas de metal \n";
		int num = 1;
		for(Puerta cadaPuerta : arreglo) {
			if(cadaPuerta != null && cadaPuerta.getMaterial().toLowerCase().equals("metal")) {
				salida = salida + num + ")" + cadaPuerta.toString() + "\n";
			}
			num++;
		}
		JOptionPane.showMessageDialog(null, salida);
		
		//Mostrar las puertas abiertas
		salida = "\nPuertas abiertas\n";
		num = 1;
		for(Puerta cadaPuerta : arreglo) {
			if(cadaPuerta != null && cadaPuerta.isAbierta()) {
				salida = salida + num + ")" + cadaPuerta.getMaterial() + "\n";
			}
			num++;
		}
		JOptionPane.showMessageDialog(null, salida);
	}
  
  	arrayFront9:
public boolean arrayFront9(int[] nums) {
  if(nums.length>3){
    for(int pos=0;pos<4;pos++){
      if(nums[pos]==9){
        return true;
      }
    }
  }
  if(nums.length<4){
    for(int pos=0;pos<nums.length;pos++){
       if(nums[pos]==9){
        return true;
      }
  }
  }
 return false;
}

	arrayCount9:
public int arrayCount9(int[] nums) {
  int cont=0;
  for(int pos=0;pos<nums.length;pos++){
    if(nums[pos]==9){
      cont++;
    }
  }
  return cont;
}

	array123:
public boolean array123(int[] nums) {
  for(int pos=0;pos<nums.length-2;pos++){
    if(nums[pos]==1 && nums[pos+1]==2 && nums[pos+2]==3){
      return true;
    }
  }
  return false;
}

	stringMatch:
public int stringMatch(String a, String b) {
  int cont=0;
  int menor;
  if(a.length()<=b.length()){
    menor=a.length();
  }else{
    menor=b.length();
  }
  for(int pos=0;pos<=menor-2;pos++){
    if((a.substring(pos,pos+2).equals(b.substring(pos,pos+2))) == true){
      cont++;
    }
  }
  return cont;
}

	stringX:
public String stringX(String str) {
  String nuevaCadena="";
  for(int pos=0;pos<str.length();pos++){
    if(str.substring(pos,pos+1).equals("x")){
      if(pos==0 ){
        nuevaCadena=nuevaCadena + str.substring(pos,pos+1);
      }else if(pos+1==str.length()){
        nuevaCadena=nuevaCadena + str.substring(pos);
      }else{
        nuevaCadena=nuevaCadena;
      }
    }else{
      nuevaCadena=nuevaCadena + str.substring(pos,pos+1);
    }
  }
  return nuevaCadena;
}

	altPairs:
public String altPairs(String str) {
  String nuevaCadena="";
  boolean cambiar=true;
  int contador=0;
  while(str.length()>contador){
      nuevaCadena = nuevaCadena + str.charAt(contador);
    if(cambiar==true){
      contador= contador + 1;
      cambiar = false;  
    }else{
      contador = contador +3;
      cambiar = true;
    }
  }
  return nuevaCadena;
}

//codigos
	
//	missingchar:
public String missingChar(String str, int n) {
  return str.substring(0,n) + str.substring(n+1,str.length());
}

//	frontBack:
public String frontBack(String str) {
  if(str.length()>1){
    return str.substring(str.length()-1) + str.substring(1,str.length()-1) + str.substring(0,1);
  }
  return str;
}

	front3:
public String front3(String str) {
  if(str.length()>2){
    return str.substring(0,3) + 
           str.substring(0,3) + 
           str.substring(0,3);
  }
  return str.substring(0,str.length())+
         str.substring(0,str.length())+
         str.substring(0,str.length());
}

	backAround:
public String backAround(String str) {
  return str.substring(str.length()-1)+ str +
         str.substring(str.length()-1);
}
	
	 or35:
public boolean or35(int n) {
  return (n%3==0)||(n%5==0)? true : false;
}

	front22:
public String front22(String str) {
  if(str.length()>2){
    return str.substring(0,2) +
         str.substring(0) + str.substring(0,2);
  }
  return str.substring(0,str.length()) + 
         str.substring(0) + str.substring(0,str.length());
}

	 startHi:
public boolean startHi(String str) {
  if(str.length()>1){
    return (str.substring(0,2).equals("hi"))? true : false;
  }
  return false;
}
