package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Database interface
 * @author franciscoigor@gmail.com
 */
public interface Database {
	
	/**
	 * Connects to a database
	 * @return
	 * @throws Exception
	 */
	public boolean connect(Properties props) throws Exception;
	
	/**
	 * Get a PreparedStatement to set values before executing the query
	 * @param sql SQL query
	 * @return PreparedStatement to set parameters and query
	 * @throws Exception
	 */
	public PreparedStatement getPreparedStatement(String sql) throws Exception;
	
	/**
	 * Executes a query to make data selections (SELECT) 
	 * @param sql SQL query
	 * @return ResultSet to iterate 
	 * @throws Exception
	 */
	public ResultSet executeQuery(String sql) throws Exception;

	/**
	 * Executes a query to make DDL (CREATE, DROP) and data modifications (INSERT, UPDATE, DELETE) to a database
	 * @param sql
	 * @return Number of rows affected
	 * @throws Exception
	 */
	public int executeUpdate(String sql)  throws Exception;
	
	/**
	 * Execute a command or a batch of commands
	 * @param sql Sql query
	 * @return True if no errors are thrown
	 * @throws Exception
	 */
	public boolean execute(String sql)  throws Exception;

}
