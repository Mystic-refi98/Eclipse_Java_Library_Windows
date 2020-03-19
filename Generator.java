package helper;

import java.sql.ResultSet;

public class Generator {
	
	private Connect connect;
	
	public Generator() {
		connect = new Connect();
	}
	
	public String generate(String query, String code){
		String id = "";
		ResultSet rs = connect.executeQuery(query);
		try {
			if(!rs.next()) id = code + "001";
			else{
				rs.last();
				String lastId = rs.getString(1);
				int number = Integer.parseInt(lastId.substring(2, 5));
				number++;
				id = String.format(code + "%03d", number);
			}
		} catch (Exception e) {}
		return id;
	}
}
