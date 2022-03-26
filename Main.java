class Main {
int sudoku[][] = new int [9][9];

  public boolean validarPosicion(int num, int x, int y){
    for(int i=0; i<9; i++){
      if(sudoku[y][i]==num){//mira toda fila
        return false; 
      }
      if(sudoku[i][x]==num){//mira toda columna
        return false;
      }
    }
    int fi = y/3;//lo parte en cuadrados
    fi*=3;
    int ci = x/3;
    ci*=3;
    for(int i=fi; i<fi+3; i++){ //revisa cuadrado
      for(int j=ci; j<ci+3; j++){
        if(sudoku[i][j]==num){
          return false; 
        }
      }
    }
    return true;
  }
  public boolean ubicar(int num, int x, int y){
    if(!validarPosicion(num, x, y)){//No se puede ubicar (4,0,0)
      return false;
    }else{
      sudoku[y][x] = num;
      boolean encontrado = false;
      while(!encontrado){ //si lo encontro
        x++;
        if(x>8){//reinicie fila y cambie columna
          x=0;
          y++;
        }
        if(y>8)
           return true; //recorre cuadrado y retorna
        if(sudoku[y][x]==0){//[4][0]
          encontrado = true; //luego de llenar salir
        }
      }
      for(int i=1; i<11; i++){
        if(ubicar(i,x,y)){
          return true;
        }
      }
    }
    return false;
  }
  public void mostrarSudoku(){
    for(int i=0; i<9; i++){
      for(int j=0; j<9; j++){
        if(sudoku[i][j]==10){
          sudoku[i][j]=0;
        }
        System.out.print(sudoku[i][j]+"\t");
      }
      System.out.println();
    }
  }
  
  public Main(){
    sudoku[0][0] = 3;
    sudoku[2][2] = 1;
    sudoku[3][3] = 4;
    ubicar(4,0,0); 
    mostrarSudoku();
  }
  public static void main(String[] args) {
    new Main();
  }
}