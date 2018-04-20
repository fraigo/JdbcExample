package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

public class Sqlite implements Database {

	public static final String PROPERTY_FILENAME = "filename";
	
	/**
	 * Internal SQLite data source
	 */
	SQLiteDataSource dataSource;
	
	@Override
	public boolean connect(Properties props) throws Exception {
		boolean initialize = SQLiteJDBCLoader.initialize();

		dataSource = new SQLiteDataSource();
		dataSource.setUrl(String.format("jdbc:sqlite:%s",props.getProperty(PROPERTY_FILENAME)));
		return initialize;

	}
	
	@Override
	public PreparedStatement getPreparedStatement(String sql) throws Exception {
		return dataSource.getConnection().prepareStatement(sql);
	}

	@Override
	public ResultSet executeQuery(String sql)  throws Exception {
		PreparedStatement statement= getPreparedStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		return resultSet;
	}
	
	@Override
	public int executeUpdate(String sql)  throws Exception {
		return dataSource.getConnection()
					.createStatement().executeUpdate(sql);
	}
	
	public boolean execute(String sql)  throws Exception {
		return dataSource.getConnection()
				.createStatement().execute(sql);
	}

}
