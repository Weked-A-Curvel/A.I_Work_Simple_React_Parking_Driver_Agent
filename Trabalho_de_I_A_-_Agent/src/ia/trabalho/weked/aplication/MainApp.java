package ia.trabalho.weked.aplication;

import ia.trabalho.weked.implement.DriverAgent;
import ia.trabalho.weked.implement.ParkingEnvironment;

public class MainApp {
	public static void main (String[] args) {
		ParkingEnvironment parking;
		DriverAgent agent;
		
		agent = new DriverAgent();
		parking = new ParkingEnvironment(agent);

		parking.sendViewToAgente();
		//parking.createView();
		/*
		for(int i=0; i < 3; i++) {//--
			for(int j=0; j < 3; j++) {
				
			}
		}
		*/
	}
}

/*
int[][]environment;
int line =3;
int colunm =3;

environment = new int[line][colunm];
for(int i=0; i < line; i++) {//--
	for(int j=0; j < colunm; j++) {
		environment[line][colunm] = 0;
	}
}
*/