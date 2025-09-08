package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;

public interface IEmployeeService {
	public abstract void execute() throws ClassNotFoundException, SQLException, IOException;

}
