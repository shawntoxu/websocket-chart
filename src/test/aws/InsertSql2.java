package test.aws;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class InsertSql2 {
	public static int ipStr2int(String ipstr) throws UnknownHostException
	{
	    final byte[] bytes = InetAddress.getByName(ipstr).getAddress();
	    int addr = bytes[3] & 0xFF;
	    addr |= ((bytes[2] << 8) & 0xFF00);
	    addr |= ((bytes[1] << 16) & 0xFF0000);
	    addr |= ((bytes[0] << 24) & 0xFF000000);
	    return addr;
	}

	public static void main(String[] args) throws UnknownHostException {
		
//		System.out.println(ipStr2int("10.1.11.65"));
		String[] ss = new String[]{"10.1.11.65","10.1.11.66","10.1.11.67","10.1.11.68","10.1.11.69"};
		
//		String sql = "INSERT INTO `cmdb_alert`.`tb_monitor_logconfig` (`service`, `app`, `hostname`, `hostip`, `region`, `logpath`, `status`)  VALUES "
//				+ "('storm_topology_error_10_1_11_@', 'logkey', 'AMZ-IAD-STORM-11-@', '167840577', '1', '/logdata/storm/com-yeahmobi-nativelog-DspTopology/error.log', '1')";
//		
//		for (String string : ss) {
//			String tt = sql.replaceAll("@", string.split("\\.")[3]).replace("167840577", ipStr2int(string)+"");
//			System.err.println(tt);
//			System.err.println(tt.replace("error", "info"));
//		}
//		
		Map m = new LinkedHashMap<>();
			m.put("storm_topology_error_10_1_11_65","915");
			m.put("storm_topology_info_10_1_11_65","916");
			m.put("storm_topology_error_10_1_11_66","917");
			m.put("storm_topology_info_10_1_11_66","918");
			m.put("storm_topology_error_10_1_11_67","919");
			m.put("storm_topology_info_10_1_11_67","920");
			
			m.put("storm_topology_error_10_1_11_68","921");
			m.put("storm_topology_info_10_1_11_68","922");
			
			m.put("storm_topology_error_10_1_11_69","923");
			m.put("storm_topology_info_10_1_11_69","924");
			
		 Set<String> keyset = m.keySet();
		 
		
//		String sql2 ="INSERT INTO `cmdb_alert`.`tb_monitor_actions` "
//				+ "(`name`, `app`, `status`, `fromtable`, `hostnamesql`, `cols`, `ifdetail`, `triggersql`, `groupby`, `clock`, `method`, `alertRelation`, `warning`, `critical`, `desc`, `region`, `errorkeys`, `nokeys`, `contacts`, `error`) VALUES  "
//				+ "('@', '@', '1', 'log_keys', '', 'key', '1', "
//				+ "'select logid,log_sample,sum(num) as num1 from log.log_keys where logid in (913)', 'group by logid', '60', '0', '>=', '1', '1', '服务名 MySQL_table_update',"
//				+ "'1', 'exception', NULL, '吕娇,王攀明,王和丙,杨旭,王秋实', '1');";
//			
//		for (String string : keyset) {
//			
//			System.out.println(sql2.replaceAll("@", string).replace("913", m.get(string).toString()));
//		}
		
		 
			String td_agent_config = "<source>\r\n"
				     + "  type tail \r\n"
				     + "  path /logdata/storm/com-yeahmobi-nativelog-DspTopology/lll.log\r\n"
				     + "  pos_file /tmp/logkey.log.pos\r\n"
				     + "  tag logkey.@.76.899\r\n"
				     + "  format none\r\n"
				     + "</source>" ;
		int i = 0 ;
		 for (String string : keyset) {
			 String ttt = td_agent_config.replace("76", string.split("_")[6]).replaceAll("@", string).replace("899", m.get(string).toString()).replace("lll", string.split("_")[2]).toString();
			 System.out.println(ttt);
//			 System.out.println(ttt.replaceAll("error", "info"));
//			 System.out.println("-------------------");
			 i++ ; 
			 if(i%2==0) System.out.println("----------------------");
			 System.out.println("");
			 
		}
		
	}

}
