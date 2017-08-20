package com.thinking.machines.inventory.dl.interfaces;
import com.thinking.machines.inventory.dl.exceptions.*;
import java.util.*;
public interface ItemDAOInterface
{
public void add(ItemDTOInterface itemDTOInterface) throws DAOException;
public void update(ItemDTOInterface itemDTOInterface) throws DAOException;
public void delete(int code) throws DAOException;
public ItemDTOInterface get(int code) throws DAOException;
public List<ItemDTOInterface> getAll() throws DAOException;
public int getCount() throws DAOException;
public boolean codeExists(int code) throws DAOException;
public boolean nameExists(String name) throws DAOException;
}