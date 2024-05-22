package app;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import entities.Album;

public class Client {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			try (Socket socket = new Socket("192.168.1.16", 8888)) {

				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

				while (true) {
					System.out.println("Vui lòng nhập choice number: 1 or 2 or 3");
					int choice = sc.nextInt();
					out.writeInt(choice);
					out.flush();
					
					switch (choice) {
						case 1:
							System.out.println("Vui lòng nhập name genre cần tìm kiếm:");
							sc.nextLine();
							String title = sc.nextLine();
							out.writeUTF(title);
							out.flush();
	
							List<Album> listAlbumByGenre = (List<Album>) in.readObject();
							listAlbumByGenre.forEach(System.out::println);
							break;
						case 2:
							Map<String, Long> numberOfAlbumByGenre = (Map<String, Long>) in.readObject();
							System.out.println("\n\n");
							for (Map.Entry<String, Long> entry : numberOfAlbumByGenre.entrySet()) {
								String key = entry.getKey();
								Long val = entry.getValue();
								System.out.println(key + ": " + val);
							}
							System.out.println("\n\n");
						default:
							break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
