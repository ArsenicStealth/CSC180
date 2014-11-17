import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Lab4 {
	
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		FileP();
//	}
	
	public static void FileP() throws FileNotFoundException, IOException{
		StringBuilder sb = new StringBuilder();
		File file = new File("C://Lab4.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter  fw = new FileWriter(file.getAbsoluteFile());
		try(BufferedWriter writer = new  BufferedWriter(fw)){
			InMemoryAuctionService IMAS = new InMemoryAuctionService();
			int i = 0;
				for (int j = -1; j < IMAS.count; j++) {
					String item = IMAS.a.get(i).toString();
					writer.write(item);
					writer.write("\n");
					i++;
				}
			}
			
		
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			while(line != null){
				sb.append(line);
				sb.append("\n");
				line = reader.readLine();
			}
		}
		System.out.println(sb.toString());
		
	}
}
