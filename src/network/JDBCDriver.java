package network;

import java.sql.ResultSet;

// NOTE: This outlines Java DataBase Connection Driver 
// requirements that cater to our specific needs. 
public abstract class JDBCDriver 
{	
	// Connects to the database, returns a bool if it succeeded.
	public abstract boolean Connect();
	
	// Disconnects the driver. Returns if the driver is disconnected now, regardless of connection status.
	public abstract boolean Disconnect();
	
	// Executes a SQL command with the database. Returns if it was executed successfully, or in the 
	// case of the returning statement, returns the ResultSet.
	public abstract boolean ExecuteStatement(String statement);
	public abstract ResultSet ExecuteReturningStatement(String statement);
}
