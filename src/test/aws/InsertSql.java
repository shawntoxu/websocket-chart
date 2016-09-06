package test.aws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InsertSql {
	
	/**
	 * 监控大盘
	 * 批量生成  tb_monitor_logconfig         insert into sql
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] ss = new String[]{"DspAd2Mysql.log","DspBrowser2Mysql.log","DspCity2Mysql.log","DspDevice2Mysql.log","DspMedia2Mysql.log","DspOsv2Mysql.log","DspUser2Mysql.log",
		"DspAdCampaign2Mysql.log","DspCarrier2Mysql.log","DspCountry2Mysql.log","DspIsp2Mysql.log","DspNetwork2Mysql.log","DspTraffic2Mysql.log","DspVendor2Mysql.log"};
		
		//手动插入生成的sql 
//		tb_monitor_logconfig(ss);
		
//      tb_monitor_actions(ss) ;
		
		Map m = new HashMap<>();
		m.put("MySQL_table_update_DspAd2Mysql_10_1_11_76", "899");
		m.put("MySQL_table_update_DspBrowser2Mysql_10_1_11_76", "901");
		m.put("MySQL_table_update_DspCity2Mysql_10_1_11_76", "902");
		m.put("MySQL_table_update_DspDevice2Mysql_10_1_11_76", "903");
		m.put("MySQL_table_update_DspMedia2Mysql_10_1_11_76", "904");
		m.put("MySQL_table_update_DspOsv2Mysql_10_1_11_76", "905");
		m.put("MySQL_table_update_DspUser2Mysql_10_1_11_76", "906");
		m.put("MySQL_table_update_DspAdCampaign2Mysql_10_1_11_76", "907");
		m.put("MySQL_table_update_DspCarrier2Mysql_10_1_11_76", "908");
		m.put("MySQL_table_update_DspCountry2Mysql_10_1_11_76", "909");
		m.put("MySQL_table_update_DspIsp2Mysql_10_1_11_76", "910");
		m.put("MySQL_table_update_DspNetwork2Mysql_10_1_11_76", "911");
		m.put("MySQL_table_update_DspTraffic2Mysql_10_1_11_76", "912");
		m.put("MySQL_table_update_DspVendor2Mysql_10_1_11_76", "913");
		
		String td_agent_config = "<source>\r\n"
								     + "  type tail \r\n"
								     + "  path /dianyi/app/hbase-dumper/dsp/*.log\r\n"
								     + "  pos_file /tmp/dsp.log.pos\r\n"
								     + "  tag logkey.MySQL_table_update_@_10_1_11_76.76.899\r\n"
								     + "  format none\r\n"
								     + "</source>" ;
		
//		List<String> ll = new ArrayList<String>();
		Set<String> keyset = m.keySet();
		String temp = "" ;
		String temp2 = "" ;
		for (String string : ss) {
			temp = td_agent_config.replace("@", string.split("\\.")[0]).replaceAll("\\*.log", string);
			
				for (String s : keyset) {
					if(temp.indexOf(s)!=-1){
						 temp2 = temp.replace("899", m.get(s).toString());
					}
				}
				System.out.println(temp2);
				System.out.println("");
		}
		

		
	}
	
	
	
public static void tb_monitor_logconfig(String[] ss){
		
		String sql = "INSERT INTO `cmdb_alert`.`tb_monitor_logconfig` "
				+ "(`service`, `app`, `hostname`, `hostip`, `region`, `logpath`, `status`) "
				+ " VALUES "
				+ "('MySQL_table_update_@_10_1_11_76', 'logkey', 'ip-10-1-11-76.ec2.internal', '167840588', '1', '/dianyi/app/hbase-dumper/dsp/*.log', '1')";
		
		for (String string : ss) {
//			System.out.println(string);
			String tempsql  = sql.replaceAll("@",string.split("\\.")[0]).replaceAll("\\*.log", string);
			System.err.println(tempsql);
		}
		System.err.println("-----------------------------------------------\r\n");
		
	}
	
	public static void tb_monitor_actions(String[] ss){
		//生成插入tb_monitor_actions 的sql
		String tabsql = "INSERT INTO `cmdb_alert`.`tb_monitor_actions` "
				+ "(`name`, `app`, `status`, `fromtable`, `hostnamesql`, `cols`, `ifdetail`, `triggersql`, `groupby`, `clock`, `method`, `alertRelation`, `warning`, `critical`, `desc`, `region`, `errorkeys`, `nokeys`, `contacts`, `error`)"
				+ " VALUES  ('MySQL_table_update_@_10_1_11_76', 'MySQL_table_update_@_10_1_11_76', '1', 'log_keys', '', 'key', '1', 'select logid,log_sample,sum(num) as num1 from log.log_keys where logid in (899)', 'group by logid', '60', '0', '>=', '1', '1', '服务名 MySQL_table_update \r\n描述：监控/dianyi/app/hbase-dumper/dsp/*.log 一共14个log文件，监控关键字exception\r\n报警阀值：出现一次就短信报警\r\n报警级别：严重\r\n报警收件人：\r\n王和丙 18817337158 bing.wang@yeahmobi.com\r\n王攀明 18256012383 andy.wang@yeahmobi.com\r\n吕娇 18217745078 sibyl.lv@yeahmobi.com\r\n杨旭  18521701985 ulyx.yang@yeahmobi.com\r\n王秋实 qiushi.wang@yeahmobi.com\r\n服务器列表：\r\n10.1.11.76\r\n', '1', 'exception', NULL, '吕娇,王攀明,王和丙,杨旭,王秋实', '1')";
		
		//查询出id,service 
		//select logid,service from tb_monitor_logconfig where service like '%MySQL_table_update_%'
		// 存放入map 

		Map m = new HashMap<>();
			//m.put("MySQL_table_update_DspAd2Mysql_10_1_11_76", "899");
			m.put("MySQL_table_update_DspBrowser2Mysql_10_1_11_76", "901");
			m.put("MySQL_table_update_DspCity2Mysql_10_1_11_76", "902");
			m.put("MySQL_table_update_DspDevice2Mysql_10_1_11_76", "903");
			m.put("MySQL_table_update_DspMedia2Mysql_10_1_11_76", "904");
			m.put("MySQL_table_update_DspOsv2Mysql_10_1_11_76", "905");
			m.put("MySQL_table_update_DspUser2Mysql_10_1_11_76", "906");
			m.put("MySQL_table_update_DspAdCampaign2Mysql_10_1_11_76", "907");
			m.put("MySQL_table_update_DspCarrier2Mysql_10_1_11_76", "908");
			m.put("MySQL_table_update_DspCountry2Mysql_10_1_11_76", "909");
			m.put("MySQL_table_update_DspIsp2Mysql_10_1_11_76", "910");
			m.put("MySQL_table_update_DspNetwork2Mysql_10_1_11_76", "911");
			m.put("MySQL_table_update_DspTraffic2Mysql_10_1_11_76", "912");
			m.put("MySQL_table_update_DspVendor2Mysql_10_1_11_76", "913");
			
			
	    Set<String> keyset = m.keySet();
			
		for (String string : ss) {
			String tempsql2  = tabsql.replaceAll("@",string.split("\\.")[0]);
			String tempsql3 ="" ;
			for (String s : keyset) {
				if(tempsql2.indexOf(s)!=-1){
					 tempsql3 = tempsql2.replace("899", m.get(s).toString());
				}
			}
			System.err.println(tempsql3+";");
			System.err.println("");
		}
		
		
		//select name from tb_monitor_actions where name like '%MySQL_table_update_%'
	}
	
	
	
}
