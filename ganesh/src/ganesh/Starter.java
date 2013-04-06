package ganesh;

import ganesh.common.exceptions.GException;
import ganesh.common.i18n.GaneshI18n;
import ganesh.embed.database.DBServer;
import ganesh.embed.http.HttpServer;
import ganesh.log.FileLogger;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Set;

import org.scharlessantos.atlas.Language;
import org.scharlessantos.hermes.HConfiguration;
import org.scharlessantos.hermes.Hermes;
import org.scharlessantos.hermes.logger.GenericHFilter;
import org.scharlessantos.hermes.writer.HLevel;

import sun.jvmstat.monitor.HostIdentifier;
import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

/**
 * Class who starts application
 */
public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HConfiguration.getInstance().setBaseFormat("[S:%-5s] %s.%s(%s:%d)@Thread %d:");
		Hermes.removeDefaultFileLogger();
		Hermes.addLogger(new FileLogger(), new GenericHFilter(HLevel.INFO));

		try {

			Hermes.warn("\nGANESH NOTICE:\nCopyright (C) 2013 Rafael Antonio Farinha (rafarinha123@gmail.com)\n\n" +
				"This program is free software: you can redistribute it and/or modify\n" +
				"it under the terms of the GNU General Public License as published by\n" +
				"the Free Software Foundation, either version 3 of the License, or\n" +
				"(at your option) any later version.\n\nThis program is distributed in the hope that it will be useful,\n" +
				"but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
				"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the\n" +
				"GNU General Public License for more details.\n" +
				"You should have received a copy of the GNU General Public License\n" +
				"along with this program. If not, see <http://www.gnu.org/licenses/>.\n");

			Hermes.info("============================ Starting Ganesh Server");

			try {
				RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
				final int runtimePid = Integer.parseInt(rt.getName().substring(0, rt.getName().indexOf("@")));

				if (!getMonitoredVMs(runtimePid)) {
					Hermes.fatal("Já existe uma outra instância do Ganesh em execução");
					System.exit(11);
				}
			} catch (Throwable t) {
				Hermes.fatal(t);
				System.exit(12);
			}

			GaneshI18n.loadTranslations(Language.PT_BR, Starter.class.getResourceAsStream("i18n/translations/messages.pt_BR.trd"));
			GaneshI18n.loadTranslations(Language.EN_US, Starter.class.getResourceAsStream("i18n/translations/messages.en_US.trd"));

			try {
				DBServer.getInstance().initDB();
			} catch (GException e) {
				Hermes.fatal("Nao foi possivel iniciar o Banco de Dados");
				Hermes.fatal(e);

				System.exit(13);
			}

			Ganesh.getInstance().start();

			try {
				HttpServer.getInstance().startServer();
			} catch (GException e) {
				Hermes.fatal(e);

				System.exit(32);
			}

			System.exit(0);

		} catch (Throwable e) {
			Hermes.fatal(e);
			System.exit(33);
		}

	}

	@SuppressWarnings("rawtypes")
	private static boolean getMonitoredVMs(int processPid) {
		MonitoredHost host;
		Set vms;
		try {
			host = MonitoredHost.getMonitoredHost(new HostIdentifier((String)null));
			vms = host.activeVms();
		} catch (java.net.URISyntaxException sx) {
			throw new InternalError(sx.getMessage());
		} catch (MonitorException mx) {
			throw new InternalError(mx.getMessage());
		}
		MonitoredVm mvm = null;
		String processName = null;
		try {
			mvm = host.getMonitoredVm(new VmIdentifier(String.valueOf(processPid)));
			processName = MonitoredVmUtil.commandLine(mvm);
			processName = processName.substring(processName.lastIndexOf("\\") + 1, processName.length());
			mvm.detach();
		} catch (Exception ex) {

		}

		for (Object vmid: vms) {
			if (vmid instanceof Integer) {
				int pid = ((Integer)vmid).intValue();
				String name = vmid.toString(); // default to pid if name not available  
				try {
					mvm = host.getMonitoredVm(new VmIdentifier(name));
					// use the command line as the display name  
					name = MonitoredVmUtil.commandLine(mvm);
					name = name.substring(name.lastIndexOf("\\") + 1, name.length());
					mvm.detach();
					if ((name.equalsIgnoreCase(processName)) && (processPid != pid))
						return false;
				} catch (Exception x) {
					// ignore  
				}
			}
		}

		return true;
	}
}
