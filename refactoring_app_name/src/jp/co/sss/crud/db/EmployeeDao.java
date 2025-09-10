package jp.co.sss.crud.db;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDao implements IEmployeeDao {

	@Override
	/**
	 * 全ての社員情報を検索
	 * @throws ClassNotFoundException 
	 */
	//	, ClassNotFoundException, SQLException
	public List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//DTOを格納
			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString("birthday")));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}

	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				//DTO への格納 
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString("birthday")));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				System.out.println(employee);
				employees.add(employee);
			}
			return employees;

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			System.out.println(ConstantValue.EMP_COLUMN_NAME);
			while (resultSet.next()) {
				Employee employee = new Employee();
				Department department = new Department();
				//DTO への格納 
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				employee.setBirthday(sdf.parse(resultSet.getString("birthday")));
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);
				System.out.println(employee);
				employees.add(employee);
			}

			return employees;
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public void insert(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			preparedStatement.setObject(3, employee.getBirthday(), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();

			return;
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public Integer update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			preparedStatement.setObject(3, employee.getBirthday(), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			return employee.getEmpId();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出

		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.MSG_EMPLOYEE_DELETE);

			return empId;
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				throw new SystemErrorException(MSG_SYSTEM_ERROR, e);//独自例外の送出
			}
		}
	}

}
