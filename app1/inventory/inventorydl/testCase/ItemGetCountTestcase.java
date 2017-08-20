import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dao.*;
import com.thinking.machines.inventory.dl.*;
import java.util.*;
class ItemGetCountTestCase
{
public static void main(String data[])
{
try
{
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
System.out.println(itemDAOInterface.getCount());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}