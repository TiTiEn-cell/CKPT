package app;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.EntityManagerFactoryUtil;
import entities.Album;
import jakarta.persistence.EntityManager;
import services.AlbumService;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket sever = new ServerSocket(8888)) {
			System.out.println("Server is running in port 8888..");
			ExecutorService executorService = Executors.newCachedThreadPool();

			while (true) {// Liên tục lắng nge
				Socket clientSocket = sever.accept();
				InetAddress inetAddress = clientSocket.getInetAddress();
				InetAddress localAddress = clientSocket.getLocalAddress();
				System.out.println("-> Client " + inetAddress + "_" + localAddress + " connected.");
				executorService.execute(new ClientHandler(clientSocket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class ClientHandler implements Runnable {
	private Socket clientSocket;
	private EntityManagerFactoryUtil managerFactoryUtil;
	private EntityManager entityManager;
	private AlbumService albumService;

	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		this.managerFactoryUtil = new EntityManagerFactoryUtil();
		this.entityManager = this.managerFactoryUtil.getEnManager();
		this.albumService = new AlbumService(this.entityManager);
	}

	@Override
	public void run() {
		try {
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

			int choice = 0;

			while (true) {
				choice = in.readInt();
				
				switch (choice) {
					case 1:
						String name = in.readUTF();// Chờ title gởi qua
						System.out.println("Client title vua nhap la=" + name);
	
						List<Album> listAlbumByGenre = albumService.listAlbumByGenre(name);
						System.out.println("listAlbumByGenre=" + listAlbumByGenre);
						out.writeObject(listAlbumByGenre);
						out.flush();
						break;
					case 2:
						Map<String, Long> numberOfAlbumByGenre = albumService.getNumberOfAlbumByGenre();
						out.writeObject(numberOfAlbumByGenre);
						out.flush();
						break;
					case 3:
						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.managerFactoryUtil.closeEnManager();
			this.managerFactoryUtil.closeEnManagerFactory();
		}
	}

}
