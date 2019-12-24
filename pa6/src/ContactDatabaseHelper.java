import java.sql.*;
import java.util.ArrayList;

public class ContactDatabaseHelper
{
    static final String DATABASE_NAME = "databaseShapes.db";
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME;
    static final String TABLE_SHAPES = "databaseShapes";
    static final String ID = "_id";
    static final String OBJ_TYPE = "myShape";
    static final String X1 = "x1";
    static final String Y1 = "y1";
    static final String X2 = "x2";
    static final String Y2 = "y2";
    static final String FILLED = "filled";

    Connection connection;

    public ContactDatabaseHelper()
    {
        getConnection();
        createShapeTable();
    }

    public void getConnection()
    {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createShapeTable()
    {
        String sqlCreate = "CREATE TABLE " + TABLE_SHAPES + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OBJ_TYPE + " TEXT, " +
                X1 + " TEXT, " + Y1 + " TEXT, " + X2 + " TEXT, " + Y2 + " TEXT, " +
                FILLED + " TEXT)";

        System.out.println(sqlCreate);

        if (connection != null && !tableExists())
        {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlCreate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertShape(MyShape shape)
    {
        String fillStatus;
        if (shape.isFilled())
            fillStatus = "y";
        else
            fillStatus = "n";

        String sqlInsert = "INSERT INTO " + TABLE_SHAPES + " VALUES(null, '" +
                shape.getShapeType() + "', '" +
                shape.getX1() + "', '" +
                shape.getY1() + "', '" +
                shape.getX2() + "', '" +
                shape.getY2() + "', '" +
                fillStatus + "')";

        System.out.println(sqlInsert);

        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<MyShape> getAllShapes()
    {
        ArrayList<MyShape> shapeList = new ArrayList<>();

        String sqlSelect = "SELECT * FROM " + TABLE_SHAPES;
        System.out.println(sqlSelect);

        if (connection != null && tableExists())
        {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSelect);

                while (resultSet.next())
                {
                    int id = resultSet.getInt(ID);
                    String shapeType = resultSet.getString(OBJ_TYPE);
                    int x1 = Integer.parseInt(resultSet.getString(X1));
                    int y1 = Integer.parseInt(resultSet.getString(Y1));
                    int x2 = Integer.parseInt(resultSet.getString(X2));
                    int y2 = Integer.parseInt(resultSet.getString(Y2));
                    String filled = resultSet.getString(FILLED);

                    boolean isFilled;
                    if (filled.equals("y"))
                        isFilled = true;
                    else
                        isFilled = false;

                    MyShape newShape = new MyShape(shapeType, x1, y1, x2, y2, isFilled);
                    shapeList.add(newShape);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return shapeList;
    }

    public void clearAllShapes()
    {
        String sqlDelete = "DELETE FROM " + TABLE_SHAPES + "";
        System.out.println(sqlDelete);

        if (connection != null)
        {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection()
    {
        if (connection != null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean tableExists() {
        // http://www.java2s.com/Code/Java/Database-SQL-JDBC/Detectifatableexists.htm
        DatabaseMetaData md = null;
        boolean hasNext = false;
        try {
            md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, TABLE_SHAPES, null);
            hasNext = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasNext;
    }
}
