import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dao.*;
import com.thinking.machines.inventory.dl.*;
import java.util.*;
class ItemNameExistsTestCase
{
public static void main(String data[])
{
String name=data[0];
try
{
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
System.out.println(itemDAOInterface.nameExists(name));
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}