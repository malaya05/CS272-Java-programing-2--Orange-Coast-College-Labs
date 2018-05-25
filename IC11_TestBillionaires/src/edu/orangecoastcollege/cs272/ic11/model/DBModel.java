package edu.orangecoastcollege.cs272.ic11.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <code>DBModel</code> represents the database model for a table containing one primary key
 * and one or more fields.  It provides mechanisms by which new records can be created and
 * existing ones can be updated or deleted.  <code>DBModel</code> also provides functionality
 * to query the database table for a single record, all records or the total count of records.
 *
 * @author
 * @version
 */

// AutoClassable = interface that guarantees resource will be closed
// Ensure that both connection and statment are closed

public class DBModel implements AutoCloseable {

	private String mDBName;
	private String mTableName;
	private String[] mFieldNames;
	private String[] mFieldTypes;
	private Connection mConnection;
	private Statement mStmt;

	/**
	 * Instantiates a new <code>DBModel</code> given the required parameters, such as the database name,
	 * table name, field names and field types.
	 *
	 * @param dbName The database name, e.g. cs272.db
	 * @param tableName The table name, e.g. billionaires
	 * @param fieldNames The field names, e.g. "_id", "name", "age", "gender", "worth", "citizenship", "sector", "political"
	 * @param fieldTypes The field types, e.g. "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT", "REAL", "TEXT", "TEXT", "INTEGER"
	 * @throws SQLException If the field names are not the same length as the field types, or the names/types are empty,
	 * or there is an error connecting to the database.
	 */
	public DBModel(String dbName, String tableName, String[] fieldNames, String[] fieldTypes)
			throws SQLException {
		super();
		mDBName = dbName;
		mTableName = tableName;
		mFieldNames = fieldNames;
		mFieldTypes = fieldTypes;
		if (mFieldNames == null || mFieldTypes == null || mFieldNames.length == 0 || mFieldNames.length != mFieldTypes.length)
			throw new SQLException("Database field names and types must exist and have the same number of elements.");
		mConnection = connectToDB();
		mStmt = mConnection.createStatement();
		createTable();
	}

