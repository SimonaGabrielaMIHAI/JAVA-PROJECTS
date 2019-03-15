import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
//		String inFile = scanner.nextLine();
//		String outFile = scanner.nextLine();				
		scanner.close();
		String inFile = "out.out";
		String outFile = "cv.out";
		
		try (BufferedReader br = new BufferedReader(new FileReader(inFile))){
			String currentLine;
			currentLine = br.readLine();
			
			//initializarea hartii
			String[] StringSplit = currentLine.split(" ");
			int Rows = Integer.parseInt(StringSplit[0]);
			int Cols = Integer.parseInt(StringSplit[1]);
			Map WarMap = new Map(Rows, Cols);
			
			int i, j;
			
			for(i = 0; i < Rows; i++) {
				currentLine = br.readLine();
				for(j = 0; j < Cols; j++) {
					WarMap.setType(i, j, currentLine.charAt(j));					
				}
			}
			
			currentLine = br.readLine();
			int heroes = Integer.parseInt(currentLine);
			Hero[] heroesArray = new Hero[heroes];
			char type;
			int x, y;
			for (i = 0; i < heroes; i++) {
				currentLine = br.readLine();
				StringSplit = currentLine.split(" ");
				type = StringSplit[0].charAt(0);
				x = Integer.parseInt(StringSplit[1]);
				y = Integer.parseInt(StringSplit[2]);
				
				if(type == 'P') {
					heroesArray[i] = new Pyromancer();
				}
				if(type == 'K') {
					heroesArray[i] = new Knight();
				}
				if(type == 'W') {
					heroesArray[i] = new Wizard();
				}
				if(type == 'R') {
					heroesArray[i] = new Rogue();
				}
				heroesArray[i].placeHero(x, y);
			}
			
			currentLine = br.readLine();
			int rounds = Integer.parseInt(currentLine);
			char[][] commands = new char[rounds][heroes];
			for(i = 0; i < rounds; i++) {
				currentLine = br.readLine();
				for(j = 0; j < heroes; j++) {
					commands[i][j] = currentLine.charAt(j);					
				}
			}
			
			int q,w;
			Fight actions = new Fight();
			for(i = 0; i < rounds; i++) {
				System.out.println("Runda" + i + " " + heroes);
				for(j = 0; j < heroes; j++) {
					if(heroesArray[j].isStuned == false) {
						heroesArray[j].move(commands[i][j]);
					}
					actions.applyOvertime(heroesArray[j]);
				}
				for(q = 0; q < heroes; q++) {
					for(w = q + 1; w < heroes; w++) {
						x = heroesArray[q].coordX;
						y = heroesArray[q].coordY;
						if(heroesArray[w].coordX == x 
								&& heroesArray[w].coordY == y) {
							actions.Attack(heroesArray[q], heroesArray[w], WarMap.getType(x, y));
						}
					}
				}
				
			}
			FileWriter a = new FileWriter(outFile);
			BufferedWriter fw = new BufferedWriter(a);
			Hero helper;
			for(q = 0; q < heroes; q++) {
				helper = heroesArray[q];
				helper.applyOvertimeDmg();
				fw.write(helper.type);
				fw.write(" ");
				if(helper.isAlive == true) {
					fw.write(String.valueOf(helper.lvl));
					fw.write(" ");
					fw.write(String.valueOf((int) helper.Xp));
					fw.write(" ");
					fw.write(String.valueOf((int) helper.Hp));
					fw.write(" ");
					fw.write(String.valueOf(helper.coordX));
					fw.write(" ");
					fw.write(String.valueOf(helper.coordY));
					fw.write(System.getProperty("line.separator"));
				}
				else {
					fw.write("dead");
					continue;
				}
			}
			a.flush();
			fw.flush();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
