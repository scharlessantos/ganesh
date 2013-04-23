/* Ganesh Server, developed in 2013*/
package ganesh.db.utils;

import ganesh.Ganesh;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Random;

import org.scharlessantos.hermes.Hermes;

public class ObjectId {

	private long id;

	// Object id é uma meio de calcular ids sem ter que fazer hit no banco	
	// Aqui é calculado:
	// 4 posições para PID: Process ID
	// 7 posições para MID: Machine ID, soma dos valores decimais do MAC Address
	// 4 posições para random: Numero aleatorio

	private static long random = new Random().nextLong();

	private synchronized long getRandom() {
		return (((random++) * 913) >>> 2) % 10000; //Sempre quatro numeros
	}

	public ObjectId() {
		int pid = Ganesh.getInstance().getPid();
		int mac = 832;
		long random = getRandom();

		//Obtendo mac address

		try {

			Enumeration<NetworkInterface> intfs = NetworkInterface.getNetworkInterfaces();
			while (intfs.hasMoreElements()) {
				NetworkInterface intf = intfs.nextElement();

				if (intf.isLoopback())
					continue;

				byte[] realmac = intf.getHardwareAddress();

				if (realmac == null)
					continue;

				mac = 0;

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < realmac.length; i++) {
					if (i == 3 || i == 5) {
						mac += Integer.parseInt(sb.toString(), 16);
						sb = new StringBuilder();
					}

					sb.append(String.format("%02X", realmac[i]));
				}

				mac += Integer.parseInt(sb.toString(), 16);

				if (mac >= 10000000)
					mac %= 10000000;

				break;
			}

		} catch (SocketException e) {
			Hermes.error(e);
		}

		id = Long.parseLong(String.format("%04d%07d%04d", pid, mac, random));

	}

	public long get() {
		return id;
	}
}