	/**
	 * Creates the database table, only if it does not already exist.
	 *
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	private void createTable() throws SQLException
	{
		// TODO: Implement this method
	    StringBuilder createSql = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
	    createSql.append(mTableName).append(" ( ");
	    //createSql.append(" (_id INTEGER PRIMARY KEY");
	   for(int i = 0; i < mFieldNames.length; ++i)
	   {
	       createSql.append(mFieldNames[i]).append(" ").append(mFieldTypes[i])
	       .append(i == mFieldNames.length -1 ? " )" : ", " );
	   }
            mStmt.executeUpdate(createSql.toString());
	}

	/**
	 * Gets all records from the database.
	 *
	 * @return A <code>ResultSet</code> containing all records from the database table.
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public ResultSet getAllRecords() throws SQLException {

	    // it is rows from Database
	    /*
	     * ResultSet  rs= mStmt.executeQuery("SELECT * FROM " + mTableName);
        return rs;
        OR
        */
	   return mStmt.executeQuery("SELECT * FROM " + mTableName);
	}

	/**
	 * Gets a single record from the database matching a specific primary key.
	 *
	 * @param key The primary key value for the record to return.
	 * @return A <code>ResultSet</code> containing a single record matching the key.
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public ResultSet getRecord(String key) throws SQLException
	{
		// TODO: Implement this method
	    StringBuilder query = new StringBuilder("SELECT * FROM ").append(mTableName)
	            .append(" WHERE ").append(mFieldNames[0]).append("=").append(key);
	   return mStmt.executeQuery(query.toString());
	 }

	/**
	 * Gets the count of all records in the database.
	 *
	 * @return The count of all records in the database.
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public int getRecordCount() throws SQLException
	{
	    int count = 0;
	   try(ResultSet rs =  getAllRecords())
	   {
	       while(rs.next())
	           count++;
	   }
		return count;
	}

	/**
	 * Creates (inserts) a new record into the database with the fields and values provided.
	 * Usage: Do not provide a primary key in the fields or values, as the database will assign one automatically.
	 *
	 * @param fields The field names, e.g. "name", "age", "gender", "worth", "citizenship", "sector", "political"
	 * @param values The values, e.g. "Mike Paul", "40", "male", "2.2", "United States", "technology", "0"
	 * @return The newly generated primary key if the record was created successfully,
	 * or -1 if the fields length does not match the values length (or if fields/values are empty).
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public int createRecord(String[] fields, String[] values) throws SQLException
	{
	    // check for extreme cases
	    if(fields == null || values == null || fields.length != values.length || fields.length == 0)
            return -1;

	    StringBuilder inserSQL = new StringBuilder("INSERT INTO ");
	    inserSQL.append(mTableName).append(" (");
	    for(int i = 0; i < fields.length; i++)
	    {
	        inserSQL.append(fields[i]);
	        inserSQL.append( i == fields.length-1 ? ") VALUES (" :", ");
	    }

	    for(int i = 0; i < values.length; i++)
        {
            inserSQL.append(convertToSQLText(fields[i], values[i]))
            .append( i == values.length - 1 ? ") " :",");
        }
	    mStmt.executeUpdate(inserSQL.toString());

	    return mStmt.getGeneratedKeys().getInt(1);
	}

	/**
	 * Updates a single record from the database matching the given primary key value.
	 * Usage: Do not provide primary key in the fields or values, only provide it as the key parameter.
	 *
	 * @param key The primary key value to update.
	 * @param fields The field names, e.g. "name", "age", "gender", "worth", "citizenship", "sector", "political"
	 * @param values The values, e.g. "Mike Paul", "40", "male", "2.2", "United States", "technology", "0"
	 * @return True if the record was updated successfully, false if the fields length does not match the values length (or if fields/values are empty).
	 * @throws SQLException
	 */
	public boolean updateRecord(String key, String[] fields, String[] values) throws SQLException
	{
	    // Check to see if the fields and values have same length
	    if(fields == null || values == null || key == null || fields.length != values.length || fields.length == 0)
	        return false;

	    /*
	     * "UPDATE billionairesSET name='Testy User', age=33, gender='male',
	     *  worth=2.5, citizenship='United States',
	     *   sector='finance', political=1 WHERE _id=1”
	     */
	    StringBuilder updateSQL= new StringBuilder("UPDATE ");
	    updateSQL.append(mTableName).append(" SET ");

	    for(int i = 0; i < fields.length; i++)
        {
	        updateSQL.append(fields[i]).append("=").append(convertToSQLText(fields[i], values[i]));
	        updateSQL.append( i == fields.length-1 ? " WHERE " :", ");
        }
	    updateSQL.append(mFieldNames[0]).append("=").append(key);
	    mStmt.executeUpdate(updateSQL.toString());

		return true;
	}

	/**
	 * Deletes all records from the database.
	 *
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public void deleteAllRecords() throws SQLException
	{
		mStmt.executeUpdate("DELETE  FROM " + mTableName);
	}

	/**
	 * Deletes a single record from the database matching the given primary key value.
	 *
	 * @param key The primary key value to delete.
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	public void deleteRecord(String key) throws SQLException
	{
	    StringBuilder deleteSQL = new StringBuilder("DELETE FROM ");
	    deleteSQL.append(mTableName).append(" WHERE ")
	             .append(mFieldNames[0]).append("=").append(key);

	    mStmt.executeUpdate(deleteSQL.toString());
	}

	/**
	 * Converts a field value into SQL text by surrounding value with single quotes (e.g. technology becomes 'technology')
	 * This only happens when the field provided has the SQL data type TEXT.
	 *
	 * @param field The field name (e.g. sector)
	 * @param value The value (e.g. technology)
	 * @return The value surrounded with single quotes if it's field type is TEXT, otherwise returns the original value.
	 */
	private String convertToSQLText(String field, String value) {
		// TODO: Implement this method
	   for(int i = 0; i < mFieldNames.length; i++)
	   {
	       if(field.equals(mFieldNames[i]))
	       {
	           if(mFieldTypes[i].equals("TEXT"))
	               return "'" + value + "'";
	           else
	               return value;
	       }
	   }
		return null;
	}

	/**
	 * Establishes a connection to the database.
	 *
	 * @return The connection to the database.
	 * @throws SQLException If a database access error occurs, this method is called on a closed Statement,
	 * or the given SQL statement produces anything other than a single ResultSet object.
	 */
	private Connection connectToDB() throws SQLException {
		// Load SQLite database classes
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Establish a connection to the database and return that connection
		return DriverManager.getConnection("jdbc:sqlite:" + mDBName);
	}

    @Override
    public void close() throws Exception
    {
        // Close the stmt first
        mStmt.close();
        // Close the connection next ( statment depends on connection)
        mConnection.close();
    }
}
