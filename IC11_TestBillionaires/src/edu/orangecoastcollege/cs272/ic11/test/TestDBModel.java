package edu.orangecoastcollege.cs272.ic11.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.orangecoastcollege.cs272.ic11.model.DBModel;

public class TestDBModel
{
    private static final String DB_NAME = "cs272_test.db";
    private static final String TABLE_NAME = "billionaires";
    private static final String[] FIELD_NAMES = { "_id", "name", "age", "gender", "worth", "citizenship", "sector", "political" };
    private static final String[] FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "INTEGER", "TEXT", "REAL", "TEXT", "TEXT", "INTEGER" };
    private static final String DATA_FILE = "billionaires.csv";

    //create to more array to use in setUp
    String fields[];
    String values[];

    private static DBModel mDB;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        // make a connection to database
        mDB = new DBModel(DB_NAME, TABLE_NAME, FIELD_NAMES, FIELD_TYPES);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        mDB.close();
    }

    @Before
    public void setUp() throws Exception
    {
        //make the fields[]
        fields = new String[]{"name", "age", "gender", "worth", "citizenship", "sector", "political" };
        values = new String[]{"Java2", "24", "Male", "5.0", "America", "Oil", "5" };

        // you could do it here
        mDB.deleteAllRecords();
    }

    @After
    public void tearDown() throws Exception
    {
        // clear all the tables
        mDB.deleteAllRecords();
    }

    @Test
    public void testCreateRecord()
    {
       // fail("Not yet implemented");
       //try to creaet a record
        try
        {
         int key = mDB.createRecord(fields, values);
            // After you cereat a record the following should be true
            // 1) Key = 1
            // 2) Record Count = 1

            // All testes begin with assert..
            assertEquals("Testing Key is 1", 1, key);
            assertEquals("Tesing record count", 1, mDB.getRecordCount());

            key = mDB.createRecord(fields, values);
            assertEquals("Testing Key is 1", 2, key);
            assertEquals("Tesing record count", 2, mDB.getRecordCount());

        }
        catch (SQLException e)
        {
            fail("Exception creating record");
        }
    }

}
