

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.amd.bean.Salarie;

public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket(InetAddress.getLocalHost(),1099);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject("Kevin");
			Salarie kevin = (Salarie) ois.readObject();
			kevin.setName("Kevin");
			kevin.raiseSalary(500);
			System.out.println("fin");
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
