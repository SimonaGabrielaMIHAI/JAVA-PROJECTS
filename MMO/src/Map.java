
public class Map {
	
	public static char[][] Matrix;
	public static int Rows, Cols;
	
	Map(int x, int y){
		Matrix = new char [x][y];
		Rows = x;
		Cols = y;
	}

	public char getType(int x, int y) {
		return Matrix[x][y];
	}

	public void setType(int x, int y, char type) {
		Matrix[x][y] = type;
	}
	
	

}
